package hackerearth;

import java.util.Scanner;

/**
 * https://www.hackerearth.com/problem/algorithm/karan-and-even-numbers-reloaded
 * /
 * 
 * @author NRMKMac
 *
 */
public class KaranAndEvenNumbersReloaded {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in);) {
			long numbers;
			while (true) {
				numbers = in.nextLong();
				if (numbers == -1) {
					break;
				}
				if ((numbers & 1) == 0) {
					System.out.println(numbers);
				}
			}
		}
	}
}
