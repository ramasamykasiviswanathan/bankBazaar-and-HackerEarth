package code;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class TopPhrases
{

	public static void main(String[] args)
	{
		try(Scanner scanner = new Scanner(System.in))
		{
			String replaceAll = scanner.nextLine().replaceAll("\\\\","/");
			mostFrequentPhrases(Paths.get(replaceAll));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public static Set<String> mostFrequentPhrases(Path fileLocation) throws IOException
	{
		Set<String> frequentPhrases = null;
		if(null != fileLocation && Files.isReadable(fileLocation))
		{
			final Set<String> values= new HashSet<>();
			Files.lines(fileLocation,StandardCharsets.UTF_8).map(v-> v.split("[|]")).flatMap(Arrays::stream).collect(Collectors.toConcurrentMap(key->key, value -> 1, Integer::sum))
			.entrySet().stream().filter(v-> v.getValue()>0).forEach(v->values.add(v.getKey()));
//			.collect(Collectors.mapping(String::valueOf, Collectors.toSet()));
			frequentPhrases = values;
		}
		return frequentPhrases;
	}
}
