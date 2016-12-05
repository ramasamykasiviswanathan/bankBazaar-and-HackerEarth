package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeHamburgDeRahulEnhanced {

	public static void main(String... args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in))) {
			final String reciepe = br.readLine();
			long count = 0, rubels;
			boolean notDebt = true;

			short nB, nS, nC, pB, pS, pC;
//			char characterPossibleValues[] = { 'B', 'S', 'C' };
			String[] inputs = br.readLine().split("\\s");
			nB = shortValueOfString(inputs[0]);
			nS = shortValueOfString(inputs[1]);
			nC = shortValueOfString(inputs[2]);

			inputs = br.readLine().split("\\s");
			pB = shortValueOfString(inputs[0]);
			pS = shortValueOfString(inputs[1]);
			pC = shortValueOfString(inputs[2]);

			rubels = Long.parseLong(br.readLine());

			// selling items to the shop.
			rubels = rubels + (nB * pB) + (nS * pS) + (nC * pC);

			// count of each items needed for the shop.
			nB = (short) (reciepe.length() - reciepe.replaceAll("B","").length());
			nS = (short) (reciepe.length() - reciepe.replaceAll("S", "").length());
			nC = (short) (reciepe.length() - reciepe.replaceAll("C", "").length());
			
			/*nB = reciepeItemsOccurrence(characterPossibleValues[0], reciepe);
			nS = reciepeItemsOccurrence(characterPossibleValues[1], reciepe);
			nC = reciepeItemsOccurrence(characterPossibleValues[2], reciepe);*/

			while (notDebt) {
				rubels -= ((nB * pB) + (nS * pS) + (nC * nC));
				if (rubels >= 0) {
					++count;
				} else {
					notDebt = false;
				}
			}
			System.out.println(count);
		}
	}

	private static short shortValueOfString(String input) {
		return Short.parseShort(input);
	}

	private static short reciepeItemsOccurrence(char inputCharacter,
			String reciepe) {
		short count = 0;
		for (char ch : reciepe.toUpperCase().toCharArray()) {
			if (inputCharacter == ch)
				++count;
		}
		return count;
	}
}
