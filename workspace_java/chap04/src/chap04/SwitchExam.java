package chap04;

public class SwitchExam {

	public static void main(String[] args) {
		int num =1;
		if(num == 1) {
			System.out.println("1입니다");
		} else if(num == 2) {
			System.out.println("2입니다");
		} else {
			System.out.println("1 또는 2 가 아닙니다");
		}
			
		switch(num) {
			case 1 :
				System.out.println("1입니다");
//				break;
			case 2 : 
				System.out.println("2입니다");
//				break;
			default : 
				System.out.println("1 또는 2 가 아닙니다");
				break;
		}
		//사용 가능 : int , String , byte,char,short
		//not used: boolean, long, float, double
		
		int mon =1;
		switch(mon) {
			case 9 :
			case 10 :
			case 11 :
				System.out.println("autumn");
				break;
			case 12 :
			case 1 :
			case 2:
				System.out.println("winter");
				break;
		}
		
	}

}
