package quiz.quiz0;

import java.util.ArrayList;

public class EmpExam {

	public static void main(String[] args) {
		
		// 문제5
        // * Emp
        //    - 사번, 이름, 직급, 연봉, 상사의 사번
        //    - 모든 정보를 출력하는 메소드 info()
        // * EmpExam
        //    - Emp를 3명 이상 만들기
        //    - 3명을 배열이나 ArrayList에 넣고
        //    - 반복문으로 각자의 info() 실행
        
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		Emp e3 = new Emp();
		e1.setEmp(0, "a", "ceo", 5000, 0);
		e2.setEmp(1, "b", "ma", 2000, 0);
		e3.setEmp(2, "c", "sm", 1000, 1);
		
		ArrayList al =new ArrayList();
		al.add(e1);
		al.add(e2);
		al.add(e3);
		
		e1.info();
		e2.info();
		e3.info();

		
			// 문제6
	        // * Emp
	        //    - 사번, 이름, 직급, 연봉, 상사의 사번
	        // * EmpTable
	        //    - 사원추가(Emp)
	        //    - 출력() : 모든 사원 정보를 출력
	        // * EmpExam
	        //    - EmpTable도 만들고
	        //    - Emp를 3명 이상 만들고
	        //    - EmpTable에 Emp 만든거 넣기
	        //    - EmpTable에 있는 Emp 정보 출력

			
		
        // 문제6-1
        //   연봉이 2000원 이상인 사원만 출력
		
		
		
        // 문제6-2(무슨말인지 모르면 풀지 말자. 성질버린다)
        //   사원1의 상사가 누구인지 출력
        //   (Emp를 잘 만들어둬야 하겠죠?)
		
	}

}
