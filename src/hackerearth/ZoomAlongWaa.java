package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZoomAlongWaa {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
			Short testCase = Short.valueOf(br.readLine());
			StringBuilder stringBuilder = new StringBuilder();
			while(testCase>0){
				--testCase;
				String [] limits = br.readLine().trim().split(" ");
				long startValue = Long.valueOf(limits[0]), endValue = Long.valueOf(limits[1]), x=0, y=0, z=0;
				for(;startValue<=endValue;++startValue){
					if(startValue%3==0 && startValue%5==0){
						++z;
					}
					else if(startValue%10==0 || startValue%10==5){
						++y;
					}
					else if(startValue%3==0){
						++x;
					}
				}
				stringBuilder.append(x);
				stringBuilder.append(" ");
				stringBuilder.append(y);
				stringBuilder.append(" ");
				stringBuilder.append(z);
				stringBuilder.append("\n");
			}
			System.out.println(stringBuilder.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
