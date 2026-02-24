package chap08;

public class Tv extends Display implements RemoteControl, OTT {

	@Override
	public void turnOn() {
		System.out.println("Tv를 켰어");		
	}

	@Override
	public void turnOff() {
		System.out.println("tv를 끔");		
	}

	int vol;
	
	@Override
	public void setVolume(int vol) {
		if (vol> RemoteControl.MAX_VOLUME) {
			vol = RemoteControl.MAX_VOLUME;
		} else if (vol < RemoteControl.MIN_VOLUME) {
			vol = RemoteControl.MIN_VOLUME;
		}
		this.vol = vol;
		System.out.println("tv 볼륨 변경: "+this.vol);		
	}

	@Override
	public void netflix() {
		System.out.println("넷플릭스 시청");		
	}

}
