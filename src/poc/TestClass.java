package poc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TestClass {
	public static void main(String[] args) {
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
		{
			final ArrayList<String> expandedString = new TestClass().expandedString(reader.readLine().trim().toCharArray());
			long testcase = Long.valueOf(reader.readLine());
			StringBuffer buffer = new StringBuffer();
			int k;
			while(testcase-->0){
				k = Integer.valueOf(reader.readLine())-1;
				if(0<=k && expandedString.size()>k)
				  buffer.append(expandedString.get(k));
				else
					buffer.append("-1");
				buffer.append("\n");
			}
			System.out.println(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private ArrayList<String> expandedString(final char[] compressedString)
	{
		int length = compressedString.length;
		ArrayList<String> arrayList = new ArrayList<>();
		for(int i=0; i< length;)
		{
			String key = String.valueOf(compressedString[i]);
			int value = Integer.valueOf(String.valueOf(compressedString[++i]));
			++i;
			while(value --> 0)
			{
				arrayList.add(key);
			}
		}
		return arrayList;
	}
}
