package qq;

public class Battle {
	void battle(Character c1, Character c2) {
		System.out.println("전투 시작");
		while(c1.hp > 0 && c2.hp > 0) {			
//			c1.hp += c1.defend(c1.def,c1.amr) - c2.attack(c2.atk,c2.wep);
//			c2.hp += c2.defend(c2.def,c2.amr) - c1.attack(c1.atk,c1.wep);
			c1.hp = c1.hp + c1.defend - c2.attack;
			c2.hp = c2.hp + c2.defend - c1.attack;				
		}
		if(c1.hp <=0 && c2.hp > 0) {
			System.out.println(c2.charClass+" win!");
		} else if(c1.hp > 0 && c2.hp <=0) {
			System.out.println(c1.charClass+ " win!");
		} else {
			System.out.println("draw");
		}
	}
	
	void battle2(Character2 c1, Character2 c2) {
		System.out.println("전투 시작");
		int c1Dmg;
		int c2Dmg;
		
		if(c1.wepType.equals("physics")) {
			c1Dmg = c1.attack - c2.defend;
		} else {
			c1Dmg = c1.mAtttack - c2.mDefend;
		}
		if(c2.wepType.equals("physics")) {
			c2Dmg = c2.attack - c1.defend;
		} else {
			c2Dmg = c2.mAtttack - c1.mDefend;
		}
		
		while(c1.hp > 0 && c2.hp > 0) {
			c1.hp -= c2Dmg;
			c2.hp -= c1Dmg;
		}
		
		if(c1.hp <=0 && c2.hp > 0) {
			System.out.println(c2.charClass+" win!");
		} else if(c1.hp > 0 && c2.hp <=0) {
			System.out.println(c1.charClass+ " win!");
		} else {
			System.out.println("draw");
		}
	}
	
	void battle3(Character3 c1, Character3 c2) {
		System.out.println("전투 시작");
		int c1Dmg;
		int c2Dmg;
		
		if(c1.wepType.equals("physics")) {
			c1Dmg = c1.attack - c2.defend;
		} else {
			c1Dmg = c1.mAtttack - c2.mDefend;
		}
		if(c2.wepType.equals("physics")) {
			c2Dmg = c2.attack - c1.defend;
		} else {
			c2Dmg = c2.mAtttack - c1.mDefend;
		}
	}
}
