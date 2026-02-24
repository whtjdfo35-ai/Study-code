package quiz.q1_override;

public class NaverLogin extends Login {

	NaverLogin(String id, String pw){
		super(id, pw);
	}
	
	@Override
	void login( String id, String pw ) {
		boolean result = loginCheck(id, pw);
		
		if(result) {
			System.out.println("네이버 로그인 성공");
		} else {
			System.out.println("네이버 로그인 실패");
		}
	}
}
