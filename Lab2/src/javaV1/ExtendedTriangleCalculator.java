package javaV1;

import java.util.Scanner;

public class ExtendedTriangleCalculator 
extends TriangleCalculator implements ExtendetCalculator 
{

	

	@Override
	public void calculateArea() throws Exception {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("Podaj bok a:");
		double a=in.nextDouble();
		System.out.println("Podaj wysokosc:");
		double h=in.nextDouble();
		double pole=(a*h)/2;
		System.out.println("Pole wynosi:"+pole);
		return 0;
	}

}
