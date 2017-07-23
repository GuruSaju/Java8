package guru.java8lambda.com;
/**
 * 
 * @author Srisarguru
 *
 */
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
		Greeting greetingLambdaFunction = () -> System.out.println("Hello from lambda function");
	
		Greeting helloWorldGreeting1 = new HelloWorldGreeting();
		
		//Difference between above two lines??
		
		helloWorldGreeting.perform();
		
		//this is how you execute lambda expressions by calling the interface method on it, just
		// as if it were an instance of a class. 
		greetingLambdaFunction.perform();
		
		//So we do not need a separate class in order to implement (close) an interface like in HelloWorldGreeting
		//.java class
		
		//But we can do that using an inner class implementation of interface -anonymous class
		Greeting innerClassGreeting = new Greeting(){
			public void perform(){
				System.out.println("Hello from inner anonymous class");
			}
		};
		
		//Lambdas can also be used as a shortcut to the above inner classes but they have more functionalities.
		
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
