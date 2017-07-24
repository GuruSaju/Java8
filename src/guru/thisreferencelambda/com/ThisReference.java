package guru.thisreferencelambda.com;

public class ThisReference {
	
	public void doProcess(int i, Process p) {
		p.process(i);
	}
	
	public void execute() {
		// this === points to object reference to the object that called this method. 
		doProcess(10, i -> {
			System.out.println("Value of i is " + i);
			System.out.println(this); //this points to thisReferenceExample. Important difference between lambda and anonymous inner class
		});
	}
	
	
	public static void main(String[] args) {
		ThisReference thisReferenceExample = new ThisReference();
		
		/* thisReferenceExample.doProcess(10, i -> {
			System.out.println("Value of i is " + i);
			// System.out.println(this); This will not work //this is same as outside the lambda so will not work.
		});
		*/
		
		//Java 7
		thisReferenceExample.doProcess(10, new Process(){

			@Override
			public void process(int i) {
				System.out.println("Value of i is " + i);
				System.out.println(this); //this points to new Process() object and not thisReferenceExample.
			}
			
		});
		
		thisReferenceExample.execute();	
	}
	
	public String toString() {
		return "This is the main ThisReferenceExample class instance";
	}
	
}

interface Process{
	void process(int i);
}
