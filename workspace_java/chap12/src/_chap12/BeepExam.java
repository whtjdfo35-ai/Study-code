package _chap12;

public class BeepExam {

	public static void main(String[] args) {

		Runnable task = new Task();
		Thread t1 = new Thread(task);
		t1.start();
		
		System.out.println("main");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Thread t2 = new Thread(task);
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<5; i++) {
					System.out.println("Task2 "+ i);
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		t2.start();
	}

}
