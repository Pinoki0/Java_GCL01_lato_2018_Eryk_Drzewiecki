package javaV1;

import java.util.Scanner;

public class SquareCalculator implements Calculator{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("Podaj bok a: ");
		double a=in.nextDouble();
		double obwod=4*a;
		System.out.println("Obwód wynosi: "+obwod);
		return 0;
	}

}
