package quiz.quiz0;

import java.util.ArrayList;

public class EmpTable {
	
	
	ArrayList al =new ArrayList();
		
	void setAl(Emp emp) {
		this.al.add(emp);
	}
		
//	void info() {
//		for(int i=0; i<this.al.size();i++) {
//			System.out.println(this.al.get(i));
//		}	
//			
//	} 
		
	void info() {
	
		for(int i=0; i<al.size(); i++) {
			Emp emp = (Emp)al.get(i);
			emp.info();
		}
	}	
//		for( Emp emp : list ) {
//			emp.info();
//		}	
			
					
}
