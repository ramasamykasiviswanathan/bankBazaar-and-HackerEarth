package hackerearth;

import java.util.Scanner;

public class SumOfTwoNumbers {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)){
			long testcase = scanner.nextLong();
			StringBuilder builder = new StringBuilder();
			while(testcase>0){
				--testcase;
				builder.append(scanner.nextLong()+scanner.nextLong()).append("\n");
			}
			System.out.println(builder.toString());
		}
	}

}
