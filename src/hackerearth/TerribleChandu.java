package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;

public class TerribleChandu {

	public static void main(String[] args) throws IOException {
		try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));){
			int testcase = Integer.parseInt(bufferedReader.readLine());
			StringBuilder stringBuilder = new StringBuilder(1);
			do{
				//old recursive Approach
				/*stringBuilder.append(recursive(bufferedReader.readLine().trim()));*/
				
				ArrayDeque<String> arrayDeque =	new ArrayDeque<>(Arrays.asList(bufferedReader.readLine().trim().split("")));
				Iterator<String> iterator = arrayDeque.descendingIterator();
				while(iterator.hasNext()){
					stringBuilder.append(iterator.next());
				}
				stringBuilder.append("\n");
			} while(--testcase>0);
			
			System.out.println(stringBuilder.toString().trim());
		}
	}
	
	/*public static String recursive(String input){
		if(input.length() < 2){
			return input;
		}
		return recursive(input.substring(1)) + input.charAt(0);
	}*/
}
