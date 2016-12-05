package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

/**
 * https://www.hackerearth.com/problem/algorithm/prom-night/
 * @author RAMA
 *
 */
public class PromNight {

	public static void main(String[] args) throws IOException {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			short testCase = getShortValue(br.readLine());
			StringBuilder builder = new StringBuilder(testCase);
			do{
				final String BOYS = br.readLine().trim(), GIRLS = br.readLine().trim();
				assert BOYS.length() <= GIRLS.length();
				if(BOYS.length() <= GIRLS.length())
					builder.append("No");
				else{
					ArrayDeque<Short> boys = populateArrayQueue(BOYS), girls = populateArrayQueue(GIRLS);
				}
			}
			while(--testCase>0);
		}
	}
	
	private static ArrayDeque<Short> populateArrayQueue(String input){
		ArrayDeque<Short> values = new ArrayDeque<>(1);
		for(String temp :  input.split("//s"))
			values.add(getShortValue(temp));
		return values;
	}
	
	private static short getShortValue(String input){
		return Short.valueOf(input.trim());
	}
}
