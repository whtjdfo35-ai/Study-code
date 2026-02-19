package sec01;

public class ExtendsExam {

	public static void main(String[] args) {
		
		Child child = new Child();
		
		System.out.println("----------");
		
		child.printName();
		
		System.out.println("child.name: "+child.name);
		
		String n = child.getName();
		System.out.println("child.getName: "+n);
	}

}
