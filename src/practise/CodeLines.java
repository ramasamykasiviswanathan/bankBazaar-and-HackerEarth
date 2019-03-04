package practise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;

public class CodeLines {

	public static void main(String[] args) throws Exception {
		new CodeLines().calculateCodeLines("/Users/ramasamykasiviswanathan/MyDrive/workspace/eclipseWorkspace/sample/src/main/java/");
	}

	public long calculateCodeLines(String path) throws Exception {
		Path paths = Paths.get(path);
		long count = Files.walk(paths).filter(Files::isReadable).filter(((Predicate<Path>)Files::isDirectory).negate()).map(t -> {
			Optional<List<String>> optional = Optional.empty();
			System.out.println(t.toString());
			try {
				if(StringUtils.endsWithIgnoreCase(t.toString(), ".java"))
					optional = Optional.ofNullable(Files.readAllLines(t));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return optional;
		}).filter(Optional::isPresent).map(Optional::get).flatMap(List::stream).map(StringUtils::trimToEmpty)
				.filter(Objects::nonNull).count();
//				.map(String::strip).filter(((Predicate<String>) String::isEmpty).negate()).count();
		System.out.println(count);
		return count;
	}
}
