package quiz.quiz0;

public class Cinema {

	String title;
	int year;
		
	void setCinema(String title, int year) {
		this.title =title;
		this.year =year;
	}
	void setTitle(String title) {
		this.title = title;
	}
	
	String getTitle() {
		return this.title;
	}
	int getyear() {
		return this.year;
	}
	
	String cinemaInfo() {
		return ("제목: "+this.title+" 개봉연도: "+this.year);
	}
	
	String 속편정보() {
		return ("속편 정보: "+this.title+2);
	}
}
