package chap02;

public class VarTypeExam {

	public static void main(String[] args) {
		
		// 문제 1
        // 내 나이를 저장
		int age = 34;
		System.out.println("age: "+age);
		        
        // 문제 2
        // 운전면허가 있다/없다
        boolean	 license = true;
        boolean nolicense = false;
		System.out.println(license);
		
        // 문제 3
        // 우리집에 있는 스마트 폰의 개수
        int np = 1;
        System.out.println("np: "+np);
        
        // 문제 4
        // 내 이름 저장
        String name = "조성래";
        System.out.println("name: "+name);
        	
        
        // 문제 5
        // 1평은 3.3제곱미터입니다. 
        // 5평이 몇 제곱미터인지 계산해서 저장
        double p = 3.3;
        System.out.println("p: "+ 5*p);
        
        // 문제 6
        // 6-1 : 두 변수 x, y에 각각 숫자를 넣고
        //    출력 결과 : "3 > 4 결과는 false 입니다"
        int x = 3;
        int y = 4;
        boolean z = x > y; 
        System.out.println(x+">"+y + " 결과는 "+ z+" 입니다" );
//        System.out.println(x+">"+y + " 결과는 "+ (x>y) +" 입니다" );
        
        // 6-2 : x, y 값 바꿔서 정답 나오는지 출력
        x =4;
        y= 3;
        z = x > y;
        //z 값 안 바꿔주면 그 전 z 값이 그대로 나온다
        System.out.println(x+">"+y + " 결과는 "+ z+" 입니다" );

        // 문제 7
        /*
         * 숫자 149
         * ---------
         * 출력 결과
         * ---------
         * "백의 자리 : 1"
         * "십의 자리 : 4"
         * "일의 자리 : 9"
         */
        int n = 149;
        int a = n /100;
        int b = n/10 - 10*a;
        int c = n - 100*a - 10*b;
        System.out.println("백의 자리: "+a+"\n십의 자리: "+b+"\n일의 자리: "+c);

        // 문제 8
        // 회식비 43000원
        // 참석인원 4명
        // 인 당 얼마?
        // 8-1 : 디테일하게 원단위까지
        int price = 43000;
        int num = 4;
        int pay = price / num;
        System.out.println("pay: "+pay);
        
        // 8-2 : 만원 단위까지만 받기
        int pay4 = pay/1000 * 1000;
        System.out.println("pay4: "+pay4);
        
        // 8-2-1 : 주최자는 얼마 내야하는가?
        int hostpay = price -(num-1)*pay4;
        System.out.println("hostpay: "+ hostpay);
        

        // 문제 9
        String left = "오예스";
        String right = "사탕";
     
        String temp = left;
         left = right;
         right = temp;
        	        		
     
        System.out.println("left: "+ left);  // 사탕
        System.out.println("right: "+ right);// 오예스
	
	}

}
