package roofAndFloor;

import java.util.Scanner;
import java.util.Stack;

public class Problem1 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testCase = scanner.nextInt();
			Stack<Short> stack = new Stack<Short>();
			while (testCase-- > 0) {
				short value = scanner.nextShort();
				if ((stack.isEmpty() && value == 0) || value != 0) {
					stack.push(value);
				}
				else{
					stack.pop();
				}
			}
			testCase = 0;
			for (Short value : stack) {
				testCase += value;
			}
			System.out.println(testCase);
		}
	}
}
