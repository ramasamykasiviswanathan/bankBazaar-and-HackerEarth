package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DateWithAnvi {

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in))) {
			int testCase = Integer.valueOf(br.readLine());
			while (testCase > 0) {
				--testCase;
				String word = br.readLine();
				boolean repetativeWord = false;
				for (int i = 0; i < word.length(); ++i) {
					if (i + 1 < word.length()
							&& word.charAt(i) == word.charAt(i + 1)) {
						repetativeWord = true;
						break;
					}
				}
				if (repetativeWord)
					System.out.println("SLAP");
				else
					System.out.println("KISS");
			}
		}
	}

}
