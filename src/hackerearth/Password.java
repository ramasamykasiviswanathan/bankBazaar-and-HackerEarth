package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * https://www.hackerearth.com/problem/algorithm/password-1/
 * 
 * @author NRMKMac
 *
 */
public class Password {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in))) {
			int testCase = Integer.valueOf(br.readLine());
			ArrayList<String> arrayList = new ArrayList<String>(testCase);
			while (testCase > 0) {
				--testCase;
				StringBuilder trim = new StringBuilder(br.readLine().trim());
				if (trim.length() % 2 == 0) {
					continue;
				} else if (arrayList.contains(trim.reverse().toString())) {
					System.out.println(trim.length() + " "
							+ trim.charAt(trim.length() / 2));
					break;
				} else {
					arrayList.add(trim.reverse().toString());
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
