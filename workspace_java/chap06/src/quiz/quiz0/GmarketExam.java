package quiz.quiz0;

public class GmarketExam {

	public static void main(String[] args) {
		
		// 심화1
        // G마켓 만들기
        // * 상품
        //     상품명, 가격, 상세정보
        // * 사용자
        //     ID, 장바구니[5]
        // * 쇼핑몰(main)
        //     1. 상품 3개 이상 진열
        //     2. 회원 2명 이상
        //     3. 회원의 장바구니에 물건 2개 이상씩 담기
        //     4. 회원별로 장바구니 내역 출력
        
		
		Gmarket item1 = new Gmarket();
		item1.setItem("a", 1000, "aaaa");
		Gmarket item2 = new Gmarket();
		item2.setItem("b", 2000, "bbbbb");
		Gmarket item3 = new Gmarket();
		item3.setItem("c", 10000, "ccccc");
		
		Gmarket u1 = new Gmarket();
		u1.setUser("u1", );
		
	}

}
