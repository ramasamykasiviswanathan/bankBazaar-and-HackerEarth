package hackerearth.ibm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2 {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in))) {
			long days = stringToInt(br.readLine());
			StringBuilder builder = new StringBuilder();
			while (days-- > 0) {
				String[] consolidatedInputs = br.readLine().split("\\s+");
				long x = stringToInt(consolidatedInputs[0]), y = stringToInt(consolidatedInputs[1]), k = stringToInt(consolidatedInputs[2]), gcf;
				boolean doesNotExists = false;
				gcf = gcfEuclid(Math.max(x, y), Math.min(x, y));
				--k;
				while (k-- > 0) {
					if (gcf != 1) {
						for (long i = gcf - 1; i > 0; i--) {
							if (gcf % i == 0) {
								gcf = i;
								break;
							} else {
								continue;
							}
						}
					} else {
						doesNotExists = true;
						break;
					}
				}
				if (doesNotExists) {
					builder.append("No crymeth today");
				} else {
					builder.append(gcf);
				}
				builder.append("\n");
			}
			System.out.println(builder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static long stringToInt(String input) {
		return Integer.parseInt(input, 10);
	}

	private static long gcfEuclid(long x, long y) {
		long remainder = 0L;
		while (y != 0) {
			remainder = x % y;
			x = y;
			y = remainder;
		}
		return x;
	}
}
