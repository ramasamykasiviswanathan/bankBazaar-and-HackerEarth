package hackerearth.ibm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1 {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in))) {
			short testCase = (short) stringToInt(br.readLine());
			StringBuilder stringBuilder = new StringBuilder();
			while (testCase-- > 0) {
				String[] combinedValues = br.readLine().split("\\s+");
				String mainString = combinedValues[0].substring(0,
						stringToInt(combinedValues[1])), split = null;
				boolean isFound = false;
				int i;
				if (mainString.length() % 2 == 0) {
					i = (mainString.length() / 2);
				} else {
					i = (mainString.length() + 1) / 2;
				}
				for (; i > 1; i--) {
					int maxLength = 0;
					split = mainString.substring(0, i);
					if (mainString.indexOf(split, split.length()) >= split
							.length()) {
						for (String temp : mainString.split(split)) {
							maxLength = temp.length() > maxLength ? temp
									.length() : maxLength;
						}
						if (split.length() >= maxLength) {
							isFound = true;
							break;
						}
					}
				}
				if (isFound) {
					stringBuilder.append(split);
				} else {
					stringBuilder.append("Puchi is a cheat!");
				}
				stringBuilder.append("\n");
			}
			System.out.println(stringBuilder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int stringToInt(String input) {
		return Integer.parseInt(input, 10);
	}
}
