package sec03;

public class CarExam {

	public static void main(String[] args) {
		
//		new Car();
		//생성자가 있어서 필드 선언 같은거 안해도 한번 실행됨

//		new Car("kia");
		
		Car c3 = null;
		try {
			c3 = new Car();
		} catch(Exception e) {
			System.out.println("new Car()에서 예외발생");
		}
		System.out.println("c3: "+c3);
	}

}
