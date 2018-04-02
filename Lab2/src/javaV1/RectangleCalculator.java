package javaV1;

import java.util.Scanner;

public class RectangleCalculator implements Calculator {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub
		Scanner in= new Scanner(System.in);
		System.out.println("Podaj bok a:");
		double a;
		a=in.nextDouble();
		System.out.println("Podaj bok b:");
		double b;
		b=in.nextDouble();
		double obwod;
		obwod=2*a+2*b;
		System.out.println("Obwód wynosi: "+obwod);
		return 0;
	}

}
