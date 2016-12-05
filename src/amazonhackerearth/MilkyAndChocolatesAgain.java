package amazonhackerearth;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

public class MilkyAndChocolatesAgain {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in))
		{
			// Reading N and Q
			int N = scanner.nextInt();
			ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(N);
			do
			{
				arrayDeque.add((arrayDeque.peekLast() != null ? arrayDeque.peekLast() : 0) +scanner.nextInt());
			}
			while(N --> 1);
			
			StringBuilder outputStringBuilder = new StringBuilder(); 
			int Q = scanner.nextInt();
			while(Q-->0)
			{
				final Iterator<Integer> forwardIterator = arrayDeque.iterator(), reverseIterator = arrayDeque.descendingIterator();
				Integer data = scanner.nextInt(), index =1;
				Boolean isNotFound = Boolean.TRUE;
				/*if(data > 0 && data <= arrayDeque.getFirst())
				{
					outputStringBuilder.append(index);
				}
				else if(data <= reverseIterator.next() && data > reverseIterator.next())
				{
					outputStringBuilder.append(arrayDeque.size());
				}
				else{
					while(isNotFound && forwardIterator.hasNext())
					{
						++index;
						if(IntStream.range(forwardIterator.next()+1,forwardIterator.next()).filter(value -> value == data).count() == 1)
						{
							isNotFound =Boolean.FALSE;
							outputStringBuilder.append(index);
						}
						if(forwardIterator.next() < data && forwardIterator.next() > data)
						{
							isNotFound = Boolean.FALSE;
							outputStringBuilder.append(index);
						}
					}
				}*/
				
				if(data > 0 && data <= arrayDeque.getFirst())
				{
					outputStringBuilder.append(index);
				} else{
					while(isNotFound && forwardIterator.hasNext())
					{
						++index;
						if(forwardIterator.next()-data < 0 && forwardIterator.next() - data >0)
						{
							isNotFound = Boolean.FALSE;
							outputStringBuilder.append(index);
						}
						
					}
				}
				outputStringBuilder.append("\n");
			}
			System.out.println(outputStringBuilder.toString().trim());
		}
	}
}
