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
		//or
		Thread myLambdaThread1 = new Thread(() -> System.out.println("Inside runnablelambda"));
		//or method reference can do this but nothing is passed so no use here
		Thread myLambdaThread2 = new Thread(System.out::println);
		
		myLambdaThread.start();
		
	}

}
