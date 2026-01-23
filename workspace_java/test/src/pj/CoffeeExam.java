package pj;

import java.util.Scanner;

public class CoffeeExam {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String[] coffee = {"아메리카노", "에스프레소","라떼"};
		int[] cfePrice = {5000, 6000, 6500};
		String[] option = {"추가 옵션 없음","hot", "ice","샷 추가"};
		int[] optPrice = {0, 0, 500, 600};
		boolean run =true;
		int input1 =0;
		int input1_1 =0;
		int input2 = 0;
		int price =0;
		
		while(run) {
			System.out.println("<메뉴>");
			for(int i= 0;i<coffee.length;i++) {
				System.out.print(i+1+". "+coffee[i]+" "+cfePrice[i]+"원\n");
			}
		
			input1 = scan.nextInt();
			System.out.println(coffee[input1-1]+"를 선택하셨습니다");
			
			System.out.println("수량을 입력해 주세요");
			input1_1 = scan.nextInt();
			price += input1_1*cfePrice[input1-1];
			System.out.println(coffee[input1-1]+"를 "+input1_1+ "잔 선택하셨습니다");
			
			while(run) {
				System.out.println("추가 옵션을 선택해주세요");
				System.out.println("0. 메뉴로 돌아가기");
				for(int i= 0;i<option.length;i++) {
					System.out.print(i+1+". "+option[i]+" "+optPrice[i]+"원\n");
				}
				System.out.println("99.종료");
		
				input2 = scan.nextInt();
				if (1 <= input2 && input2 <= option.length) {
					System.out.println(option[input2-1]+"를 선택하셨습니다");
					price += optPrice[input2-1];
					run=false;
				} else if(input2 ==0) {
					price =0;
					break;
				} else if(input2 ==99) {
					price =0;
					run=false;
					
				} else {	
					System.out.println("다시 선택해주세요");
				}
			}
			
		}
		if(price !=0) {
			System.out.println(coffee[input1-1]+" "+
								option[input2-1]+" "+input1_1+"잔 "
								+price+"원 입니다");
		}
	}

}
