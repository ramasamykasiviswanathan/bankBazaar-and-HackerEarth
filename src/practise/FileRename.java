package practise;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;

/**
 * @author krama
 *
 */
public class FileRename {

	public static void main(String[] args) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			HashMap<String, Integer> hashMap = new HashMap<>();
			Path path = Paths.get("H:/Temp Movies/A.R.Rahman Tamil Discography - Complete Collections");
			Files.walkFileTree(path, new FileVisitor<Path>() {
				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					if (!Files.isHidden(file)) {
						String string = file.toAbsolutePath().toString(), fileName = file.getFileName().toString();
						System.out.println(fileName);

						int value = fileName.startsWith("-", 3) ? 5 : 3;
						string = "G" + string.substring(1, string.length() - fileName.length())
						+ fileName.substring(value);
						System.out.println(string);
						if (hashMap.containsKey(string)) {
							hashMap.replace(string, hashMap.get(string) + 1);
							
							string.concat(hashMap.get(string).toString());
						} else {
							hashMap.put(string, 00);
						}

						// I used the replace existing Enum, to remove redundant
						// data, in the dir.
						Files.copy(file, Paths.get(string), StandardCopyOption.REPLACE_EXISTING);
					}
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
					File file = new File("G" + dir.toAbsolutePath().toString().substring(1));
					file.mkdirs();
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
					// TODO Auto-generated method stub
					return FileVisitResult.CONTINUE;
				}
			});
		}
	}
}
