package quiz.quiz0;

public class Gmarket {

	String itemName;
	int itemPrice;
	String itemInfo;
	
	String id;
	String[] wbuy = new String[5];
	
	void setItem(String itemName, int itemPrice, String itemInfo) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemInfo = itemInfo;
	}
	
	void setUser(String id, String[] wbuy) {
		this.id = id;
		this.wbuy =wbuy;
	}
	
	String getItem() {
		return ("상품명: "+itemName+"\n가격: "+itemPrice+"\n설명: "+itemInfo);
	}
	
	String getUser() {
		return ("id: "+id+"\n장바구니: "+wbuy[0]+wbuy[1]+wbuy[2]+wbuy[3]+wbuy[4]);
	}
	
}
