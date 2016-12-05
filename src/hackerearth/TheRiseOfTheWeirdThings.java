package hackerearth;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;


/**
 * @author RAMA
 * 
 * <p>https://www.hackerearth.com/problem/algorithm/the-rise-of-the-weird-things-1/</p>
 *
 */
public class TheRiseOfTheWeirdThings {

	public static void main(String[] args) throws IOException {
		try(Scanner scanner = new Scanner(System.in)){
			short testCase = scanner.nextShort();
			LinkedList<Short> even = new LinkedList<>(), odd = new LinkedList<>();
			while(testCase-->0){
				short temp = scanner.nextShort();
				if((temp & 1) == 1)
					odd.offer(temp);
				else
					even.offer(temp);
			}
		
		}
	}

}

