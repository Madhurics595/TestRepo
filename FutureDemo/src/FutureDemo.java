import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

	private static final ExecutorService threadpool = Executors.newFixedThreadPool(3);
	public static void main(String args[]) throws InterruptedException, ExecutionException { 
		FactorialCalculator task = new FactorialCalculator(3); 
		System.out.println("Submitting Task ..."); 
		Future future = threadpool.submit(task); 
		System.out.println("Task is submitted"); 
		while (!future.isDone()) { 
			System.out.println("Task is not completed yet...."); 
			Thread.sleep(100); 
			//future.cancel(true);
			//sleep for 1 millisecond before checking again 
			} 
		System.out.println("Task is completed, let's check result");
		long factorial = (long) future.get(); 
		System.out.println("Factorial of 100 is : " + factorial); 
		threadpool.shutdown(); 
		} 	
}
