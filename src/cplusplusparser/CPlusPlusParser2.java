package cplusplusparser;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class CPlusPlusParser2
{
	private static LinkedList<String> contentList, outputContent;
	private static HashSet<String> hashSet = new HashSet<>();
	{
		hashSet.add("#");
		hashSet.add("(");
		hashSet.add("{");
		hashSet.add("}");
		hashSet.add("=");
		hashSet.add(":");
	}
	
	public static void main(String[] args) throws IOException
	{
		CPlusPlusParser2 parser = new CPlusPlusParser2();
		parser.fileReader("/Users/ramasamykasiviswanathan/MyDrive/C++Parser/Tandem C lang Code Samples/ODBC Sample App for Tandem NonStop SQLMX/OdbcApi.c");
		outputContent = contentList.stream().filter(CPlusPlusParser2::isValid).collect(Collectors.toCollection(LinkedList::new));
		Files.write(Paths.get("/Users/ramasamykasiviswanathan/MyDrive/C++Parser/ramaOutput.cpp"), outputContent.stream().flatMap(value -> Arrays.stream(value.split("\n")))
				.map(parser::codeIntent).reduce(String::concat).get().getBytes());
	}
	
	private static boolean blockCommentStarted;
	
	public static boolean isValid(String input)
	{
		if(blockCommentStarted)
		{
			if(input.endsWith("*/"))
			{
				return blockCommentStarted = false;
			}
			return true;
		}
		if(input.matches("(else[\\s])"))
		{
			return true;
		}
		if(input.startsWith("//"))
		{
			return true;
		}
		if(input.startsWith("/*"))
		{
			return blockCommentStarted = true;
		}
		for(String character : hashSet)
		{
			if(input.indexOf(character)>=0)
				return true;
		}
		return false;
	}
	
	private int openParanthesisCount = 0;
	public String codeIntent(String input)
	{
		input = input.trim();
		if(input.indexOf("}")>=0)
		{
			openParanthesisCount--;
			input = input + "\n";
		}
		int noOfTabs = openParanthesisCount;
		while (noOfTabs-->0 && !input.isEmpty())
		{
			input = "\t"+input;
		}
		if(input.indexOf("{")>=0)
		{
			openParanthesisCount++;
		}
		return input+"\n";
	}
	private void fileReader(String fileName)
	{
		Path filePath = Paths.get(fileName);
		if(Files.isReadable(filePath))
		{
			try
			{
				contentList =Files.lines(filePath, Charset.forName("ISO8859_15")).map(str -> str.replaceAll("[\\s\\t]+", " ").trim().concat("\n"))
						.map(temp -> {
							if(!temp.isEmpty() && !temp.startsWith("//") && temp.length() >1)
							{
								String replaceString="\n{\n";
								if(temp.startsWith("{"))
								{
									replaceString = "{\n";
									if(temp.trim().length() ==1)
									{
										replaceString = "{";
									}
								}
								temp = temp.replaceAll("[{]", replaceString);
								replaceString = "\n}\n";
								if(temp.startsWith("}"))
								{
									replaceString = "}\n";
									if(temp.trim().length() ==1)
									{
										replaceString = "}";
									}
								}
								temp = temp.replaceAll("[}]", replaceString);
							}
							return temp;
						})
						.collect(Collectors.toCollection(LinkedList::new));
				ListIterator<String> listIterator = contentList.listIterator();
				
				long OpenCurlyBracesCount = 0;
				StringBuilder builder = new StringBuilder();
				boolean isComment = false;
				while(listIterator.hasNext())
				{
					String next = listIterator.next();
					if(isComment)
					{
						if(next.trim().length()>1 &&next.trim().charAt(next.trim().length()-1)=='/')
						{
							isComment = false;
						}
						continue;
					}
					if(next.startsWith("//"))
					{
						continue;
					}
					if(next.startsWith("/*"))
					{
						isComment = true;
						continue;
					}
					long count = Arrays.stream(next.split("")).filter(val -> val.equals("(")).count();
					if(count > 0)
					{
						long closeBracesCount = Arrays.stream(next.split("")).filter(val -> val.equals(")")).count();
						if(count - closeBracesCount == 0 && OpenCurlyBracesCount == 0)
						{
							continue;
						}
						else
						{
							OpenCurlyBracesCount = OpenCurlyBracesCount + count - closeBracesCount;
							builder.append(next);
							listIterator.remove();
						}
					}
					else if(OpenCurlyBracesCount >= 0)
					{
						builder.append(next);
						listIterator.remove();
						long closeBracesCount = Arrays.stream(next.split("")).filter(val -> val.equals(")")).count();
						if(closeBracesCount > 0)
						{
							OpenCurlyBracesCount = OpenCurlyBracesCount - closeBracesCount;
						}
					}
					if(OpenCurlyBracesCount <= 0)
					{
						String temp = builder.toString().replaceAll("[\\s\\t]+", " ").trim().concat("\n");
						if(!temp.isEmpty() && !temp.startsWith("\\") && temp.length()>2)
						{
							temp = temp.replaceAll("[{]", "\n{");
							temp = temp.replaceAll("[}]", "\n}");
						}
						listIterator.add(temp);
						builder = new StringBuilder();
					}
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.err.println(filePath.getFileName()+" is not readable");
		}
	}
}
