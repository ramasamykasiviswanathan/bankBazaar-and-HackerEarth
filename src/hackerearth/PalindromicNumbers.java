package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromicNumbers {

	/**
	 * Using String Builder for reversing a string is faster than manupulating and creating a reverse string.
	 * @param args
	 */
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
			int testCase = Integer.valueOf(br.readLine());
			StringBuilder builder = new StringBuilder(testCase);
			while(testCase>0){
				--testCase;
				final int[] limits = returnInteger(br.readLine().split(" "));
				int i=limits[0],count = 0;
				for(;i<=limits[1];++i){
//					if(Integer.toString(i).equals(reverse(Integer.toString(i)))){
//						++count;
//					}
					if(Integer.toString(i).equals(reverse1(i))){
						++count;
					}
				}
				builder.append(count+"\n");
			}
			System.out.println(builder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static int[] returnInteger(String[] toIntegerArray){
		int[] returnInt = new int[2];
		returnInt[0] = Integer.valueOf(toIntegerArray[0]);
		returnInt[1] = Integer.valueOf(toIntegerArray[1]);
		return returnInt;
	}

	private static String reverse(String input){
		StringBuilder stringBuilder = new StringBuilder(2);
		for(int i=input.length()-1;i>=0;--i){
			stringBuilder.append(input.charAt(i));
		}
		return stringBuilder.toString();
	}
	
	private static String reverse1(int input){
		return new StringBuilder().append(input).reverse().toString();
	}
}
