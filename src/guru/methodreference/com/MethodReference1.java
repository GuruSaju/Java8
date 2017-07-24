package guru.methodreference.com;

/**
 * 
 * @author Srisarguru
 *
 */
public class MethodReference1 {
	public static void main(String[] args) {
		
		//static method reference MethodReference1.printMessage
		Thread t = new Thread(MethodReference1::printMessage);  // () -> method()
		// MethodReferenceExample1::printMessage === () -> printMessage()
		t.start();
	}
	
	
	public static void printMessage() {
		System.out.println("Hello");
	}
	
}
