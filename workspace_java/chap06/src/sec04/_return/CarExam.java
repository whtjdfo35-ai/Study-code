package sec04._return;

public class CarExam {

	public static void main(String[] args) {
		
		Car car = new Car();
		boolean status = car.isLeftGas();
		System.out.println("가스 있나?:"+ status);

//		car.gas =3; 아래 방식으로 주로 사용한다
		car.setGas(3);
		System.out.println("가스 : "+car.isLeftGas());
		
		car.run();
		System.out.println("운행종료");
		
	}

}
