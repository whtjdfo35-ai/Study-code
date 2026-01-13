package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		boolean run =true;
		int balance =0;
		String[] balp = new String[5]; 				// 최근 입출금 내역
		int balpl = balp.length;					// 쓰기 편하게 변수로 
				
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
					for(int i=(balpl-1);i!=0;i--) {		// 입출금 내역 저장
						balp[i] = balp[(i-1)];
					}
					balance += m;						// 예금액을 잔고에 더함
					balp[0] = "예금 "+ m +" 잔액 "+ balance; // 현재 상태
				}
			} else if(ch ==2) {
				System.out.print("출금액> ");
				Scanner scan2 = new Scanner(System.in);
				int m = scan2.nextInt();				// 출금액을 받아줄 변수
				if (m < 0) {							// 출금액이 음수일 경우
					System.out.println("음수불가");
				} else if(m > balance) {				// 출금액이 잔고를 넘는 경우
					System.out.println("잔고를 넘는 금액은 출금할 수 없습니다");
				} else {								// 출금액이 잔고 이하의 양수
					for(int i=(balpl-1);i!=0;i--) {		// 입출금 내역 기록
						balp[i] = balp[(i-1)];
					}
					balance -=m;						// 출금액을 잔고에서 뺀다
					balp[0] = "출금 "+m +" 잔액 "+ balance; //현재 상태					
				}
			} else if(ch==3) {
				System.out.println("잔고> "+balance);	// 잔고 보여줌
				System.out.println("입출금 내역>"); 	// 과거 기록 보여줌
				for(int i=0; i < balpl ; i++) {
					System.out.println((balpl - i)+". "+balp[i]);
				}
			} else if(ch==4) {							// 4번을 고르면
				break;									// 루프 끊음	
			} else {									// 1-4 말고 다른 숫자 고르면
				System.out.println("?");
			}
		}
		System.out.println("프로그램 종료");
		
	}

}
