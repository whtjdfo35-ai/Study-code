package sec03._abstract;

public class AnimalExam {

	public static void main(String[] args) {
		
//		Animal animal = new Animal();
		//추상 클래스는 클래스 타입의 변수로 생성 불가
		
		Animal a = new Dog();
		a.sound();
		
		Dog dog = (Dog)a;
		System.out.println(dog.kind);
	}
	

}
