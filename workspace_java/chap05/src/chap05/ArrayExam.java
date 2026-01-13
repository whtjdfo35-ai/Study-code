package chap05;

public class ArrayExam {

	public static void main(String[] args) {
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
		
		*/
		
		        
        // --- 응용(멘탈챙겨) ---
        // 문제5
        /*
         * 마라톤에 5명의 선수가 참여했음
         * 선수들은 1번부터 5번까지 등번호가 있음
         * 대회가 끝났을 때 완주하지 못한 선수를 찾으시오
         * 완주 목록 {2, 4, 5, 1} 
         */
		System.out.println("q5");
		int[] q5 = new int[5];
		int q5l = q5.length;
		for(int i=0; i<q5l;i++) {
			q5[i]=i+1;
		}
		int[] q5a = {2,4,5,1};
		int q5al = q5a.length;
		int[] q5b = new int[q5l];
				
		for(int i=0; i<q5l;i++) {
			for(int j=0; j<q5al ;j++){
				if(q5[i] == q5a[j]) {
					break;
				} else {
					q5b[i]++;
				}
			}
		}
		for(int i =0; i<q5l; i++) {
			if(q5b[i]==q5al) {
					System.out.println(q5[i]);
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
		
	}
}
