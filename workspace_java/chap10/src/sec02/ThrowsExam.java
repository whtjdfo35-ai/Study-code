package sec02;

import java.io.IOException;

public class ThrowsExam {

	public static void main(String[] args) {

		try {
			test();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			test2(11);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

			if (e.getMessage().equals("very loud")) {
				System.out.println("aa");
			} else if (e.getMessage().equals("loud")) {
				System.out.println("bb");
			}
		}

		try {
			test3(8);
		} catch (LoveException e) {
			e.printStackTrace();
		}
	}

	/*
	 * static void test() { try { Class.forName("sec02.ThrowsExam"); } catch
	 * (ClassNotFoundException e) { e.printStackTrace(); } }
	 */

	static void test() throws ClassNotFoundException, IOException {
		Class.forName("sec02.ThrowsExam");
	}

	static void test2(int vol) throws IOException {
		if (vol > 10) {
			throw new IOException("very loud"); // 단일로 에러를 발생시킴
		} else if (vol > 7) {
			throw new IOException("loud");
		}
	}

	static void test3(int vol) throws LoveException {
		if (vol > 10) {
			throw new LoveException("very high");
		} else if (vol > 7) {
			throw new LoveException("high");
		}
	}
}
