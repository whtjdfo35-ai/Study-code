package chap04;

import java.util.Scanner;

public class ForExam {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		/*
		int sum = 0;
	    for(int a=1; a<=100; a++) {
			sum += a;
		}
		System.out.println(sum);

		for (int n =1;n<=10;n++) {
			System.out.println(n);
		}	
		
		int sum2 = 0;
		for (int n =1; n<=5;n++) {
			sum2++;
		}System.out.println(sum2);
		
		sum = 0;
		for (int j=1;j<=5;j++) {
			sum += j;
		} System.out.println("sum:"+sum);
		
		int n2  =0;
		for (int j=1; j <=9 ; j++) {
//			n2 += 2 ;
			n2 = 2*j;
			System.out.println(2+" x "+j+" = "+n2);
		}
		
				
		int n = scan.nextInt();
		int pbff = 1;
		int pbf = 1;
		int pb= 0;
		for(int j=1; j<=(n-1); j++) {
//			System.out.println(pb);
			pbff = pbf+pb;
			pb = pbf;
			pbf = pbff;			
		}
		System.out.println(pb);
		//0 1 1 2 3 5 8 13 21 34
		
	
		for(int a=10; a>=1; a--) {
//			System.out.println(a);
		}
		
		for(int a=10; a>=2; a-=2) {
//			System.out.println(a);			
		}
		
		
		int ln = scan.nextInt();
		int lnl = 0;
		for(int j=2;j<=(ln-1);j++) {
			if( ln % j ==0) {
				lnl++;
			} 
		}
		if(lnl>0) {
			System.out.println(ln + " 소수 아님");
		} else {
			System.out.println(ln + " 소수");
		}
		
		
		
		//q1.
		System.out.println("q1");
		for(int j=1; j<=5;j++) {
			if(j%2 ==0) {
				System.out.print(j+": 짝수");
			} else {
				System.out.print(j+": 홀수");				
			}
		}
				
				
		// 문제2
        // 1~100까지 홀수의 합과 개수
		System.out.println("q2");
		int sum3 =0;
		int j=1;
		for(j=1;j<=99;j+=2) {
			sum3 += j; 
		} 
		System.out.print("합: "+sum3+" 개수: "+(j/2));
        System.out.println();
        
        // 문제3
        // 1 ~ 입력 받은 수 까지 더하기
		System.out.println("q3");
        int n = scan.nextInt();
        int sum4 = 0;
        for (int k=1; k<=n; k++) {
        	sum4 += k;        	
        }
        System.out.println("합: "+sum4);
		
		
        // 문제4
        // 1~10까지 3개씩 옆으로 찍
        //    1  2  3
        //    4  5  6 
        //    7  8  9
        //    10
        System.out.println("q4");
		for(int k=1; k<=10; k++) {
			if (k%3 ==0) {
				System.out.println(k);
			} else {
				System.out.print(k+" ");
			}
		} 
		System.out.println();
		       
       
        // 문제5
        // 구구단 모든 단 출력
		
		System.out.println("q5");
		for (int k= 2; k<=9; k++) {
			for(int m =1; m<=9;m++) {
				System.out.println(k + " x " + m +" = "+k*m);
			}
		}
		
		
		// 문제2
        // 구구단 단마다 옆으로 출력
        // 2x1=2 2x2=4...
         
		System.out.println("q2");
		for (int k= 2; k<=9; k++) {
			for(int m =1; m<=9;m++) {
				System.out.print(k + " x " + m +" = "+k*m+"\t");
			}
			System.out.println();
		}
		
		
		// 문제3
        // 구구단 3단씩 옆으로 출력
        // 2x1=2 3x1=3 4x1=4
        // 2x2=4 3x2=6 4x2=8
        // 2x3=6...
		
		System.out.println("q3");
		int k =2;
		for(int c =2; c<=8; c+=3) {
			for (int m=1; m<=9;m++) {
				for( k=c; k<=c+2;k++) {
					if(k<=9) {
						System.out.print(k + " x " + m +" = "+k*m+"\t");
					}	
				}
				System.out.println();
			}
			System.out.println();
		}
		
	
		// 문제4
        // 주사위 2개를 굴려서
        // 나올 수 있는 모든 조합 출력
        // [1,1] [1,2] [6,6]
		
		for (int d1 =1; d1<=6;d1++) {
			for (int d2 =1; d2<=6; d2++) {
				System.out.printf("[%d,%d]",d1,d2);
			}
		}

		
        // 문제5
        // 주사위 2개를 굴려서
        // 합 별로 출력
        // 합2 : [1,1]
        // 합3 : [1,2] [2,1]
		int d1=1 ,  d2=1, sum = d1+d2;
		for (sum=2; sum<=12; sum++) {
			System.out.print("합" + sum+ ": ");
			for(d1=1 ;d1<=6; d1++) {
				for(d2=1;d2<=6;d2++) {
					if((d1+d2)==sum) {
						System.out.printf("[%d,%d]",d1,d2);
					}	
				}	
			}
			System.out.println();
		}
		
		
		int d1=1, d2=1;
		for (int sum=2; sum<=12; sum++) {
			System.out.print("합" + sum+ ": ");
			for(d1=1 ;d1<=6; d1++) {
				d2 = sum-d1;
				if (1 <= d2 && d2<=6) {
					System.out.printf("[%d,%d]",d1,d2);
				}	
			}
			System.out.println();
		}
		
       
        // 문제6
        // 주사위 2개를 굴려서 나올 조합에서
        // 중복 없이 출력
        // 예: [1,2] [2,1] 중복이라서 [1,2]
		
		for (int d1 =1; d1<=6; d1++) {
			for(int d2 =d1; d2<=6;d2++) {
				System.out.printf("[%d,%d]",d1,d2);
			} System.out.println();
		}
		
		
		*/
	
	}
}
