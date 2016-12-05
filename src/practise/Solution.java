package practise;

public class Solution {
	public int solution(int[] A){
		int prefix = 0, suffix =0;
		int i,j, finalValue=-1;
		for(i=0;i<A.length; i++){
			if(i!=0){
			for(j=0;j<i;j++){
				prefix+=A[j];
			}
			}
			for(j=i+1;j<A.length;i++){
				suffix+=A[j];
			}
			if(suffix == prefix){
				finalValue=i;
				break;
			}
		}
		System.out.println(finalValue);
		return finalValue;
	}

}
