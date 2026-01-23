package quiz.quiz0;

public class Cafe {
	String name;
	int cost;
	String menu1;
	String menu2;
	
	Cafe(String name, int cost){
		this.name = name;
		this.cost = cost;
		this.menu1 = "아아";
		this.menu2 = "따아";
	}
	
	String info() {
		return ("카페 이름: "+this.name+ "\n창업 비용: "+this.cost+"만원 "+
				"\n메뉴: "+ this.menu1+", "+this.menu2);
	}
}
