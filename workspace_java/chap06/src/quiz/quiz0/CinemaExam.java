package quiz.quiz0;

public class CinemaExam {

	public static void main(String[] args) {
		
		// 문제3 #메소드
        // 영화 관리
        // 제목, 개봉년도
        // 메소드를 통해서
        // - 각 값을 따로 받아서 따로 저장하기
        //    + 제목만 받아서 필드에 저장하는 메소드
        // - 각 값을 하나만 돌려주는 메소드
        //    + 제목만 돌려주는 메소드
        // - 모든 정보를 이쁘게 출력
        // 2개 이상의 영화를 관리해보자
		
		Cinema c1 = new Cinema();
		c1.setCinema("a", 2000);
		
		Cinema c2 = new Cinema();
		c2.setCinema("b", 2020);
		
		System.out.println(c1.cinemaInfo());
		System.out.println(c2.cinemaInfo());
		
		System.out.println(c1.속편정보());
		
	}

}
