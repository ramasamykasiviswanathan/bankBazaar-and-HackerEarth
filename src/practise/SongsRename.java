package practise;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class SongsRename
{
	public static void main(String[] args)
	{
		File file = new File("A:\\tixatiDownloads\\Taylor Swift - iTunes Discography");		
		new SongsRename().spawnThread(file);
	}
	
	public void spawnThread(File file){
		for(File myfile:file.listFiles(File::isDirectory))
		{
			spawnThread(myfile);
		}
		new Thread(()->{
			for(File files : file.listFiles(File::isFile))
			{
				try
				{
//					String[] split = files.getName().split("\\.");
//					String concat = "B".concat(files.getParent().substring(1)).concat("\\").concat(
//							split.length>2? files.getName().substring(split[0].length()+1).trim():files.getName());
					String concat = "B".concat(files.getParent().substring(1)).concat("\\").concat(files.getName().substring(2).trim());
					Files.createDirectories(Paths.get(concat));
					System.out.println(files.getAbsolutePath()+"-->"+concat);
					Files.copy(Paths.get(files.getAbsolutePath()), Paths.get(concat), 
							StandardCopyOption.REPLACE_EXISTING);
				} catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
	
}
