package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class MonksEncounterwithPolynomial {

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in))) {
			int testcase = getInt(bufferedReader.readLine().trim());
			while (testcase-- > 0) {
				LinkedList<Integer> a = new LinkedList<Integer>();
				for (String temp : bufferedReader.readLine().split("\\s+")) {
					a.add(getInt(temp));
				}
				a.addLast(a.pollLast() - a.pollLast());
				int value = 0;
				for (int i = 0; i <= 100000; i++) {
					if ((a.getFirst() * i * i + a.get(1) * i) >= a.getLast()) {
						value = i;
						break;
					}
				}
				builder.append(value);
				builder.append("\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			System.out.println(builder.toString().trim());
		}
	}

	private static Integer getInt(String input) {
		return Integer.valueOf(input);
	}
}
