package guru.java8lambda.com;

public class RunnableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread myThread = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Inside Runnable");
			}
			
		});
		
		//This doesn't create a new thread. 
		myThread.run();
		//this creates a new thread
		myThread.start();
		
		//We can have a runnable lambda because it has only one method run().
		Runnable runnableLambda = () -> System.out.println("Inside runnablelambda");
		
		Thread myLambdaThread = new Thread(runnableLambda);
		
		myLambdaThread.start();
		
	}

}
