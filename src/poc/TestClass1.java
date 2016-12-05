package poc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TestClass1 {
	public static void main(String[] args) {
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
		{
			final Map<Character, Integer> map = new TestClass1().expandedString(reader.readLine().trim().toCharArray());
			long testcase = Long.valueOf(reader.readLine());
			StringBuffer buffer = new StringBuffer();
			int k;
			while(testcase-->0){
				k = Integer.valueOf(reader.readLine());
				String value = "-1";
				for(Character character : map.keySet())
				{
					k -= map.get(character);
					if(k<=0){
						value = String.valueOf(character);
						break;
					}
				}
				buffer.append(value).append("\n");
			}
			System.out.println(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Map<Character,Integer> expandedString(final char[] compressedString)
	{
		int length = compressedString.length;
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i< length;)
		{
			char key = compressedString[i];
			int value = Integer.valueOf(String.valueOf(compressedString[++i]));
			++i;
			if(map.containsKey(key))
			{
				value = value + map.get(key);
			}
			map.put(key, value);
		}
		return map;
	}
	
}