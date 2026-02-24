package chap08;

public interface RemoteControl {
	
	public static final int MAX_VOLUME = 10;
	//인터페이스에서 모든 필드는 public static final이기 때문에 생략가능
	int MIN_VOLUME =0;
	
	public abstract void turnOn();
	//인터페이스에서 모든 메소드는 abstract 메소드기 때문에 생략가능
	void turnOff();
	void setVolume(int vol);
	
	default void mic(String text) {
		System.out.println();
	};
	//추상 메소드는 실행 블록 못 가지니 default로 지정해줌
	//인터페이스에 새 추상 메소드가 생기면
	//가져다 쓴 모든 클래스에서 구현해야 하기 때문에 에러생김
	//default로 메소드 만들어서 구현 하지 않아도 
	//기존에 가져다 썼던 클래스에 에러없음 
}
