package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;

/**
 * @author RAMA
 * https://www.hackerearth.com/problem/algorithm/subtraction-game-theory/
 */
public class SumOfDigits {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			short numbers = Short.valueOf(br.readLine());
			LinkedList<String> stringNumbers = new LinkedList<>();
			while(numbers-->0){
				stringNumbers.add(br.readLine());
			}
			BigInteger sumofSODOfDigits =new BigInteger("0"),sODOfSumOfAllDigits = new BigInteger("0"), nine=new BigInteger("9");
			for(String temp:stringNumbers){
				sumofSODOfDigits = sumofSODOfDigits.add(sOD(temp));
				sODOfSumOfAllDigits = sODOfSumOfAllDigits.add(new BigInteger(temp));
			}
			sumofSODOfDigits = sumofSODOfDigits.remainder(nine);
			sODOfSumOfAllDigits = sODOfSumOfAllDigits.remainder(nine);
			System.out.println(sumofSODOfDigits.subtract(sODOfSumOfAllDigits));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static BigInteger sOD(String value){
		BigInteger bigInteger = new BigInteger("0");
		for(String temp:value.split("(?!^)")){
			bigInteger = bigInteger.add(new BigInteger(temp));
		}
		return bigInteger;
	}
}
