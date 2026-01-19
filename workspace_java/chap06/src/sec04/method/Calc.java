package sec04.method;

import java.util.Scanner;

public class Calc {
	
	void powerOn() { //메소드 선언
		System.out.println("전원을 켭니다");
	}
	
	int plus(int x, int y) {
		System.out.println("x: "+x);
		System.out.println("y: "+y);
		
		int result = x+y;
		return result;
	}
	/**
	 * javadoc 주석
	 * 두 정수를 입력 받아서 나누기한 결과를
	 * x/y
	 * double로 돌려줌
	 * 단 y가 0이면 "0으로 나눌 수 없다"고 출력하고 0으로 돌려줌 
	 * 
	 * 메소드 명 : divide
	 * 전달 인자 : int x, int y
	 * 리턴 타입 : double 
	 * 
	 * @param int x, int y
	 * @return double
	 * @author mail@mail.com
	 */
	
	double divide(int x, int y) {
		if (y == 0) {
			System.out.println("0으로 나눌 수 없다");
			return 0;
		} else {
			double result = (double)x/(double)y;
			return result;
		}		
	} 
	/*
	 * double divide(int x, int y) {
		if (y == 0) {
			System.out.println("0으로 나눌 수 없다");
			return 0;
		}
		return (double)x/y;		
	} 
	
	 double divide(int x, int y) {
	 	double result =0;
		if (y == 0) {
			System.out.println("0으로 나눌 수 없다");
			result= 0;
		} else {
			result = (double)x/y;
		}
		return result;			
	} 
	 */
	
	double minus(double x,double y) {
		return (x-y);
	}
	
	double multiple(double x, double y) {
		return x*y;
	}
	
	double square(double x,int y) {
		double result =x;	
		for (int i =2; i<=y;i++) {
			result *= x;
		}	
		return result;
	}
	
	/*
	double square(double x,double y) {
		double resulta =x;	
		for (int i =2; i<=(y*10);i++) {
			resulta *= x;
		}	
		double resultb =1;
		double result;
		for (result=0; resultb!=resulta; result+=0.1) {
			for(int i=1;i<=10;i++) {
				resultb *= result;
			}
		}	
		return result;
		
	}
	*/
	

//	Calc cc = new Calc(); 같은 클래스 안에서는 메소드를 직접 호출 가능
	double sc(String[] input) {
		if(input[1].equals("+")) {
			return plus(Integer.parseInt(input[0]), Integer.parseInt(input[2]));			
		} else if(input[1].equals("/")) {
			return divide(Integer.parseInt(input[0]), Integer.parseInt(input[2]));
		} else if(input[1].equals("-")) {
			return minus(Integer.parseInt(input[0]), Integer.parseInt(input[2]));
		} else if(input[1].equals("*")) {
			return multiple(Integer.parseInt(input[0]), Integer.parseInt(input[2]));	
		} else {
			return 0;
		}
		
	}
	
	double sc(int x, String y, int z) {
		if(y.equals("+")) {
			return plus(x,z);			
		} else if(y.equals("/")) {
			return divide(x, z);
		} else if(y.equals("-")) {
			return minus(x, z);
		} else if(y.equals("*")) {
			return multiple(x, z);	
		} else {
			return 0;
		}
		
	}
	 
}
