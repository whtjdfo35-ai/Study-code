package sec03._abstract;

public abstract class Animal {
	
	void breathe(){
		System.out.println("숨 쉬어");
	}
	
//	abstract void sound() {};
//	추상 메소드
//	실행블럭이 있으면 안됨
//	실행 블럭은 자식에서 구현해야 함
	abstract void sound();
		
	String kind;
	Animal(int maxAge){
		System.out.println("Animal 생성자 실행");
	}
}
