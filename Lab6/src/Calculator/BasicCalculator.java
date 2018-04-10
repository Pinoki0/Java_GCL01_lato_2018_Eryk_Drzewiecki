package Calculator;


public class BasicCalculator {

	public double calculateSum(double a, double b) 
	{		
		return a+b;
	}
		
	public double calculateDifference(double a, double b)
	{
		
		return a-b;
	}
	
	public double calculateMultiplication(double a, double b) 
	{
		
		return a*b;
	}
	 
	public double calculateDivision(double a, double b)
	{
		 if (b == 0) {
		        throw new IllegalArgumentException();
		    }
		return a/b;
	}
	
	public double calculatePow(double a, double b)
	{
		return Math.pow(a, b);
	}
	
	public double calculateSqrt(double a)
	{	
		if (a < 0) {
	        throw new IllegalArgumentException();
	    }
		return Math.sqrt(a);
	}
	


}
