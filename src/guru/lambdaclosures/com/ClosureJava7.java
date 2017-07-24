package guru.lambdaclosures.com;

public class ClosureJava7 {

	public static void doProcess(int i,Process p){
		p.process(i);
		}
	public static void main(String[] args) {
		int a =10;
		int b=20; //have it final to tell java that you are not going to change it. 
		doProcess(a, new Process(){ //b is pass by value here

			@Override
			public void process(int i) {
				//cannot do a b=30; b has to be final
				System.out.println(i+b);
				
			}
			
		});

	}

}

interface Process{
	void process(int i);
}
