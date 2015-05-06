package javase8.examples;

public class FunctionalInterfaceImplementation {

	public static void main(String[] args) {
		FunctionalInterfaces interfaces = (int a, float b) -> {
			/**
			 * we don't want to specify the arguments type it can be simply (a,b)
			 * if we happened to specify also its not a problem.
			 */
			System.out.println("my name is ramasamy");
			System.out.println("the value of a is \b" + a + "\nrather b is \b"
					+ b);
		};
		interfaces.sayHello(1, 2);
	}
}
