package chap05;

public class RefExam {

	public static void main(String[] args) {

		int a =10;
		int b = a;
		System.out.println(a+"   "+ b);
		
		b=12;
		System.out.println(a+"  "+b);
		
		String name = "whtjdfo";
		//= 오른쪽이 먼저 실행됨
		//"조성래"를 힙 영역에 할당, 번지 획득
		// 스택 영역의 변수 name에 번지를 저장
		
		System.out.println(name);
		// name에 저장된 번지의 값을 출력
		
		System.out.println(a ==b);
		// == , != 는 스택영역 값 비교
		System.out.println();
		
		String name2 = new String("whtjdfo");
		//무조건 다른 번지에 저장
		System.out.println(name2);
		System.out.println(name == name2);
		System.out.println(name .equals(name2));
		
		System.out.println();
		String name3 ="whtjdfo";
		System.out.println(name == name3);
		//string은 값이 같으면 번지를 재활용 한다
		
		String name4 = "wh"+"tjdfo";
		//더하기 하면 1번 값 객체 생기고 2번 객체 생기고 더한 결과값 객체 생김
		//용량을 더 많이 먹음
		System.out.println(name==name4);
		
		System.out.println();
		String name5 = name;
		System.out.println(name5);
		System.out.println(name5 == name);
		name="no";
		//string만 특이하게 원본 값이 바뀌면 복사본이 따라가지 않는다
		//복사본은 기존 주소/값 가지고 있고 원본이 새 값 주소 가짐
		System.out.println(name5);
		System.out.println(name5 == name);
		
//		int c = null; 기본 타입은 null 안됨
		//null 주소가 없는 상태
		String addr = "천안";
		System.out.println("addr == null: "+(addr == null) );
		System.out.println("addr != null: "+(addr != null) );
		String addr2 = " ";
		
		addr = null;
		//천안과 연결이 끊어짐 
		//천안은 참조하고 있는 변수가 하나도 없어서 가비지 콜렉터가 지움  
		
		System.out.println("addr+ \"abc\":"+(addr+"abc"));
		//출력할때만 null 라는글씨로 바뀐다 
		
		/*
		if(addr.equals(addr2)) {
			System.out.println("같다");
		}
		addr이 null이라 오류남
		*/
		
		if(addr.equals("천안")) {}
//		방어코딩 필요함 addr이 null일수 있음
	
		if("천안".equals(addr)) {}
		//방어코딩 필요 없음 "천안"은 null일수 없음
	}

}
