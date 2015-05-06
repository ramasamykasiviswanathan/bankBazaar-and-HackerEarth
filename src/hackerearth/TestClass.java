package hackerearth;

import java.util.Scanner;
 
class TestClass {
    public static void main(String args[] ) throws Exception {
       	long total;
       	StringBuilder out = new StringBuilder();
       	Scanner scan = new Scanner(System.in);
        long N = scan.nextLong();
        
        while (N-- >0) {
			long A = scan.nextLong();
			long B = scan.nextLong();
			long M = scan.nextLong();
			long buff = (A%M);
			if((buff!=0)&&(A+(M-buff))<=B){
				total = (((B-(A+(M-buff)))/M)+1);
			}else if((buff==0)&&(A<=B)) {
				total = (((B-A)/M)+1);
			}else{
				 total = (0);
			}
			
			out.append(total+"\n");
        }
    System.out.println(out);
    }
}