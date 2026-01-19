package sec04._return;

public class Student {
	
	String name;
	int age;
	
	//setter
	//필드 값을 수정하는 용도로 사용하는 method
	//method명: set+필드명
	//전달인자: 필드의 타입
	//리턴타입: void
	
	void setName(String n) {
		if(name != null) {
			name = n;
		}	
	}
	
	//getter
	//필드 값을 읽어오는 용도로 사용하는 method
	//method명:get+필드명
	//전달인자: 없음
	//리턴타입: 필드의 타입
	String getName() {
		return name;
	}
	
}
