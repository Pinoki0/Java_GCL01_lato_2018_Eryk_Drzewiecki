package javaV1;

import java.util.Scanner;

public class CircleCalculator implements Calculator {



	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub
		Scanner in= new Scanner(System.in);
		System.out.println("Podaj promien: ");
		double r=in.nextDouble();
		double l=2*Math.PI*r;
		System.out.println("Obwód wynosi: "+l);
		
		
		
		return 0;
	}

}
