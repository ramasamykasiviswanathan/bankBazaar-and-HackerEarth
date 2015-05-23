package hackerearth.roofAndFloor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Problem2 {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in))) {
			short T = (short) stringToLong(br.readLine());
			StringBuilder builder = new StringBuilder();
			while (T-- > 0) {
				int N = (int) stringToLong(br.readLine());
				ArrayDeque<Long> arrayDeque = new ArrayDeque<Long>(N);
				for (String valueToBeAdded : br.readLine().split("\\s+")) {
					arrayDeque.addLast(stringToLong(valueToBeAdded));
				}

				long Madhav = arrayDeque.pollFirst(), indexOfMadav = 1, Riya = 0, indexOfRiya = 0;
				if (!arrayDeque.isEmpty()) {
					Riya = arrayDeque.pollLast();
					++indexOfRiya;
				}
				while (!arrayDeque.isEmpty()) {
					/*if (Madhav <= 1 && Riya <= 0 && arrayDeque.size() == 1) {
						++indexOfMadav;
						break;
					}*/
					long times = Madhav /2, remainer = Madhav%2;
					Madhav = remainer;
					Riya -=times;
					while (Riya < 0) {
						Riya += arrayDeque.pollLast();
						++indexOfRiya;
					}
					while (Madhav <= 1 ) {
						Madhav += arrayDeque.pollFirst();
						++indexOfMadav;
					}
				}
				builder.append(indexOfMadav + " " + indexOfRiya);
			}
			System.out.println(builder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static long stringToLong(String input) {
		return Long.valueOf(input);
	}
}
