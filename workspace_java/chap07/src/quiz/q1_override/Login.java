package quiz.q1_override;

public class Login {

	private String id;
	private String pw;
	
	Login(String id, String pw){
		System.out.println("Login 생성자 실행");
		
		if(id == null) {
			this.id = "아이디 없음";
		} else {
			this.id = id;
		}
		
		this.pw = pw;
	}
	
	void login( String id, String pw ) {
		
		boolean result = loginCheck(id, pw);
		
		if(result) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
	}
	
	boolean loginCheck( String id, String pw ) {
		if(this.id.equals(id) && this.pw.equals(pw)) {
			return true;
		} else {
			return false;
		}
	}
}
