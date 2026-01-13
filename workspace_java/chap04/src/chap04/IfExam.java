package chap04;

import java.util.Scanner;

public class IfExam {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		/*
		int score = 95;
		boolean over90 = score >= 90;
		{System.out.println("항상 출력");}
		
		if(over90) {
			System.out.println("90이상");
		}
		if(score <90) {
			System.out.println("90미만");
		}
		if(!(score >= 90)){
//			System.out.println("90미만");
		}
		
		if(score >= 90){
			System.out.println("90이상");
		} else {
			System.out.println("90미만");
		}
		//else가 있으면 무조건 하나는 실행됨
		
		if(score >=90) {
			System.out.println("A");
//		} else if(score < 90 && score >=80) {
		} else if(score >=80) {
//		} else if(80 <= score < 90) { 안됨 .
		//80<= score가 true/false가 먼저 연산되서 true/false <90 이 되는데 true/false는 대소비교불가
		//90미만 80이상
			System.out.println("B");
		} else {
		System.out.println("C");
		}

		if(score >=90) {
			System.out.println("90>");
		}
		if(score < 100 && score >=80) {
			System.out.println("80~100");
		}
		//if 여러개 붙여놓은건 독립시행이라 둘 다 나올수 있다
		
		//if else 는 둘 중 하나만 가능
		if(score >=90) {
			System.out.println("90>>");
		}
		else if(score < 100 && score >=80) {
			System.out.println("80~~100");
		}
		
		int x=3;
		if (x%2 < 1) {
//		if (x%2 == 0) {
//		if (x%2 ==!1) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		
		double rdm = Math.random();
		// 0<= Math.random < 1
		System.out.println("rdm:" + rdm);
		
//		(int)2 *rdm 을 해서 홀짝 계산하는데 사용 가능 
		double rdm2 = 2*rdm;
		int result = (int)rdm2;
		System.out.println("랜덤 홀짝");
		if(result==0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}	
		
		double rdm6 = rdm*6+1;
		System.out.println("주사위");
		System.out.println((int)rdm6);
		
		double rdm10 = rdm*6+5;
		System.out.println((int)rdm10);
		
		int min =5;
		int max =10;
		int rdmxy = (int)(rdm*(max-min+1)+min);
		System.out.println(rdmxy);
	
		rdm6=rdm*10000;
		result = (int)rdm6 % 6 +1;
		System.out.println(result);
		
		double rdm45 = rdm*44;
		int lot1 = (int)(rdm45+1);
//		System.out.println(lot1);
		
		
		int lot2 = (int) ((rdm*rdm)*44+1);
		int lot3 = (int) (rdm*10000%45 +1);
		
		System.out.println(lot1+" i "+lot2+" i "+lot3+ " i ");
		
		double rdma = Math.random();
		System.out.println(rdma);
		
		
		//97 점이면 90~95이상
//		92점이며() 이상
		
		if (score >=95){
			System.out.println("90over");
			System.out.println("95over");
		} else if(score>=90){
			System.out.println("90over");
		}
		
				
		//q1 임의의 수를 입력받아 양수인지 음수인지 0인지
				
		int n = scan.nextInt();
		
		if (n==0) {
			System.out.println("0");
		} else if (n>0) {
			System.out.println("양수");
		} else {
			System.out.println("음수");
		}
		
		
		//q2. 홀수인지 짝수인지 
		if (n%2 ==0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		
		//q3 임의의 두수 x,y를 받아서 둘중에 큰 값 출력
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		if (n1>n2) {
			System.out.println(n1+"가 더 크다");
		} else if(n1<n2) {
			System.out.println(n2+"가 더 크다");
		} else {
			System.out.println("두 수가 같다");
		}
		//System.out.printf("%d와 %d 중 %d가 크다", n1, n2,n1);이런식으로도 가능
		
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int g = n1;
		if(n1>n2) {
			g=n1;
		}else {
			g=n2;
		}
		System.out.println(n1+" "+n2+" "+g+" 더 큼");
		
		
		//q4. 임의의 머니를 입력 받아서 7천원 이상이면 택시타자 출력
		//3천~7천사이면 버스 타자  출력
		//3천 미만 걸어가자 출력
		int money = scan.nextInt();
		if(money >=7000) {
			System.out.println("택시타자");
		} else if(money >=3000) {
			System.out.println("버스타자");
		} else {
			System.out.println("걸어가자");
		}
		
		
		//q5 가위바위보
		//5-1 컴퓨터가 바위만 낼때
		Scanner scan2 = new Scanner(System.in);
		//숫자받고 문자 받을때 숫자 받을때 썼던 엔터 때문에 문자 못받아서 새로 스캔을 지정한다
		String userrsp = scan2.nextLine();
		if (userrsp.equals("바위")) {
			System.out.println("비겼다");
		} 
		if(userrsp.equals("가위")) {
			System.out.println("졌다");
		} 
		if(userrsp.equals("보")){
			System.out.println("이겼다");
		}
	
		
		//5-2 컴퓨터가 랜덤하게 낼때
		String ursp = scan.nextLine();
		double rc = Math.random();
		int rc1 = (int) (rc*3);
				
		if (ursp.equals("가위")) {
			if(rc1==0) {
				System.out.println("당신은 "+ursp+ " ,컴퓨터는 바위. 졌다");
			} else if(rc1 ==1) {
				System.out.println("당신은 "+ursp+ " ,컴퓨터는 가위. 비겼다");
			} else {
				System.out.println("당신은 "+ursp+ " ,컴퓨터는 보. 이겼다");
			}
		}  else if (ursp.equals("바위")) {
			if(rc1==0) {
				System.out.println("당신은 "+ursp+ " ,컴퓨터는 바위. 비겼다");
			} else if(rc1 ==1) {
				System.out.println("당신은 "+ursp+ " ,컴퓨터는 가위. 이겼다");
			} else {
				System.out.println("당신은 "+ursp+ " ,컴퓨터는 보. 졌다");
			}
		} else if (ursp.equals("보")) {
			if(rc1==0) {
				System.out.println("당신은 "+ursp+ " ,컴퓨터는 바위. 이겼다");
			} else if(rc1 ==1) {
				System.out.println("당신은 "+ursp+ " ,컴퓨터는 가위. 졌다");
			} else {
				System.out.println("당신은 "+ursp+ " ,컴퓨터는 보. 비겼다");
			}
		} else {
			System.out.println("?");
		}
		
			
		// 문제6
        // 임의 세 수 x, y, z를 받아서
        // z가 x~y 사이에 있는지(포함) 판단
		int no1 = scan.nextInt();
		int no2 = scan.nextInt();
		int no3 = scan.nextInt();
		if (no1<= no3) {
			if(no3<=no2) {
				System.out.println(no3+"이/가 "+no1+"과 "+no2+"사이에 있다");
			} else {
				System.out.println(no3+"이/가 "+no1+"과 "+no2+"사이에 없다");
			}
		} else if(no2<=no3) {
			if (no3<=no1) {
				System.out.println(no3+"이/가 "+no1+"과 "+no2+"사이에 있다");
			}else {
				System.out.println(no3+"이/가 "+no1+"과 "+no2+"사이에 없다");
			}
		} else {
			System.out.println(no3+"이/가 "+no1+"과 "+no2+"사이에 없다");
		}
		
		
		System.out.println("x: "+ no1+ " y: "+ no2+ " z: "+no3);
		if ( (no1 <= no3 && no3 <= no2) || (no2 <= no3 && no3 <= no1) ) {
			System.out.println("포함됨");
		} else {
		 System.out.println("포함되지 않음");
		}
	
	
		// 문제7
        // 月을 입력 받아서
        // 계절 출력
        // 13, -1등 입력하면 "정확히 입력해주세요" 출력
		int sw = scan.nextInt();
		if (3<= sw && sw<=5) {
			System.out.println("spring");
		} else if(6<=sw && sw<=8) {
			System.out.println("summer");
		} else if(9<=sw && sw <=11) {
			System.out.println("autumn");
		} else if(sw==12 || sw==1 || sw==2) {
			System.out.println("winter");
		} else {
			System.out.println("정확히 입력해주세요");
		}
		
		int sw = scan.nextInt();
		switch(sw){
			case(3):
			case(4):
			case(5): 
				System.out.println("spring");
				break;
			case(6):
			case(7):
			case(8):
				System.out.println("summer");
				break;
			case(9):
			case(10):
			case(11):
				System.out.println("autumn");
				break;
			case(12):
			case(1):
			case(2):
				System.out.println("winter");
				break;
			default:
				System.out.println("정확히 입력해주세요");
		}
		
		
		// 문제8
        // 임의의 수를 입력받아서 다음과 같이 출력
        // 예 : 125
        // 입력한 수는 100보다 크고, 양수이고, 홀수입니다.
		int no8 = scan.nextInt();
		if (no8>100) {
			String a1 = "크고, ";
			String a2 = "양수";
			if (no8%2==0) {
				String a3 = "짝수";
				System.out.println("입력한 수는 100보다"+a1+a2+"이고, "+a3+"입니다.");
			} else {
				String a3 ="홀수";
				System.out.println("입력한 수는 100보다"+a1+a2+"이고, "+a3+"입니다.");
			}
		} else if(no8==100) {
			System.out.println("입력한 수는 100과 같고, 양수이고, 짝수입니다.");
		} else if(no8<=100) {
			String a1 = "작고, ";
			if (no8>0) {
				String a2 = "양수";
				if (no8%2==0) {
					String a3 = "짝수";
					System.out.println("입력한 수는 100보다"+a1+a2+"이고, "+a3+"입니다.");
				} else {
					String a3 ="홀수";
					System.out.println("입력한 수는 100보다"+a1+a2+"이고, "+a3+"입니다.");
				}
			} else if(no8 < 0){
				String a2 ="음수";
				if (no8%2==0) {
					String a3 = "짝수";
					System.out.println("입력한 수는 100보다"+a1+a2+"이고, "+a3+"입니다.");
				} else {
					String a3 ="홀수";
					System.out.println("입력한 수는 100보다"+a1+a2+"이고, "+a3+"입니다.");
				}
			} else {
				System.out.println("입력한 수는 100보다"+a1+"0이고, 짝수입니다.");
			}					
		}
		
		
		if(no8 < 100 && num%2 ==1){
			String re1= "작고";
			String re2= "홀수";
		}
		if (no8>100){
			re1 = "크고";
		}
		if (no8%2 ==0){
			re2 = "짝수";
		}
		System.out.println("입력한 수는 100보다"+re1+re2+"입니다" ));
		이런식으로 쓰는게 더 간결하고 수정할때 편하다
		
		// 문제9
        // 온도를 입력받아서 다음과 같이 출력
        // 예 : -3
        // 영하 3도 입니다
        // 예 : 5
        // 영상 5도 입니다
		
		int tem = scan.nextInt();
		if (tem>0) {
			String b1 = "영상";
			System.out.println(b1+tem+"도 입니다");
		} else if (tem<0) {
			String b1 = "영하";
			System.out.println(b1+(tem*-1)+"도 입니다");
		} else {
			System.out.println(tem+"도 입니다");
		}
		
		
		// 문제10
        // 시, 분을 입력 받아서 35분 후의 시, 분을 출력
        // 3, 51을 입력받으면
        // 4시 26분 출력
		int hour = scan.nextInt();
		int minu = scan.nextInt();
		int min = minu+35;
		if (min >= 60) {
			if (hour==23) {
				System.out.println("00시 "+(min-60)+"분");
			}	else {
				System.out.println((hour+1)+"시 "+(min-60)+"분");
			}
		} else {
			if (hour==24) {
				System.out.println("00시 "+min+"분");
			} else {
				System.out.println(hour+"시 "+minu+"분");			
			}
		}
		
        
        // 문제11
        // 두자리 숫자를 입력받아서
        // 10의 자리와 1의 자리가 같은지 판단
        // 예 : 77 => 같음, 94 => 다름
        int no11 = scan.nextInt();
        int no111 = no11 /10;
        if (no11 >=10 && no11<100) {
        	if (no111 == (no11-10*no111)) {
        		System.out.println(no11+ " 같음");
        	} else {
        		System.out.println(no11+ " 다름");        		
        	}
        } else {
        	System.out.println("?");
        }
        
		
        // 문제12
        // 1~99까지 369게임
        // 임의의 수를 받아서 3,6,9 숫자가 있으면 "박수" 출력
        // 없으면 그 숫자 그대로 출력
        // 예 : 33 => 박수, 31 => 박수, 12 => 12, 14 => 14
        int tsn = scan.nextInt();
        int tsn10 = tsn/10;
        int tsn1 = tsn%10;
        if(1 <= tsn && tsn <=99) {
        	if (tsn10%3 ==0 && tsn10 != 0) {
        		System.out.println("박수");
        	} else if(tsn1%3==0 && tsn1%3 != 0) {
        		System.out.println("박수");        		
        	} else {
        		System.out.println(tsn);
        	}
        } else {
        	System.out.println("?");
        }
       
		
        // 문제13
        // 사각형의 한쪽 모서리 : x1:10, y1:20
        // 반대편 모서리 : x2:90, y2:100
        // 입력받은 두 수를 좌표로 하는 점이 사각형에 겹치는가
		int xa = scan.nextInt();
		int ya = scan.nextInt();
		
		if (10 <= xa && xa<=90) {
			if (20 <= ya && ya<=100) {
				System.out.println("겹침");
			} else {
				System.out.println("겹치지 않음");
			}
		} else {
			System.out.println("겹치지 않음");
		}
		 */	
		
	}
}
