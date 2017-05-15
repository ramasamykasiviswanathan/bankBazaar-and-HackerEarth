package code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class ComplementaryPairs
{

	public static void main(String[] args)
	{
		System.out.println(calculateKComplimentaryPairs(10, new int[]{1,5,9,8,2,5}));
		System.out.println(calculateKComplimentaryPairs(4, new int[]{2, 5, -1, 6, 10, -2}));
		System.out.println(calculateKComplimentaryPairs(10, new int[]{7, 1, 5, 6, 9, 3, 11, -1}));
		System.out.println(calculateKComplimentaryPairs(1, new int[]{4 , 5 , 6 , 3 , 1 , 8 , -7 , -6}));
		System.out.println(calculateKComplimentaryPairs(1, new int[]{-3 , -4 , -5 , -2 , 0 , -7 , 8 , 7})+"\n");
	}
	
	/**
	 * asymptotic notation O(n)
	 * @param k
	 * @param values
	 * @return
	 */
	public static int calculateKComplimentaryPairs(final int k, final int[] values)
	{
		int noOfPairs = 0;
		if(null != values)
		{
			HashMap<Integer, Integer> hashMap = new HashMap<>();
			IntStream.range(0,values.length).forEach(v -> hashMap.merge(k-values[v], 1, Integer::sum));
			noOfPairs = Arrays.stream(values).parallel().map(v -> hashMap.getOrDefault(v, 0)).sum();
		}
		return noOfPairs;
	}
}
