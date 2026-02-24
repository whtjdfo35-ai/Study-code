package sec02;

public class KeyboardExam {

	public static void main(String[] args) {

		Keyboard k1 = new keyboardImpl();
		String key = k1.press(13);
		System.out.println("k1 key:"+key);
		
		//Keyboard를 implement받은 익명 클래스 생성
		//클래스, 인터페이스를 포함하여 부모를 하나만 가질 수 있다
		Keyboard k2 = new Keyboard(){

			@Override
			public String press(int KeyCode) {
				
				if(KeyCode == 13) {
					return "enter";
				} else {
					return "입력";
				}
			}
		};
	}

}
