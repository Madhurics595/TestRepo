import java.util.concurrent.Callable;


public class FactorialCalculator implements Callable {

	private final int number;
	
public FactorialCalculator(int number) {
	this.number = number; 
	}
@Override public Long call() {
	long output = 0;
	try { 
		output = factorial(number);
	} 
	catch (InterruptedException ex) { 
		ex.printStackTrace(); 
		}
	return output; 
	} 
private long factorial(int number) throws InterruptedException {
	if (number < 0) { 
		throw new IllegalArgumentException("Number must be greater than zero"); 
		} long result = 1; 
		while (number > 0) { 
			Thread.sleep(1); 
			// adding delay for example 
			result = result * number;
			number--; 
			} 
		return result; 
	}	
}

