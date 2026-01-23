package sec04.method;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CalcExam {

	public static void main(String[] args) {
		
		Calc calc = new Calc();
		/*
		calc.powerOn();
		
		int a = calc.plus(5, 7);
		System.out.println("a: "+a);
		
		int i =4;
		a = calc.plus(i,5);
		System.out.println(a);
		
		double b = calc.multiple(1, 6);
		System.out.println(b);
		
		double c = calc.square(3,2);
		System.out.println("c: "+c);
		*/
				
		Scanner sc = new Scanner(System.in);
//		String[] d = new String[3];
//						
//		for(int i = 0; i<d.length;i++) {
//			d[i] = sc.next();
//		}
		ArrayList d = new ArrayList(3);
		for(int i = 0; i<3;i++) {
			d.add(sc.next());
		}
//		System.out.println("d: "+calc.sc(d));
//		System.out.println(d.get(0));
//		System.out.println(d.get(1));
//		System.out.println(d.get(2));
		
	}

}
