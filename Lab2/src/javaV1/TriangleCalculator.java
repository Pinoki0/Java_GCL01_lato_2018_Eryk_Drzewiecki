package javaV1;

import java.util.Scanner;

public class TriangleCalculator implements Calculator{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("Podaj bok a:");
		double a=in.nextDouble();
		System.out.println("Podaj bok b:");
		double b=in.nextDouble();
		System.out.println("Podaj bok c:");
		double c=in.nextDouble();
		double obwod=a+b+c;
		System.out.println("Obwód wynosi:"+obwod);
		return 0;
	}

}
