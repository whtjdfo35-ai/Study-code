package chap05;

import java.util.Scanner;

public class ArrayExam {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		int[] score =new int[30];
		score[0] = 90;
		score[1] = 85;
		score[2] = 70;
		
		String[] str =new String[3];
		System.out.println(str[0]);
		System.out.println(score[5]);
		
		int[] i2 =null;
		i2 = new int[] {90,85,70};
		//선언과 초기화를 따로 할 수 있다
		
		int[] i3 = {90,85,70};
		//선언과 초기화를 같이 하는 방법
		// 간단함 대신 따로 쓸 수 없음
		
		int sum =0;
		for(int i=0; i<3;i++) {
		// for(int i=0; i<i3.length;i++)도 가능
			sum += i3[i];
		}
		System.out.println(sum);
		
		
		
		int[] q1 = new int[10];
		for (int i = 0; i<10 ; i++) {
			q1[i] = i+1;
		}
		for (int i = 0; i<q1.length ; i++) {
			System.out.println("q"+i+" : "+q1[i]);
		}
		
		System.out.println(args);
		System.out.println(args.length);
		for(int i=0; i<args.length;i++) {
			System.out.println(args[i]);
		}
		
		//q2.
		// 7,12,8을 순서대로 저장한 배열이 있을때 다른 배열에 저장
		
		int[] q2 = {7,12,8};
		int[] q2a = new int[3];
		int q2l = q2.length;
		for(int i=0;i<q2l;i++) {
			q2a[i]=q2[i];
		}
		
		
		//q3 역순 저장
		for(int i=0;i<q2l;i++) {
			q2a[i]=q2[q2l-1-i];
		}
		for(int i=0; i<q2l;i++) {
			System.out.println(q2a[i]);
		}
		
