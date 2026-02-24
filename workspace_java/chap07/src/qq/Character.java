package qq;

public class Character {
	String charClass;
	int hp;
	int atk;
	int def;
	int wep;
	int amr;
	
//	int attack = atk+wep;
//	int defend = def+amr;
	
//	int attack(int atk,int wep) {
//		return atk+wep;
//	}
//
//	int defend(int def,int amr) {
//		return def+amr;
//	}
	int attack;
	int defend;
	
	Character(String charClass, 
					int hp, int atk, int def, 
					int wep, int amr) {
		this.charClass = charClass;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.wep = wep;
		this.amr = amr;
		this.attack = atk+wep;
		this.defend = def+amr;
	}
}
