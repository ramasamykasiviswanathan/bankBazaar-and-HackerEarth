package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class PandaAndMaximumProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));) {
			int MAXValue = Integer.parseInt(br.readLine());
//			LinkedList<Integer> linkedList = new LinkedList<Integer>();
//			for(String temp: br.readLine().split("\\p{Blank}")){
//				linkedList.add(Integer.valueOf(temp));
//			}
//			Collections.sort(linkedList);
//			System.out.println(Math.max(linkedList.get(0)*linkedList.get(1), linkedList.get(MAXValue-2)*linkedList.get(MAXValue-1)));
			
			long[] arrayValues = new long[MAXValue];
			StringTokenizer tokenizer = new StringTokenizer(br.readLine().trim());
			for(int i=0;tokenizer.hasMoreTokens()&&i<MAXValue;i++){
				arrayValues[i] = Long.parseLong(tokenizer.nextToken());
			}
			Arrays.sort(arrayValues);
			System.out.println(Math.max(arrayValues[0]*arrayValues[1], arrayValues[MAXValue-2]*arrayValues[MAXValue-1]));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

