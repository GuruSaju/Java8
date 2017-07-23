package guru.java8lambda.com;

public class Greeter {
	
	public void greet(Greeting greeting) {
		greeting.perform();
	}

	public static void main(String[] args) {
		
		Greeter greeter = new Greeter();
		HelloWorldGreeting helloWorldGreeting = new HelloWorldGreeting();
		greeter.greet(helloWorldGreeting);
		
		//looks for a method with the same signature in the interface
		//compiler does the type checking
		MyLambda1 myLambdaFunction = () -> System.out.println("Hello World!");
		
		//MyLambda addFunction = (int a, int b) -> a + b; This would give an error because for lambda 
		//functions you cannot have more than one function in an interface so another interface;
		
		
		//This works
		MyLambda2 addFunction = (int a, int b) -> a + b;
		
		
		//Since we already have an interface greeter
		Greeting greetingLambdaFunction = () -> System.out.println("Hello from greeter");
	
		Greeting helloWorldGreeting1 = new HelloWorldGreeting();
		
		//Difference between above two lines??
	}

}

//Step 1

interface MyLambda1{
	//Step 2 (exact same method signature as the lambda function you want to create)
	void anyName();
	
	//for add function
	//int anyName1(int x,int y);
}

interface MyLambda2{
	int anyName(int x,int y);

}
