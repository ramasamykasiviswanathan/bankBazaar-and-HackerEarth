package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LeHamburgDeRahul {

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in))) {
			final String reciepe = br.readLine();
			long count = 0,rubels ;
			boolean notDebt = true;
			LinkedList<Integer> numbersList = new LinkedList<>(), costList = new LinkedList<>();
			for (String temp : br.readLine().split("\\s"))
				numbersList.add(Integer.valueOf(temp.trim()));
			for (String temp : br.readLine().split("\\s"))
				costList.add(Integer.valueOf(temp));
			rubels = Long.parseLong(br.readLine());

			while (notDebt) {
				++count;
				for (String selector : reciepe.split("")) {
					switch (selector) {
						case "B": {
							rubels = useItem((short) 0, numbersList, costList, rubels);
							if(rubels<0)
								notDebt=false;
							break;
						}
						case "S": {
							rubels = useItem((short) 1, numbersList, costList, rubels);
							if(rubels<0)
								notDebt=false;
							break;
						}
						case "C": {
							rubels = useItem((short) 2, numbersList, costList, rubels);
							if(rubels<0)
								notDebt=false;
							break;
						}
					}
					if(!notDebt){
						--count;
						break;
					}
				}
			}
			System.out.println(count);
		}
	}
	private static long useItem(short index,LinkedList<Integer> numbersList,LinkedList<Integer> costList, long rubels){
		int quantityPresent = numbersList.remove(index);
		if(quantityPresent-1>=0){
			numbersList.add(index, quantityPresent-1);
		}
		else{
			rubels = buyItem(index, numbersList, costList, rubels);
		}
		return rubels;
	}
	
	private static long buyItem(short index,LinkedList<Integer> numbersList,LinkedList<Integer> costList, long rubels){
		numbersList.add(index, 0);
		rubels -= costList.get(index);
		return rubels;
	}
}
