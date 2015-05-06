package hackerearth;

import java.util.LinkedList;
import java.util.Scanner;

public class RoyAndProfilePicture {

	public static void main(String[] args) {
		int _length = 0, _no_of_testCase;
		LinkedList<String> linkedList = new LinkedList<String>();
		try (Scanner scanner = new Scanner(System.in)) {
			_length = scanner.nextInt();
			_no_of_testCase = scanner.nextInt();
			for (int _iterate = 0; _iterate <= _no_of_testCase; _iterate++)
				linkedList.add(scanner.nextLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (String _elements : linkedList) {
			if (!_elements.trim().equals("")) {
				String[] _list_elements = _elements.split(" ");
				int[] _integer_values = new int[] { Integer.valueOf(
						_list_elements[0].trim()), Integer.valueOf(_list_elements[1].trim()) };
				if (_integer_values[0] < _length
						|| _integer_values[1] < _length)
					System.out.println("UPLOAD ANOTHER");
				else if (_integer_values[0] >= _length
						&& _integer_values[1] >= _length
						&& _integer_values[0] == _integer_values[1])
					System.out.println("ACCEPTED");
				else
					System.out.println("CROP IT");
			}
		}
	}
}
