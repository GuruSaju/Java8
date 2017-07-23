package guru.java8lambda.com;

public class Greeter {
	
	public void greet(Greeting greeting) {
		greeting.perform();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Greeter greeter = new Greeter();
		HelloWorldGreeting helloWorldGreeting = new HelloWorldGreeting();
		greeter.greet(helloWorldGreeting);
		
		//looks for a method with the same signature in the interface 
		MyLambda myLambdaFunction = () -> System.out.println("Hello World!");
		
	}

}

//Step 1

interface MyLambda{
	//Step 2 (exact same method signature as the lambda function you want to create)
	void anyName();
}
