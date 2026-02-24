package q1;

public class TvingExam {

	public static void main(String[] args) {
		
		NaverOAuth naver = new NaverOAuth();
		naver.join("aaa", "123");
		naver.join2();
		
		Tving tving = new Tving();
		tving.login(naver, "aaa","123");

	}

}
