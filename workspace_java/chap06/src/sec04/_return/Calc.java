package sec04._return;

public class Calc {
	
	int plus (int x, int y) {
		return x+y;
	}
	
	double avg (int x, int y) {
		return ((double)plus(x,y)/2);
	}
	
	void execute(int j1, int j2) {
		double result = avg(j1, j2);
		System.out.println(j1+","+j2+"의 평균은 "+result);
	}
}
