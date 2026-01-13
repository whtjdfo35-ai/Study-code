package chap04;

import java.util.Scanner;

public class WhileExam {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int menu=-1;
		/*
		while(menu !=0) {
			System.out.println("메뉴를 고르시요");
			System.out.println("1:coffee 2:tea 0:end");
			menu = scan.nextInt();
			if(menu ==1) {
				System.out.println("coffee");
			} else if (menu ==2) {
				System.out.println("tea");
			} else if (menu ==0) {
				System.out.println("end");
			} else {
				System.out.println("다시 입력");
			}
		}
		
		int menu2 = -2;
		do {
			System.out.println("메뉴를 고르시요");
			System.out.println("1:coffee 2:tea 0:end");
			menu = scan.nextInt();
			
			if(menu ==1) {
				System.out.println("coffee");
			} else if (menu ==2) {
				System.out.println("tea");
			} else if (menu ==0) {
				System.out.println("end");
			} else {
				System.out.println("다시 입력");
			}
		}
		while (menu2 != 0);
		
		System.out.println("메뉴를 고르시요");
		System.out.println("1:coffee 2:tea 0:end");
		int menu = scan.nextInt();
		for(; menu!=0; ) {
			if(menu ==1) {
				System.out.println("coffee");
			} else if (menu ==2) {
				System.out.println("tea");
			} else {
				System.out.println("다시 입력");
			}
			System.out.println("메뉴를 고르시요");
			System.out.println("1:coffee 2:tea 0:end");
			menu = scan.nextInt();
		}
		System.out.println("end");
		*/
		
		//교재 p.183 q7
		boolean run =true;
		int balance =0;
		String[] balp = new String[5];				// 가장 최근 입출금 내역
				
		while(run) {
			System.out.println("-----------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------------");
			System.out.print("선택> ");
			int ch =scan.nextInt();
			if (ch ==1) { 
				System.out.print("예금액> ");
				Scanner scan2 = new Scanner(System.in);
				int m = scan2.nextInt(); 				// 예금액 받아줄 변수
				if(m<0) { 								// 예금액이 음수일 경우
					System.out.println("음수불가");					
				} else {								// 예금액이 양수면
					for(int i=4;i!=0;i--) {				// 입출금 내역 저장
						balp[i] = balp[(i-1)];
					}
					balance += m;						// 예금액을 잔고에 더함
					balp[0] = "예금 "+ m +" 잔액 "+ balance; // 현재 기록
				}
			} else if(ch ==2) {
				System.out.print("출금액> ");
				Scanner scan2 = new Scanner(System.in);
				int m = scan2.nextInt();				// 출금액을 받아줄 변수
				if (m<0) {								// 출금액이 음수일 경우
					System.out.println("음수불가");
				} else if(m>balance) {					// 출금액이 잔고를 넘는 경우
					System.out.println("잔고를 넘는 금액은 출금할 수 없습니다");
				} else {								// 출금액이 잔고 이하의 양수
					for(int i=4;i!=0;i--) {				// 입출금 내역 기록
						balp[i] = balp[(i-1)];
					}
					balance -=m;						// 출금액을 잔고에서 뺀다
					balp[0] = "출금 "+m +" 잔액 "+ balance; //현재기록					
				}
			} else if(ch==3) {
				System.out.println("잔고> "+balance);	// 잔고 보여줌
				System.out.println("입출금 내역>"); 	// 과거 기록 보여줌
				System.out.println("5. "+balp[0]);
				System.out.println("4. "+balp[1]);
				System.out.println("3. "+balp[2]);
				System.out.println("2. "+balp[3]);
				System.out.println("1. "+balp[4]);
			} else if(ch==4) {							// 4번을 고르면
				break;									// 루프 끊음	
			} else {									// 1-4 말고 다른 숫자 고르면
				System.out.println("?");
			}
		}
		System.out.println("프로그램 종료");
	}

}
