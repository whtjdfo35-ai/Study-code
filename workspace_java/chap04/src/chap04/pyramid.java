package chap04;

import java.util.Scanner;

public class pyramid {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		// 1단계
        // +++++
		for(int nn = 1; nn<=5;nn++) {
			System.out.print("+");
		}
        
        
		// 2단계
        // +_+_+_+_+_
        for(int nn =1; nn<=5;nn++) {
        	System.out.print("+_");
        }
		
        // 3단계
        // +++++
        // +++++
        // +++++
        for (int k=1; k<=3;k++) {
        	for(int nn =1; nn<=5;nn++) {
            	System.out.print("+");
            } 
            System.out.println();
        }
       
        // 4단계
        // 11111
        // 22222
        // 33333
        // 44444
        // 55555
		for (int k=1; k<=5; k++) {
			for(int j=1;j<=5;j++) {
				System.out.print(k);
			}
			System.out.println();
		}
         
        // 5단계
        // 1
        // 22
        // 333
        // 4444
        // 55555
		for (int k=1; k<=5; k++) {
			for(int j=1;j<=k;j++) {
				System.out.print(k);
			}
			System.out.println();
		}
		
        // 6단계
        // +
        // ++
        // +++
        // ++++
        // +++++
		for (int k=1; k<=5; k++) {
			for(int j=1;j<=k;j++) {
				System.out.print("+");
			}
			System.out.println();
		}
        
        // 7단계
        // 11111
        // 2222
        // 333
        // 44
        // 5
		for (int k=1; k<=5; k++) {
			for(int j=1;j<=(6-k);j++) {
				System.out.print(k);
			}
			System.out.println();
		}
		
        // 8단계
        // +____
        // ++___
        // +++__
        // ++++_
        // +++++
		for (int k=1; k<=5; k++) {
			for(int nn=1;nn<=k;nn++) {
				System.out.print("+");
			}
			for(int j=1;j<=(5-k);j++) {
				System.out.print("_");
			}
			System.out.println();
		}
		
        // 9단계
        // ____+
        // ___++
        // __+++
        // _++++
        // +++++
		for (int k=1; k<=5; k++) {
			for(int j=1;j<=(5-k);j++) {
				System.out.print("_");
			}
			for(int nn=1;nn<=k;nn++) {
				System.out.print("+");
			}
			System.out.println();
		}
	
        // 10단계
        // ____+
        // ___+++
        // __+++++
        // _+++++++
        // +++++++++
		for (int k=1; k<=5; k++) {
			for(int j=1;j<=(5-k);j++) {
				System.out.print("_");
			}
			for(int nn=1;nn<=(2*k-1);nn++) {
				System.out.print("+");
			}
			System.out.println();
		}
		*/	
        // 11단계
        // ____+____
        // ___+++___
        // __+++++__
        // _+++++++_
        // +++++++++
        
		for (int k=1; k<=5; k++) {
			for(int j=(5-k);j>=1;j--) {
				System.out.print("_");
			}
			for(int nn=1;nn<=(2*k-1);nn++) {
				System.out.print("+");
			}
			for(int j2=(5-k);j2>=1;j2--) {
				System.out.print("_");
			}
			System.out.println();
		}
		
		
		int n = scan.nextInt(); // 트리의 줄 수를 입력 받는다
		for(int k=1; k<=n; k++) { // 세로로 반복 명령
			for(int j =1; j<=(n-k);j++) { // 왼쪽 - 출력 
				System.out.print("-");
			}
			for(int nn=1; nn<= (2*k-1) ; nn++) { // *출력
				System.out.print("*");
			}
			for(int j2 =(n-k); j2>=1;j2--) { // 오른쪽 - 출력
				System.out.print("-");
			}
			System.out.println(); // 가로줄 끝
		}
		
	}

}
