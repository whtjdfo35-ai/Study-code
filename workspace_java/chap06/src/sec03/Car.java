package sec03;

public class Car {
	
//	Car(){
//		System.out.println("Car 생성자 실행");
//	} 
	//생성자를 생략한 경우, 생성자가 하나도 없는 경우
	//기본 생성자가 자동 생성 됨
	// Car(){ }
	//클래스명(){ }
	
	//생성자가 하나라도 있으면 기본 생성자는 만들어지지 않는다
	
//	String brand ="kia";
	String brand;
	/*
	Car(){
		brand = "kia";
	}
	//생성자는 보통 필드 값을 초기화하는데 사용함
	*/
//	Car(String b){
//		brand = b;
//	}
	//생성할 때 필요한 타입만 받게 할 수 있다
	
	String model;
	int MaxSpeed;
	Car(String b, String m, int MS){
		brand= b;
		model= m;
		MaxSpeed =MS;
	}
	
	Car(){
		brand= "hyundai";
		model= "그랜저";
		MaxSpeed = 240;
		
//		this("hyundai","그랜저",240);
		//다른 오버로딩된 생성자 호출
		//무조건 가장 먼저 실행되야 함
	}

	
}
