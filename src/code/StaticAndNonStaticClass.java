package code;

import java.util.Arrays;

public class StaticAndNonStaticClass {

	private static String privateBus = "privateBus";
	public static String publicBus = "publicBus";
	protected static String protectedBus = "protectedBus";
	static String bus = "bus";

	private String privateCar = "privateCar";
	public String publicCar = "publicCar";
	protected String protectedCar = "protectedCar";
	String Car = "Car";
	
	public class nonStaticInnerClass{
		String unicorn = null;
		//Cannot define static initializer in inner type StaticAndNonStaticClass.nonStaticInnerClass
		/*static{
		}*/
		public nonStaticInnerClass() {
			unicorn = "unicorn";
		}
		private void nonStaticChangeValues(){
			Car = "newCar";
			publicCar = "newPublicCar";
			privateCar = "newPrivateCar";
			protectedCar = "newProtectedCar";
		}
		public void displayCar(){
			System.out.println("\nCar: " + Car +
					"\npublicCar: " + publicCar +
					"\nprivateCar: " + privateCar +
					"\nprotectedCar: " + protectedCar +
					"\nunicorn: " + unicorn +
					"\nbrowny: " + StaticAndNonStaticClass.staticInnerClass.browny +
					"\nBus: " + getBus());
		}
	}
	
	public static class staticInnerClass{
		String ramasamy = null;
		static String browny = null;
		public staticInnerClass() {
			ramasamy = "ramasamy";
			StaticAndNonStaticClass.setBus(null);
			StaticAndNonStaticClass.setPrivateBus(null);
			StaticAndNonStaticClass.setProtectedBus(null);
			StaticAndNonStaticClass.setPublicBus(null);
		}
		static{
			browny = "browny";
		}
		private void changeValues(){
			bus = "newBus";
			publicBus = "newPublicBus";
			privateBus = "newPrivateBus";
			protectedBus = "newProtectedBus";
			
		}
		public void displayBus(){
			System.out.println("\nbus: " + bus +
					"\npublicBus: " + publicBus +
					"\nprivateBus: " + privateBus +
					"\nprotectedBus: " + protectedBus +
					"\nramasamy: " + ramasamy +
					"\nbrowny: " + browny +
					"\nCar: " + new StaticAndNonStaticClass().getCar());
		}
	}

	public static String getPrivateBus() {
		return privateBus;
	}

	public static void setPrivateBus(String privateBus) {
		StaticAndNonStaticClass.privateBus = privateBus;
	}

	public static String getPublicBus() {
		return publicBus;
	}

	public static void setPublicBus(String publicBus) {
		StaticAndNonStaticClass.publicBus = publicBus;
	}

	public static String getProtectedBus() {
		return protectedBus;
	}

	public static void setProtectedBus(String protectedBus) {
		StaticAndNonStaticClass.protectedBus = protectedBus;
	}

	public static String getBus() {
		return bus;
	}

	public static void setBus(String bus) {
		StaticAndNonStaticClass.bus = bus;
	}

	public String getPrivateCar() {
		return privateCar;
	}

	public void setPrivateCar(String privateCar) {
		this.privateCar = privateCar;
	}

	public String getPublicCar() {
		return publicCar;
	}

	public void setPublicCar(String publicCar) {
		this.publicCar = publicCar;
	}

	public String getProtectedCar() {
		return protectedCar;
	}

	public void setProtectedCar(String protectedCar) {
		this.protectedCar = protectedCar;
	}

	public String getCar() {
		return Car;
	}

	public void setCar(String car) {
		Car = car;
	}
}
