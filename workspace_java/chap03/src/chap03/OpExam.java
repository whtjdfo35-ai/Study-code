package chap03;

public class OpExam {

	public static void main(String[] args) {
		// 문제1
        // 난 돈이 10000원있음
        // 1. 4500원 짜리 쌍화차를 최대 몇 잔 살 수 있는가?
        // 2. 그리고 남는 돈은?
        int money = 10000;
        int dt = 4500;
        int get = money/dt;
        System.out.println("1-1: "+get+"잔");
        
        int not = money % dt;
        System.out.println("1-2: "+not+"원");
		
        // 문제2
        // 올영에서 꿀홍차가 8000원인데
        // 15% 세일! 그렇다면 가격은?
        int hredtea = 8000;
        double saleprice = hredtea *0.85;
        System.out.println("2-1: "+ (int)saleprice + "원");

        // 문제3-0
        // 1234를 10의 자리 이하 버림
        // 결과 : 1200
        int num = 1234 / 100 *100;
        System.out.println("3-0: "+num);
        
        // 문제3
        double v1 = 1000;
        double v2 = 794.0;
        System.out.println(v1 / v2); // 1.2594458438287153
        // v1 / v2를 소수점 3자리까지만 출력하시오
        // 오칙연산만 plz
        // 결과 : 1.259
        double vv =  v1/v2;
        double tvv = 1000*vv;
        int itvv = (int)tvv;
        double cutvv = (double)itvv /1000;
        // double cutvv = itvv /1000; 는 1.0이 됨
        System.out.println("3-1: "+cutvv);
        

        // 문제4
        // 17000원이 있을 때
        // 5천원 몇장
        // 1천원 몇장
        int have = 17000;
        int yeeyee = have / 5000;
        int hwang = (have % 5000) /1000;
        System.out.println("4:\n"+"5천원: "+yeeyee+"장\n"+ "천원: "+hwang+ "장");
        
        int s = 85;
        String grade = (s > 90) ? "A" : "B";
        System.out.println(grade);
//        String grade = (s > 90) ? "A" : (s>80 ? "B" : "C");

	}

}
