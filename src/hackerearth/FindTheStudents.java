package hackerearth;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class FindTheStudents {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)){
			short totalStudents = scanner.nextShort();
			LinkedList<Short> linkedList = new LinkedList<>();
			do{
				linkedList.add(scanner.nextShort());
			}
			while(totalStudents > linkedList.size());
			while(linkedList.size()>0){
				short minimumValue = minimumValueOfList(linkedList);
				System.out.println(linkedList.size());
				reduceValue(minimumValue, linkedList);
			}
		}
	}
	
	private static short minimumValueOfList(LinkedList<Short> list){
		short min = Short.MAX_VALUE, currentValue;
		Iterator<Short> iterator = list.iterator();
		while(iterator.hasNext()){
			currentValue = iterator.next();
			if(currentValue > 0 && currentValue < min){
				min = currentValue;
			}
		}
		return min;
	}
	
	private static void reduceValue(short value, LinkedList<Short> list){
		ListIterator<Short> iterator = list.listIterator();
		while(iterator.hasNext()){
			iterator.set((short) (iterator.next()-value));
		}
		while(iterator.hasPrevious()){
			if(iterator.previous()==0){
				iterator.remove();
			}
		}
	}
}
