package code;

import java.util.Scanner;

public class FindDigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(findDigits(sc.nextInt()));
	}
	static int findDigits(int num){
		int count =0;
		if(num == 0){
		return 0;
		}else if(num==10){
			return 1;
		}
		else{
			for(String temp: String.valueOf(num).split("")){
				if(temp.equals("0")){
					continue;
				}
				else if(num%Integer.valueOf(temp)==0){
					count++;
				}
				else{
					continue;
				}
			}
		}
		return count;
	}
	
	

}
