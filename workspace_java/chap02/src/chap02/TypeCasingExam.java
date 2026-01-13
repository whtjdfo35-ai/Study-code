package chap02;

public class TypeCasingExam {

	public static void main(String[] args) {
		int intv = 10;
		byte bytev = (byte)intv;
		//()는 형 변환 연산자
		System.out.println(bytev);
	
		int a = 2 * (3+4);
		//()는 우선순위 연산자
	
	
		intv =200;
		bytev = (byte)intv;
		System.out.println(bytev);

		double d1 = 3.14;
		float f1 = (float)d1;
		System.out.println(f1);
	
		double d2 = -3.14;
		int i1 = (int)d2;
		System.out.println(i1);
		
		double d3 = 10/4;
		System.out.println("d3: "+d3);
		//10,4 둘 다 정수라서 int값으로 계산되고 double로 변환됨

		double d4 = 10.0/4;
		System.out.println("d4: "+d4);
		
		double d5 = (double) 10 / 4;
		System.out.println("d5: "+d5);
		//double로 변환해서 계산하는 방법 연산할 항목 하나 이상 double로 변환해서 연산
	
	}	
}
