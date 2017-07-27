package guru.lambdaclosures.com;

public class ClosureJava7 {
    //static int b=10; if we declare b here there is no error in inner class in main method.
	public static void doProcess(int i,Process p){
		p.process(i);
		}
	public static void main(String[] args) {
		int a =10;
		int b=20; //have it final to tell java that you are not going to change it. //local variable in main method so on stack will be lost
		// after method ends.
		doProcess(a, new Process(){ //b is pass by value here //This object of the class is still alive after main method ends and
			//it is on the heap. 

			@Override
			public void process(int i) {
				//cannot do a b=30; b has to be final
				//b=30 here will give an error because
				/*
				 *  this is happening because you are accessing b variable from within your anonymous inner class, 
				 *  what happens deep inside is that another copy of your variable is created and will be use inside 
				 *  the anonymous inner class, so for data consistency the compiler will try restrict you from 
				 *  changing the value of b so that's why its telling you to set it to final.
				 *  
				 *  Local variables of the method are kept on the stack and lost as soon as the method ends, however 
				 *  even after the method ends, the local inner class object is still alive on the heap and will need 
				 *  to access this variable 
				 */
				System.out.println(i+b);
				
			}
			
		});

	}

}

interface Process{
	void process(int i);
}
