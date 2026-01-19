package sec04.overloading;

public class Calc {
	int plus(int a, int b) {
		System.out.println("int int 실행");
		return a+b;
	}
	
	double plus(double a,double b) {
		System.out.println("double double 실행");
		return a+b;
	}
	
	double plus(int a,double b) {
		System.out.println("int double 실행");
		return a+b;
	}
	
	int plus (int x) {
		return plus(x,x);
	}
	
	String type;
	int min;
	int set;
	
	void fit(String t, int m, int s) {
		type = t;
		min = m;
		set = s;
	}
	
	void fit(String t, int m) {
		type = t;
		min = m;
		set = 5;
		
//		fit(t,m,5); 도 가능
	}
	
	void fit(String t) {
		fit(t,3,5);
	}
}
