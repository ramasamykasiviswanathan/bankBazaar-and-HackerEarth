package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheCount {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in))) {
			short count = Short.valueOf(br.readLine());
			StringBuilder stringBuilder = new StringBuilder();
			while (count > 0) {
				--count;
//				String[] splitValues = br.readLine().split("\\p{Blank}+");
//				stringBuilder.append(splitValues.length + "\n");
				StringTokenizer tokenizer = new StringTokenizer(br.readLine().trim());
				stringBuilder.append(tokenizer.countTokens()+"\n");
			}
			System.out.println(stringBuilder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
