package javaV1;

import java.util.Scanner;

public class konsola {

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("Wybierz figure, a ja oblicze obwód i pole: 1-ko³o, 2-kwadrat, 3-prostok¹t, 4-trójk¹t");
		int wybierz=in.nextInt();
		Calculator calc;
		ExtendetCalculator calc1;
		switch(wybierz)
		{
		case 1:
			calc1=new ExtendetCircleCalculator();
			calc1.calculatePerimeter();
			calc1.calculateArea();
			break;
		case 2:
			calc1=new ExtendedSquareCalculator();
			calc1.calculatePerimeter();
			calc1.calculateArea();
			break;
		case 3:
			calc1=new ExtendetRectangleCalculator();
			calc1.calculatePerimeter();
			calc1.calculateArea();
			break;
		case 4:
			calc1=new ExtendedTriangleCalculator();
			calc1.calculatePerimeter();
			calc1.calculateArea();
			break;
		
		
		}
		

	}

}
