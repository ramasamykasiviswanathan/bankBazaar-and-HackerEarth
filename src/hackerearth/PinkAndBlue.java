package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class PinkAndBlue {
	static List<String> arraylist;
	static int inversions;
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			String [] _N_M = br.readLine().split(" ");
			int _N = Integer.valueOf(_N_M[0]), _M = Integer.valueOf(_N_M[1]);
			arraylist = Arrays.asList(br.readLine().split(" "));
			
			while(_M>0){
				--_M;
				int boy=0,girl=0;
				for(String temp: br.readLine().split(" ")){
					switch(arraylist.get(Integer.parseInt(temp)-1)){
						case "B":
							++boy;
							break;
						case "G":
							++girl;
							break;
					}
				}
				int difference = boy-girl;
				if(difference!=0)
					inversions+=(Math.abs(difference)/2);
			}
			if (inversions==0)
				System.out.println("Not possible");
			else
				System.out.println(inversions);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


/**
 * Xenny was a teacher and he had N students. The N children were sitting in a room. Each child was wearing a white T-shirt, with a unique number from the range 1 to N written on it. T-Shirts of pink and blue color were to be distributed among the students by Xenny. This made the students very happy.

Xenny felt that a random distribution of T-Shirts would be very uninteresting. So, he decided to keep an interesting condition:

Every student would get a T-Shirt that is of a different color than his/her friends. That is, if X and Y are friends and X has a Pink T-Shirt, then Y should compulsorily have a Blue T-Shirt, and vice-versa.

Also, Xenny had a belief that Boys should wear blue T-Shirts and Girls should wear pink T-Shirts. If a boy was given a pink T-Shirt or a girl was given a Blue T-Shirt, he called it an inversion.

So, Xenny wanted to distribute T-Shirts in the above-mentioned interesting manner and also wanted to minimize "inversions". Help him solve the task.

Note: There are no disjoint groups of friends in the room. That is, 2 distinct groups with finite number of students do not exist, but exactly 1 group of students exists in the given situation.

Input Format:
First line contains 2 space-separated integers - N and M - number of students and number of friendships present respectively.

Second line consists of N space-separated characters, where ith character denotes the gender of the ith student. B: Boy, G: Girl.

M lines follow. Each line consists of 2 space-separated integers, u and v, showing that u is a friend of v and vice-versa.

Output Format:
If Xenny could distribute the T-Shirts in the desired way, print the minimum number of inversions required.
Else, print "Not possible".

Constraints:
1 ≤ N ≤ 105
1 ≤ M ≤ 105
1 ≤ u, v ≤ N

Colours of T-Shirt are represented by uppercase characters 'B' and 'G'

Sample Input (Plaintext Link)
3 2
B G B
1 2
1 3
Sample Output (Plaintext Link)
1
Explanation
Student 1 can be given a Blue T-Shirt. Hence, Student 2 and 3 would receive Pink T-Shirts.

Since, Student 3 is a Boy and has received a Pink T-Shirt, number of inversions = 1.

 */