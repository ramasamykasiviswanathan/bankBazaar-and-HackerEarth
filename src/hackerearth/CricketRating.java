package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CricketRating {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in))) {
			int testcase = Integer.parseInt(br.readLine());
			int max_so_far = 0, max_ending_here = 0;
			if (testcase > 0) {
				for (String temp : br.readLine().split("\\s+")) {
					max_ending_here = max_ending_here
							+ Integer.parseInt(temp, 10);
					if (max_ending_here < 0) {
						max_ending_here = 0;
					}
					if (max_so_far < max_ending_here) {
						max_so_far = max_ending_here;
					}
				}
			}
			System.out.println(max_so_far);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
