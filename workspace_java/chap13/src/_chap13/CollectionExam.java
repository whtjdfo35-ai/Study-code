package _chap13;

import java.util.ArrayList;
import java.util.List;

public class CollectionExam {

	public static void main(String[] args) {

		List list = new ArrayList();
		System.out.println(list.isEmpty());
		
		list.add(123);
		list.add("글씨");
		System.out.println(list);
		
		list.add(1, "삽입");
		System.out.println(list);
		
		// 검색
		System.out.println(list.contains("글씨"));
		
		System.out.println( list.get(0) );
		
		list.remove(1);
		System.out.println(list);
		
		System.out.println( list.size() );
		System.out.println(list.isEmpty());
		
		System.out.println("----------------");		
		
	}

}
