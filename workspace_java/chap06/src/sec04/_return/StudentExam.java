package sec04._return;

public class StudentExam {

	public static void main(String[] args) {

		Student s1 = new Student();
		s1.name = "whtjdfo";
		s1.age = 34;
		
		s1.setName("whtjdfo");
		String name = s1.getName();
		System.out.println(name);

	}

}
