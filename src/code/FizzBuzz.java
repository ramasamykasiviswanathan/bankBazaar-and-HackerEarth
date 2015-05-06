package code;

import java.util.Scanner;

public class FizzBuzz {

	/*public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in);) {
			long number = scanner.nextLong();
			for (long i = 1; i <= number; i++) {
				if (i % 15 == 0) {
					System.out.println("FizzBuzz");
				} else if (i % 3 == 0) {
					System.out.println("Fizz");
				} else if (i % 5 == 0) {
					System.out.println("Buzz");
				} else {
					System.out.println(i);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)){
			short s = scanner.nextShort();
			StringBuilder stringBuilder = new StringBuilder();
			scanner.nextLine();
			for(String temp:scanner.nextLine().split("\\s")){
				long l = Long.valueOf(temp);
				for(long i=1;i<=l;i++){
					if (i % 15 == 0) {
						stringBuilder.append("FizzBuzz");
					} else if (i % 3 == 0) {
						stringBuilder.append("Fizz");
					} else if (i % 5 == 0) {
						stringBuilder.append("Buzz");
					} else {
						stringBuilder.append(i);
					}
					stringBuilder.append("\n");
				}
			}
			System.out.println(stringBuilder);
		}
	}
}
