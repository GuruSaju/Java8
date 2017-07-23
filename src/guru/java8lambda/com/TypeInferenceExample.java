package guru.java8lambda.com;

/**
 * 
 * @author Srisarguru
 *
 */

public class TypeInferenceExample {
	
	public static void printLambda(StringLengthLambda lambda){
		System.out.println(lambda.getLength("Stringlength14"));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringLengthLambda stringLengthLambda = (String s) -> s.length();
		
		System.out.println(stringLengthLambda.getLength("Stringlength14"));
		
		//We dont really need the (String s) and we can just have (s)
		//can remove type information of input argument
		StringLengthLambda stringLengthLambda1 = (s) -> s.length();
		
		//if you just have one argument to your lambda function you can remove paranthesis
		StringLengthLambda stringLengthLambda2 = s -> s.length();
		
		//can do this waytoo
		printLambda(s -> s.length());

	}
	
	interface StringLengthLambda{
		int getLength(String s);
	}
}