		//q4-1 홀수 개수
		// 4-2. 4보다 큰 수의 개수 구하기
		int[] q4 = {3,4,7,5,1,4,6};
		int c1 =0, c2=0;
		for(int i=0;i<q4.length;i++) {
			if(q4[i] %2 ==1) {
				c1++;
			}
			if(q4[i]>4) {
				c2++;
			}
		}
		System.out.println(c1);
		System.out.println(c2);
		
		
		
		        
        // --- 응용(멘탈챙겨) ---
        // 문제5
        /*
         * 마라톤에 5명의 선수가 참여했음
         * 선수들은 1번부터 5번까지 등번호가 있음
         * 대회가 끝났을 때 완주하지 못한 선수를 찾으시오
         * 완주 목록 {2, 4, 5, 1} 
         */
		/*
		System.out.println("q5");
		int[] q5 = new int[5];			// 참여 선수 명단
		int q5l = q5.length;			// 참여 선수 숫자
		for(int i=0; i<q5l;i++) {		// 선수 등번호 부여
			q5[i]=i+1;
		}
		int[] q5a = {2,4,5,1};			// 완주자 명단
		int q5al = q5a.length;			// 완주자 숫자
		int[] q5b = new int[q5l];		// 임시 숫자 
				
		for(int i=0; i<q5l;i++) {
			for(int j=0; j<q5al ;j++){
				if(q5[i] == q5a[j]) { 	// 참여 명단 완주자 명단 비교해서 같을때까지 
					break;
				} else {
					q5b[i]++;			// 다르면 숫자를 더한다
				}
			}
		}
		for(int i =0; i<q5l; i++) {
			if(q5b[i]==q5al) {
					System.out.println(q5[i]);  // 임시 숫자가 완주자 숫자와 같으면 출력
			}		
		}
		
		
        
        // 문제6
        // {3, 4, 7, 5, 1, 4, 6}
        // 여기서 가장 큰 수 찾기
		System.out.println("q6");
		int[] q6 = {3, 4, 7, 5, 1, 4, 6};
		int q6l = q6.length;
		int[] q6a = new int[q6l];
		for(int i=0; i<q6l; i++) {
			for(int j=0; j<q6l;j++) {
				if(q6[i]<=q6[j] && i!=j) {
					break;
				} else if(i!=j){
					q6a[i]++;
				}
			}
		}
		for(int i=0; i<q6l;i++) {
			if(q6a[i]==(q6l-1)) {
				System.out.println(q6[i]);
			}
		}
		
		int max1= q6[0];
		for(int i=0; i<q6l; i++) {
			if(q6[i]>max1){
				max1 =q6[i];
			}
		}	//이렇게 맥스값 찾아도 됨
		
		//q7. 두번째로 큰수 찾기
		// {3, 4, 7, 5, 1, 4, 6}
		
		System.out.println("q7");
		int n = scan.nextInt();
		int[] q7 = {3, 4, 7, 5, 1, 4, 6};
		int q7l = q7.length;
		int[] count = new int[q7l];
		for(int i = 0; i<q7l ; i++) {
			for(int j = 0; j < q7l; j++) {
				if(q7[i] <q7[j] && i!=j) {
					count[i]++;
				}
			}
		}
		for(int i = 0; i<q7l ; i++) {
			if(count[i] ==(n-1)) {
				System.out.println(n+"번째로 큰 수"+q7[i]);
			}
		}
		
		/*
		// 문제8
        // 오른쪽으로 한칸 씩 밀기 
        // 왼쪽은 0으로 채우기
        // 예: 
        // 1라운드: {3, 4, 7, 5, 1, 4, 6}
        // 2라운드: {0, 3, 4, 7, 5, 1, 4}
        // 3라운드: {0, 0, 3, 4, 7, 5, 1}
		
		int[] q8 =  {3, 4, 7, 5, 1, 4, 6};
		int n = scan.nextInt();
		
		System.out.print("1라운드: ");
		for(int i = 0; i<q8.length; i++) {
			System.out.print(q8[i]+" " );
		}
		System.out.println();
		
		for (int k=2; k<=n;k++) {
			System.out.print(k+"라운드: ");
			for(int i =(q8.length-1); i>0; i--) {
				q8[i]=q8[(i-1)];
			}
			q8[0] = 0;
			for(int i = 0; i<q8.length; i++) {
				System.out.print(q8[i]+" " );
			}
			System.out.println();
		}
		
		
		
        // 문제9
        // 오른쪽으로 한칸 씩 밀기
        // 맨 끝 값은 맨 처음으로 보내기
        // 예: 
        // 1라운드: {3, 4, 7, 5, 1, 4, 6}
        // 2라운드: {6, 3, 4, 7, 5, 1, 4}
        // 3라운드: {4, 6, 3, 4, 7, 5, 1}
		int[] q9 =  {3, 4, 7, 5, 1, 4, 6};
		int temp =0;
		int n = scan.nextInt();
		
		System.out.print("1라운드: ");
		for(int i = 0; i<q9.length; i++) {
			System.out.print(q9[i]+" " );
		}
		System.out.println();
		
		for (int k=2; k<=n;k++) {
			System.out.print(k+"라운드: ");
			temp = q9[q9.length-1];
			for(int i =(q9.length-1); i>0; i--) {
				q9[i]=q9[(i-1)];
			}
			q9[0] = temp;
			for(int i = 0; i<q9.length; i++) {
				System.out.print(q9[i]+" " );
			}
			System.out.println();
		}
        
        // 문제10
        // 임시비밀번호 8자리
        // 10-1 : 숫자만
		int rd[] = new int[8];
		for (int i= 0; i<rd.length; i++) {
			rd[i]=(int)(Math.random()*10);
		}
		for (int i= 0; i<rd.length; i++) {
			System.out.print(rd[i]);
		}
		
        // 10-2 : 소문자만
		String[] al = new String[26];			//알파벳 그룹
		String[] Al = new String[26];
		
		for (int i = 0; i < 26; i++) {
		    al[i] = String.valueOf((char) ('a' + i));
		    Al[i] = String.valueOf((char) ('A' + i));
		}
		int rd[] = new int[8];
		for (int i= 0; i<rd.length; i++) {
			rd[i]=(int)(Math.random()*26);
		}
		for (int i= 0; i<rd.length; i++) {
			System.out.print(al[rd[i]]);
		}
		
		//아스키 코드 97-122
		char[] q10c = new char[8]; 
		for (int i =0; i <q10c.length;i++){
			q10c[i]=(char)(int)(Math.random()*(122-97+1))			
		}
		
        // 10-3 : 숫자2개 이상, 대/소문자 각 1개 이상
		int[] no = new int[10];
		for(int i= 0; i<no.length; i++) {
			no[i] = i;
		}
		String[] al = new String[26];			//알파벳 그룹
		String[] Al = new String[26];
		
		for (int i = 0; i < 26; i++) {
		    al[i] = String.valueOf((char) ('a' + i));
		    Al[i] = String.valueOf((char) ('A' + i));
		}
				
		int[] rd = new int[8];
		for(int i=0; i<2;i++) {
			rd[i] = (int)(Math.random()*10);
		}
		rd[2] = (int)(Math.random()*26+10);
		rd[3] = (int)(Math.random()*26+36);
		for(int i=4; i<rd.length;i++) {
			rd[i] =(int)(Math.random()*62);
		}
						
		for(int i =0; i<rd.length;i++) {
			if (rd[i]<10) {
				System.out.print(rd[i]);
			} else if (10 <=rd[i] && rd[i] < 36){
				System.out.print(al[rd[i]-10]);
			} else {
				System.out.print(Al[rd[i]-36]);
			}	
		}
	*/
	/*
	//예시
	 int[] mix = new int[8];

	int aa = 0;
	int bb = 0;
	int cc = 0;

	do {
		aa = 0; // do 안에서 초기값 0 필요!!!!
		bb = 0;
		cc = 0;

		for (int i = 0; i < 8; i++) {
			mix[i] = (int) (Math.random() * 3);
			if (mix[i] == 1) {
				passq[i] = (char) ((Math.random() * 10) + 48);
				aa = aa + 1;
			} else if (mix[i] == 2) {
				passq[i] = (char) ((Math.random() * 26) + 97);
				bb = bb + 1;
			} else {
				passq[i] = (char) ((Math.random() * 26) + 65);
				cc = cc + 1;
			}
		}

	} while (!(aa > 2 && bb > 1 && cc > 1));

	for (int i = 0; i < passq.length; i++) { 
		char mmmix = (char) passq[i];
		System.out.print(mmmix);
	}
	 */
	 
