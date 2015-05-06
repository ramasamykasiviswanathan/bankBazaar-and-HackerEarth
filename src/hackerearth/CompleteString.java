package hackerearth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * A string is said to be complete if it contains all the characters from a to z. Given a string, check if it complete or not.
 */

public class CompleteString {

	public static void main(String[] args) {
		try{
			Scanner scanner = new Scanner(System.in);
			int _testCase = scanner.nextInt();
			while(_testCase>0){
				--_testCase;
				String[] split = scanner.next().trim().split("");
				HashSet<String> hashSet = new HashSet<String>(Arrays.asList(split));
				//hashSet.size() == 26 ? System.out.println("YES"):System.out.println("NO");
				if(hashSet.size()==26)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
			scanner.close();
		}
		catch(Exception e){
			
		}
	}

}
