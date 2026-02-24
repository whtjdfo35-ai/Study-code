package chap08;

public class Audio implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("오디오를 켰어");		
	}

	@Override
	public void turnOff() {
		System.out.println("오디오를 끔");		
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
		System.out.println("오디오 볼륨 변경: "+this.vol);
	}	
}
