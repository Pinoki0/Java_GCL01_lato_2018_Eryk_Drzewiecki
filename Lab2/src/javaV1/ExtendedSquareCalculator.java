package javaV1;

import java.util.Scanner;

public class ExtendedSquareCalculator 
extends SquareCalculator implements ExtendetCalculator
{

	

	@Override
	public void calculateArea() throws Exception 
	{
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("Podaj bok a: ");
		double a=in.nextDouble();
		double pole=a*a;
		System.out.println("Pole wynosi: "+pole);
		return 0;
	}

}