     /*
        // 문제11
        // 자리가 10개 있는 소극장의 예약 시스템
        // 자리 번호는 1~10번까지 번호의 자리가 있습니다
        // 메뉴 : "1.예약 2.모든 좌석 현황 3.잔여 좌석 0.종료"
        // 조건1 : 예약이 가능하다면 "n번 자리 예약 되었습니다"
        // 조건2 : 예약이 되어있다면 "이미 예약 되어 있습니다"
          
         
        int[] st = new int[10];
        int stl = st.length;
               
        boolean run =true;
        while (run) {
        	System.out.println("메뉴 : 1.예약 2.모든 좌석 현황 3.잔여 좌석 0.종료");
        	int me =scan.nextInt();
        	if(me == 1) {
        		System.out.println("예약하실 좌석을 선택해주세요");
        		int rst =scan.nextInt();
        		if (0<=rst && rst<stl) {
        			if (st[rst-1] == 0) {
        				st[rst-1] =1;
        				System.out.println(rst+"번 자리 예약 되었습니다");
        			} else {
        				System.out.println("이미 예약 되어 있습니다");
        			}
        		} else 	{
        			System.out.println("존재하지 않는 좌석입니다");
        		}
        	} else if(me ==2) {
        		for (int i =0; i<stl;i++) {
        			if (st[i]==0) {
        				System.out.println(i+1+"번 예약 가능 ");
        			} else {
        				System.out.println(i+1+"번 예약된 좌석 ");
        			}
        		}
        	} else if(me ==3) {
        		System.out.println("잔여 좌석: ");
        		for (int i =0; i<stl;i++) {
        			if (st[i]==0) {
        				System.out.print(i+"번 ");        				
        			}	
        		}
        		System.out.println();
        	} else if(me==0) {
        		System.out.println("종료");
        		break;
        	} else {
        		System.out.println("?");
        	}
        }
        
       */
       
        // 문제12
        // 로또 번호 6개 배열에 저장
        // 단, 중복 없이!
        
		int[] rot = new int[6];
        for (int i=0; i<rot.length;i++) {
        	rot[i]=(int)(Math.random()*45+1);
        	int m=0;
        	do {
        		m=0;
        		for(int k=0; k<i;k++) {
        			while(rot[i]==rot[k]) {
        				rot[i]=(int)(Math.random()*45+1);
        				m=1;
        			}
        		}
        	}
        	while(m==1);
        }
        for (int i=0; i<rot.length;i++) {
        	System.out.print(rot[i]+" ");
        }
        
     // 정렬해보기
        System.out.println();
        int temp = 0;
        for(int i = 0; i < rot.length - 1; i++) { 
        // 가장 작은 수부터 for문 사이클마다 점점 앞쪽으로 정렬됨
        	for(int j = 0; j < rot.length - 1 ; j++) {
        		if(rot[j] > rot[j + 1]) {
        			temp =rot[j]; 
        			rot[j] =rot[j + 1]; 
        			rot[j + 1] = temp; 
        		}
        	}
        }
        for (int i=0; i<rot.length;i++) {
        	System.out.print(rot[i]+" ");
        }
        
		/*
        // 문제13
        // 주차장에 
        // 0: 주차되어있음
        // 1: 비어있음
        /*
         * {
         *         {0, 0, 0, 0},    // 1층
         *         {0, 0, 0, 0},    // 2층
         *         {1, 0, 1, 0},
         *         {1, 0, 1, 1},
         *         {1, 1, 1, 1},
         * }
         */
		/*
        System.out.println();
		int[][] park = {{0, 0, 0, 0},{0, 0, 0, 0},{1, 0, 1, 0},{1, 0, 1, 1},{1, 1, 1, 1}};
		
        // 13-1 : 2층에 주차된 차량 수 출력
		int n = scan.nextInt();
		int car =0;
		for(int i=0; i<park[n-1].length;i++) {  //열의 갯수 세는법. 변수명[0].length
			car += park[1][i];
		}
		System.out.println(n+"층에 주차 된 차량의 수: "+car);
		
        // 13-2 : 전체 남은 자리 수 출력
		int bl =0;
		for(int i=0;i<park.length;i++) {
			for(int k=0; k<park[n-1].length;k++) { //행의 갯수 세는법. 변수명.length
				bl += park[i][k];
			}
		}
		System.out.println("전체 남은 주차 자리 수: "+((park.length)*(park[0].length)-bl));	
		*/
	}
}
