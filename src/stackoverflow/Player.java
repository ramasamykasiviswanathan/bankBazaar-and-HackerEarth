package stackoverflow;

import java.util.Scanner;

public class Player {
	  public static void main(String[]args){

	        Scanner s = new Scanner(System.in);

	        int a = s.nextInt();

	        System.out.print(f(a));
	        //i don't have errors when i run it
	        }

	    //this method won't return the value when i call it

	    public static int f(int x){
	        if(x%2 <= 0){
	            return x/2;
	        }else   
	            return x * 3 + 1;
	    }
	    public String getNick(){
	    	return"ram";
	    }
	    public void setPoints(int temp){
	    	
	    }
}

