package sec04._return;

public class Car {
	
	int gas;
	
	void setGas(int gas) {
		this.gas = gas;
	}
	
	boolean isLeftGas() {
		if(gas == 0) {
			System.out.println("gas 없음");
			return false;
		} else {
			System.out.println("gas 있음");
			return true;
		}	
	}
	
	boolean isLeftGas2() {
		if(gas == 0) {
			System.out.println("gas 없음");
			return false;
		}
		System.out.println("gas 있음");
		return true;
	}
	
	boolean isLeftGas3() {
		boolean result =false;
		if(gas == 0) {
			System.out.println("gas 없음");
			result = false;
		} else {
			System.out.println("gas 있음");
			result = true;
		}	
		return result;
	}
	
	boolean isLeftGas4() {
		return gas !=0;
	}
	
	void run() {
		while(true) {
			if(gas>0) {
//			if(isLeftGas4()) { 이렇게 쓸수 있음
				System.out.println("go. 잔량: "+gas);
				gas--;
			} else { 
				System.out.println("stop. 잔량: "+gas);
				return; //void는 return생략가능
			}	
		}
	}
}
