package practiceTodo;

public class EmpDTO {
	private int empno;
	private String ename;
	
	public int getEmpno() {
		return this.empno;
	}
	
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
	public String getEname() {
		return this.ename;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	@Override
	public String toString() {
		return "EmpDTO [empno=" + empno + ", ename=" + ename  + "]";
	}
}
