package sec02;

public class ExceptionExam {
	public static void main (String[] args) {
		try {
			System.out.println(1);
//			int a = Integer.parseInt("a");
			System.out.println(1.5);
			System.out.println(args[100]);
			System.out.println(2);
//		} catch(Exception e) {
		} catch(ArrayIndexOutOfBoundsException e) { //out of bound 예외만 잡음
			
			System.out.println(3);
			
			System.out.println(e);
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		} catch(NumberFormatException e) { 
			System.out.println(3.5);
			e.printStackTrace();	
		} finally {
			System.out.println("무조건 실행");
		}
		
		System.out.println(4);
		
	}
	
	void test(){
		try {
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
