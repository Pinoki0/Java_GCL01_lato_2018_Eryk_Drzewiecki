package Calculator;


public class FieldCalculator {

	
	public double calculateSquare(double a) 
	{
		if (a <= 0) {
	        throw new IllegalArgumentException();
	    }
		return a*a;
	}
	
	public double calculateCircle(double r) 
	{
		if (r <= 0) {
	        throw new IllegalArgumentException();
	    }
		return Math.PI*r*r;
	}
	
	public double calculateTriangle(double a, double h) 
	{
		if(a <= 0 || h<=0)
		{
		    throw new IllegalArgumentException();
		}	
		return a*h/2;
	}
	
	public double calculateRectangle(double a, double b) 
	{
		if(a <= 0 || b<=0)
		{
		    throw new IllegalArgumentException();
		}	
		return a*b;
	}
	
}
