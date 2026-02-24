package q1;

public class NaverOAuth extends OAuth {
	@Override
	boolean join(String id,String pw) {
		System.out.println("네이버 회원가입 페이지");
		if(id == null || id.trim() =="") {
			return false;
		}
		if(this.id == null) {
			this.id = id;
		} else {
			if (!this.id.equals(id)) {
				this.id = id;
			} else {
				return false;
			}	
		}
		this.pw = pw;
		return true;
	}
	
	@Override
	boolean login(String id, String pw) {
		System.out.println("네이버 로그인");
		return loginCheck(id,pw);
	}
}
