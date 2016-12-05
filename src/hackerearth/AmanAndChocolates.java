package hackerearth;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
 
public class AmanAndChocolates {
 
	public static void main(String[] args) throws IOException {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int testcase = integerValue(br.readLine()), maxValue;
			StringBuilder builder = new StringBuilder(testcase);
			LinkedList<Integer> integers = new LinkedList<>();
			do{
				integers.add(integerValue(br.readLine()));
			} 
			while(--testcase>0);
//			maxValue = Collections.max(integers);
			for(int number : integers){
				if(number > 6 )
					builder.append(countZeros(number));
				else if (number == 5 || number == 6)
					builder.append(1);
				else
					builder.append(0);
					builder.append("\n");
			}
			System.out.println(builder.toString());
		}
	}
	private static Integer integerValue(String input){
		return Integer.valueOf(input.trim());
	}
	private static ArrayList<BigInteger> populateMap(int maxValue) {
		ArrayList<BigInteger> factorValues = new ArrayList<>(maxValue);
		ListIterator<BigInteger> listIterator = factorValues.listIterator();
		listIterator.add(new BigInteger("120"));
		for(int i = 7; i <= maxValue ; i++){
			BigInteger value = new BigInteger(listIterator.previous().toString());
			value = value.multiply(new BigInteger(String.valueOf(i)));
			listIterator.next();
			listIterator.add(value);
		}
		return factorValues;
	}
	
	private static String countZeros(int maxValue){
		BigInteger bigInteger = new BigInteger("720");
		for(int i=7 ; i <=maxValue ; ++i){
			bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
		}
		return count(bigInteger);
	}
	
	private static String count(BigInteger input){
		String string = input.toString();
		return String.valueOf(string.length() - string.replaceAll("0", "").length());
	}
}
