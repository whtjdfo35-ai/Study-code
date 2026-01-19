package sec01.exam01;

public class StudentExam {

	public static void main(String[] args) {
		
		Student s1 =new Student();
		
		Student s2;
		s2 = new Student();
		
		System.out.println(s1==s2);
		
		Student s3=null;
		s3=s1;
		System.out.println(s3==s1);
		
		s1 =null;
		//s3는 null로 변하지 않음
		s1 =s2;
		//s3는 변하지 않음. 여전히 s1에 들어갔던 인스턴스를 참조한다
		
		Teacher t1 = new Teacher();

	}

}
