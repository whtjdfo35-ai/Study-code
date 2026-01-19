package sec02;

public class ChinaExam {

	public static void main(String[] args) {
		
		China china1 = new China();
		China china2 = new China();
		
		System.out.println(china1.name);
		System.out.println(china1.address);
		for (int i =0; i<china1.menus.length;i++) {
			System.out.println(china1.menus[i]);
		}	
		
		china1.name += 1;
		china2.name = "fd2";
		china1.address ="대흥로215";
		china2.address="대흥로216";
		china2.price[2] -=500;
				
		System.out.println(china1.name);
		System.out.println(china1.address);
		for (int i =0; i<china1.menus.length;i++) {
			System.out.println(china1.menus[i]);
			System.out.println(china1.price[i]);
		}
		
		System.out.println(china2.name);
		System.out.println(china2.address);
		for (int i =0; i<china2.menus.length;i++) {
			System.out.println(china2.menus[i]);
			System.out.println(china2.price[i]);
		}
	}

}
