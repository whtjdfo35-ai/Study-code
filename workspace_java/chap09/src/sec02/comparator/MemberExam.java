package sec02.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MemberExam {

	public static void main(String[] args) {
		MemberDTO m1 = new MemberDTO("이름1",25);
		MemberDTO m2 = new MemberDTO("그분",20);
		MemberDTO m3 = new MemberDTO("이분",26);
		MemberDTO m4 = new MemberDTO("이름2",23);
		
		List list = new ArrayList();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		
		Comparator c1 = new ComparatorImpl();
		
		Collections.sort(list,c1);
		for(int i =0;i<list.size();i++) {
			System.out.println(((MemberDTO)list.get(i)).name);
			System.out.println(((MemberDTO)list.get(i)).age);			
		}
		
		Comparator c2 = new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				MemberDTO m1= (MemberDTO)o1;
				MemberDTO m2= (MemberDTO)o2;
				int result = m1.age - m2.age; 
				return result;
			}
			
		};
				
	}

}
