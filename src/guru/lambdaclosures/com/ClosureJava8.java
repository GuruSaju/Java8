package guru.lambdaclosures.com;

public class ClosureJava8 {

	public static void doProcess(int i,Process p){
		p.process(i);
		}
	
	public static void main(String[] args) {
		int a =10;
		int b=20; 
		//no need to declare b a final because b is automatically froze by lambda.
		doProcess(a, i -> System.out.println(i+b)); //freezes the value of b that is passed so b does not changes. this is closure.

	}

}

