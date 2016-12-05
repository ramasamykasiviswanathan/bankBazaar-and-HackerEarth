package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GirlfriendsDemands {

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in))) {
			final String S = br.readLine().trim();
			int testCase = Integer.valueOf(br.readLine());
			StringBuilder stringBuilder = new StringBuilder(testCase);
			// TODO
			// https://www.hackerearth.com/problem/algorithm/girlfriends-demands/
			while (testCase > 0) {
				--testCase;
				long[] longValues= longValues(br.readLine().split(" "));
				int a = 0,b = 0;
				if(longValues[0]>S.length())
					a=(int) refactorLongValues(longValues[0], S.length());
				else
					a=(int) longValues[0]-1;
				if(longValues[1]>S.length())
					b=(int) refactorLongValues(longValues[1], S.length());
				else
					b=(int) longValues[1]-1;
				if(S.charAt(a)==S.charAt(b))
					stringBuilder.append("Yes\n");
				else
					stringBuilder.append("No\n");
			}
			System.out.println(stringBuilder);
		}
	}
	private static long[] longValues(String... args){
		long[] l = new long[2];
		l[0]=Long.valueOf(args[0]);
		l[1]=Long.valueOf(args[1]);
		return l;
	}
	
	private static long refactorLongValues(long values, int stringLength){
		values = (values-1)%stringLength;
		if(values>stringLength){
			refactorLongValues(values, stringLength);
		}
		return values;
	}
}
