package practise;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;

public class FileScan extends Thread {
	// static Path source = Paths.get("H:/Temp Movies/www.TamilRockers.net -
	// A.R.Rahman Tamil Discography - Complete Collections [Original Mp3 - VBR -
	// 320kbps - 6GB]");
	static final LinkedList<String> fileList = new LinkedList<>(), directoryList = new LinkedList<>();
	String directory = null;

	public FileScan(String name) {
		directory = name;
	}
	public static void main(String[] args) {
		new FileScan("C").start();
		new FileScan("D").start();
		new FileScan("E").start();
		new FileScan("F").start(); 
		new FileScan("G").start();
		new FileScan("H").start();
	}

	/*public static void main(String[] args) throws IOException {
		File file = new File("E:/fileList.txt");
		try (FileWriter fileWriter = new FileWriter(file)) {
			for (String directory : new String[] { "C:/", "D:/", "E:/", "F:/", "G:/", "H:/" }) {
				Path source = Paths.get(directory);
				Files.walkFileTree(source, new FileVisitor<Path>() {
					String pathName;

					@Override
					public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
						// System.out.println("FileRename.main(...).new
						// FileVisitor() {...}.preVisitDirectory()");
						if (dir.isAbsolute())
							pathName = dir.toString();
						else
							pathName = dir.toAbsolutePath().toString();
						directoryList.add(pathName);
						fileWriter.write(String.format("Dir Path:%s /t File System:%s", pathName, dir.getFileSystem()));
						System.out
								.println(String.format("Dir Path:%s /t File System:%s", pathName, dir.getFileSystem()));
						return FileVisitResult.CONTINUE;
					}

					@Override
					public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
						// System.out.println("FileRename.main(...).new
						// FileVisitor() {...}.visitFile()");
						if (file.isAbsolute())
							pathName = file.toString();
						else
							pathName = file.toAbsolutePath().toString();
						fileList.add(String.format("File Path:%s /t File System: %s", pathName, file.getFileSystem()));
						System.out.println(
								String.format("File Path:%s /t File System: %s", pathName, file.getFileSystem()));
						return FileVisitResult.CONTINUE;
					}

					@Override
					public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
						// System.out.println("FileRename.main(...).new
						// FileVisitor() {...}.visitFileFailed()");
						System.out.println(file.toAbsolutePath().toString());
						return FileVisitResult.CONTINUE;
					}

					@Override
					public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
						
						 * System.out.println("FileRename.main(...).new
						 * FileVisitor() {...}.postVisitDirectory()");
						 * System.out.println(dir.toAbsolutePath().toString());
						 
						return FileVisitResult.CONTINUE;
					}
				});
				fileList.forEach(value -> System.out.println(value));
			}
		}
	}*/

	@Override
	public void run() {
		File file = new File("e:"+File.separator+directory+"fileList.txt");
		try (FileWriter fileWriter = new FileWriter(file)) {
			System.out.println(String.format("Directory is: %s /n Thread Name is: %s, /t and Priority is: %d, /n Thread state is:%s /n",
					directory,getName(),getPriority(),getState()));
			Path source = Paths.get(directory+":"+File.separator);
			Files.walkFileTree(source, new FileVisitor<Path>() {
				String pathName;
				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
					if (dir.isAbsolute())
						pathName = dir.toString();
					else
						pathName = dir.toAbsolutePath().toString();
					String format = String.format("Directory:%s", pathName);
					directoryList.add(format);
					System.out.println(format);
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					if (file.isAbsolute())
						pathName = file.toString();
					else
						pathName = file.toAbsolutePath().toString();
					String format = String.format("File:%s", pathName);
					fileList.add(format);
					System.out
							.println(format);
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
					System.out.println(file.toAbsolutePath().toString());
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
					return FileVisitResult.CONTINUE;
				}
			});
				fileList.forEach(value -> {
					try{
						fileWriter.write(value);
					}
					catch (Exception e){
						e.printStackTrace();
					}
				});
				fileList.forEach(value -> {
					try{
						fileWriter.write(value);
					}
					catch (Exception e){
						e.printStackTrace();
					}
				});
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
