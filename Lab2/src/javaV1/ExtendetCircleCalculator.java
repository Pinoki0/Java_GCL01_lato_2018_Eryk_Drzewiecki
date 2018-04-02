package javaV1;

import java.util.Scanner;

public class ExtendetCircleCalculator 
extends CircleCalculator implements ExtendetCalculator {

	
	@Override
	public void calculateArea() throws Exception {
		// TODO Auto-generated method stub
		Scanner in= new Scanner(System.in);
		System.out.println("Podaj promien: ");
		double r=in.nextDouble();
		double p=Math.PI*r*r;
		System.out.println("Pole wynosi: "+p);
	}

}
