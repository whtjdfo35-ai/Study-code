package sec05._this;

public class Car {
	String model;
	
	
//	void setModel(String m) {
	void setModel(String model) {
//		model=m;
		this.model =model;
//		인스턴스를 가르키는 this
//		세터를 이용해서 필드 값을 받을때는 보통 매개변수를 필드 값과 같은 이름으로 사용
//		필드에 값을 넣기 위해 this 사용해서 필드 지정
	}
	
	Car(String model){
		this.model = model;
	}
	
}
