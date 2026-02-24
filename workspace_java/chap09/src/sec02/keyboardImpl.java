package sec02;

public class keyboardImpl implements Keyboard {

	@Override
	public String press(int KeyCode) {
		
		if(KeyCode == 13) {
			return "enter";
		} else {
			return "입력";
		}
	}

}
