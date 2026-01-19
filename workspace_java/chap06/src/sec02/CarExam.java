package sec02;

public class CarExam {
	static int a= 10;

	public static void main(String[] args) {
		
		Car mycar = new Car();
		
		System.out.println(mycar.company);
		mycar.company = "redbull";
		System.out.println(mycar.company);
		System.out.println(mycar.speed);
		mycar.speed = 170;
		System.out.println(mycar.speed);
		
		Car mycar2 = new Car();
		System.out.println(mycar2.company);
		
		System.out.println(a);
		
	}

}
