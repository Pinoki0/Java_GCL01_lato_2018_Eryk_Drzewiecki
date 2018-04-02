package javaV1;

import java.util.Scanner;

public class ExtendetRectangleCalculator
extends RectangleCalculator implements ExtendetCalculator {

	@Override
	public void calculateArea() throws Exception {
		// TODO Auto-generated method stub
		Scanner in= new Scanner(System.in);
		System.out.println("Podaj bok a:");
		double a;
		a=in.nextDouble();
		System.out.println("Podaj bok b:");
		double b;
		b=in.nextDouble();
		double pole;
		pole=a*b;
		System.out.println("Pole wynosi: "+pole);
	}

}
