package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SkippingSum {

	static ArrayList<Integer> arrayList ;
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
//			int _count=arrayList.get(0), _queries = arrayList.get(1);
			int _queries = Integer.valueOf(br.readLine().split(" ")[1]);
			arrayList = getIntArray(br.readLine());
			while(_queries>0){
				String _variables[] = br.readLine().split(" ");
				System.out.println(defSkippingSum1(Integer.valueOf(_variables[0]), Integer.valueOf(_variables[1]), Integer.valueOf(_variables[2])));
				--_queries;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static int defSkippingSum(int _L,int _R,int _K){
		int sum=0;
		for( ; _L<=_R ; _L=_L+_K){
			sum += arrayList.get(_L-1);
		}
		return sum;
	}
	
	private static int defSkippingSum1(int _L,int _R, int _K){
		int sum =0;
		while(_L<=_R){
			sum += arrayList.get(_L-1);
			_L+=_K;
		}
		return sum;
	}
	
	private static ArrayList<Integer> getIntArray(String temp){
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(String _count:temp.split(" "))
			result.add(Integer.valueOf(_count.trim()));
		return result;
	}
}



/**
 * You are given an array of N integers A[1] , A[2] , ... , A[N] . You have to answer Q queries. Each query consists of 3 integers L, R and K. For each query, you have to find the value of the Skipping Sum in the following manner :

       def skipping_sum(L,R,K) :
              sum = 0
              while L <= R :
                    sum = sum + A[L]
                    L = L + K 
              return sum

Input

The first line consists of 2 space separated integers N and Q. The next line consists of N space separated integers, the ith integer being A[i]. Then, Q lines follow, each line consisting of 3 space separated integers L, R and K.


Output

Print the answer to each query on a new line.


Constraints

1 ≤ N ≤ 105
1 ≤ Q ≤ 105
0 ≤ A[i] ≤ 105
1 ≤ L ≤ R ≤ N
1 ≤ K ≤ 10
NOTE:
We are using 1-based indexing for array A.

Sample Input (Plaintext Link)
8 6
5 4 2 1 7 9 10 9
1 8 1
1 8 2
4 8 9
3 7 2
3 7 3
3 7 4
Sample Output (Plaintext Link)
47
24
1
19
11
12
Explanation
For query 1 : A[1] + A[2] + A[3] + A[4] + A[5] + A[6] + A[8] = 47
For query 2 : A[1] + A[3] + A[5] + A[7] = 24
For query 3 : A[4] = 1
For query 4 : A[3] + A[5] + A[7] = 19
For query 5 : A[3] + A[6] = 11
For query 6 : A[3] + A[7] = 12

 */



/*public class SkippingSum {

	static ArrayList<Integer> arrayList ;
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)){
			int _count=scanner.nextInt(), _queries = scanner.nextInt();
			arrayList = new ArrayList<Integer>(_count);
			while(_count > 0){
				arrayList.add(scanner.nextInt());
				--_count;
			}
			while(_queries>0){
				System.out.println(defSkippingSum(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
				--_queries;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static int defSkippingSum(int _L,int _R,int _K){
		int sum=0;
		for( ; _L<=_R ; _L=_L+_K){
			sum += arrayList.get(_L-1);
		}
		return sum;
	}
}*/
