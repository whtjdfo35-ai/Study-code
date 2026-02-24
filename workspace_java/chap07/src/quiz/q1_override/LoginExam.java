package quiz.q1_override;


public class LoginExam {

	public static void main(String[] args) {

		NaverLogin naver = new NaverLogin("abc", "1234");
//		naver.id = null;
		
		naver.login("abc", "12345");
		
		Login a = new Login("qwer","1331");
		Login l = new Login(null,"123");
		
	}

}
