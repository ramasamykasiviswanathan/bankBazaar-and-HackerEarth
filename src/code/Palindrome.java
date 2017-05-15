package code;

import java.util.Scanner;

import code.StaticAndNonStaticClass.staticInnerClass;

public class Palindrome
{
	public static void main(String[] args)
	{
		try(Scanner scanner = new Scanner(System.in))
		{
			System.out.println(isPalindrome(scanner.next()) ? "Palindrome":"Not a Palindrome");
		}
	}
	
	/**
	 * <p> Function to validate whether the given string is palindrome or not</p> 
	 * BigOh would be O(log n)
	 * @param {@link CharSequence}
	 * @return {@link Boolean}
	 */
	public static boolean isPalindrome(final CharSequence value)
	{
		boolean palindrome = true;
		if(null != value)
		{
			int startIndex = -1, endIndex= value.length();
			while(++startIndex < --endIndex)
			{
				if(value.charAt(startIndex)!= value.charAt(endIndex))
				{
					palindrome = false;
					break;
				}
			}
		}
		else{
			palindrome = false;
		}
		return palindrome;
	}
}
