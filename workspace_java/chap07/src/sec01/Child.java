package sec01;

public class Child extends Parent {
	
	
	
	void printName() {
		
		String name = "지역변수 선언 가능";
		
		System.out.println("Child의 printName 실행");
		
		System.out.println("name: "+name);
		
		System.out.println("this.name: "+this.name);
		
		System.out.println("super.name: "+super.name);
		//부모 필드에 접근
				
		
	}
	
	//지역변수(전달인자)가 필드를 가림 shadow
	//그래서 구분 위해 this 사용
	void setName(String name) {
		this.name = name;
	}
	
	//자식 필드가 부모 필드를 가림 overshadow
	// 그래서 부모 필드를 구분하기 위해 super사용
	String name = "Child의 name";
	
//	Child(){
//		System.out.println("Child 생성자");
//	}
	
//	Child(int a){
//		
//	}
//	
////	//상속이 있을때 기본 생성자 모습
////	Child(){
////		super();//생략 가능
////	}
//	
	Child(){
//		super(); 
		super(3); //  부모의 생성자에 전달 인자가 있으면 반드시 super(전달인자) 써야함
		
//		this(2); super, this 둘다 첫 줄에 적어야 해서 같이 못 씀
		
		System.out.println("Child 생성자 실행");
	}
	
}
