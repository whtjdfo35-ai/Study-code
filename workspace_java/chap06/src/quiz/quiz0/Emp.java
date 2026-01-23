package quiz.quiz0;

public class Emp {
	int eno;
	String name;
	String job;
	int sal;
	int uno;
	
	void setEmp(int eno,String name,String job,int sal,int uno){
		this.eno= eno;
		this.name= name;
		this.job= job;
		this.sal= sal;
		this.uno= uno;
	}
	
		
	
	void info() {
		System.out.println(this.eno+this.name+this.job+this.sal+this.uno);
	}
//	
//	 @Override
//	    public String toString() {
//	        return getEmp();   // ⭐ 핵심
//	    }
	
}
