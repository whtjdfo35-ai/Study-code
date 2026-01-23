package sec06._package.pack3;

import sec06._package.pack1.Access1;
import sec06._package.pack1.Edu;
import sec06._package.pack2.Access2;

public class AccessExam {

	public static void main(String[] args) {
		
//		new Access1();
//		public 이 아니라 생성 못함
		
		Access2 a2 = new Access2();
		Edu e1 = new Edu();
		//기본 생성자는 public이다
		
//		a2.d1 =10;
		a2.p1 =100;
		
//		a2.d();
		a2.p();
		
//		Access3 a3 = new Access3();
//		import도 안됨
		
//		a2.hp =10;
	}

}
