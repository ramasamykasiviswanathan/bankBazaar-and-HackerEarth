package hackerearth;

import java.util.Scanner;

public class FindthemultiplesGolf {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)){
			StringBuilder builder = new StringBuilder();
			short testCase = scanner.nextShort(),count=0;
			while(testCase>0){
				--testCase;
				if(scanner.nextLong()%3==0){
					++count;
				}
			}
			System.out.println(count);
		}
	}

}
