package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BitsTransformation {
	static Integer[] values;
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			values = returnInt(br.readLine().split(" "));
			int cost=0;
			String A = br.readLine().trim();
			final String B = br.readLine().trim();
			for(int i=0;i<values[0];i++){
				if(A.charAt(i) == A.charAt(i))
					continue;
				else{
					if(i+1 != values[0]){
						if(A.charAt(i+1) != '?'){
							if(A.charAt(i+1)==B.charAt(i) && A.charAt(i) == B.charAt(i+1)){
								if(values[4]<=values[3]){
									A =returnReplacedString(A, i, 3);
									cost+=values[4];
								}
							}
						}
						else{
							
						}
							
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Integer[] returnInt(String[] _string){
		ArrayList<Integer> arrayList = new ArrayList<Integer>(5);
		for(String _toInt:_string)
			arrayList.add(Integer.valueOf(_toInt));
		return arrayList.toArray(new Integer[0]);
	}
	
	private static String returnReplacedString(String temp, final int startindex, int swap){
		String startString,endString,reverse;
		startString = temp.substring(0, startindex-1);
		if(swap == 3){
			if (startindex+2 <= values[0])
				endString=temp.substring(startindex+2,values[0]-1);
			else
				endString = "";
			return startString+temp.charAt(startindex+1)+temp.charAt(startindex)+endString;
		}
		else{
			if (startindex+1 <= values[0])
				endString=temp.substring(startindex+1,values[0]-1);
			else
				endString = "";
			reverse = (temp.charAt(startindex)=='0')? "1":"0";
			return startString+reverse+endString;
		}
	}
}
