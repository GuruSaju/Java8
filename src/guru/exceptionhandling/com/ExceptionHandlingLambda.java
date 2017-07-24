package guru.exceptionhandling.com;

import java.util.function.BiConsumer;

public class ExceptionHandlingLambda {

	public static void main(String[] args) {
		int [] someNumbers = { 1, 2, 3, 4 };
		int key = 2;
	
		//Wrapping a lambda within another lambda
		process(someNumbers, key, wrapperLambda((v, k) -> System.out.println(v / k)));
		
		//(v, k) -> CAN HAVE TRY CATCH HERE System.out.println(v / k)
		//But if kind of makes out lambda messy so it is not a good idea.
		//Lambda are wanted as short and crisp so have a wrapper instead of doing it here
		process(someNumbers, key, (v,k) -> {
			try{
				System.out.println(v/k);
			}
			catch(ArithmeticException e){
				//handle exception
			}
		});

	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i : someNumbers) {
			//can put a try catch here but this is generic and we don't know what exception we are catching. 
			consumer.accept(i, key);
		}
		
	}
	
	//A wrapper function for lambda which accepts a lambda and return a lambda with a try catch.
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		//creating a new lambda and return.
		// return (v,k) -> System.out.println(v+k); this would replace the lambda with addition lambda (v+k)
		
		return (v, k) ->  {
			try {
				consumer.accept(v, k); //execute whatever is passed in. 
			}
			catch (ArithmeticException e) {
				System.out.println("Exception caught in wrapper lambda");
			}
			
		};
	}
	
	//have a wrapper be generic so that it handles exceptions for all lambdas. 
	//improved by having generic wrapper functions for exception handling by Java8
	

}
