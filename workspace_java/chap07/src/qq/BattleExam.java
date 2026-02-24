package qq;

public class BattleExam {

	public static void main(String[] args) {
		
		Character c1 =  new Character("warrior",100,5,2,2,5);
		Character c2 =  new Character("mage",50,100,0,4,2);
		
		Character2 d1 =  new Character2();
		Character2 d2 =  new Character2();
		d1.setCharacter("warrior",100,5,0,2,2,5,"physics",2,"armor");
		d2.setCharacter("mage",50,1,10,1,1,16,"magic",1,"physics");
		
//		System.out.println("Class:"+c1.charClass+" hp:"+c1.hp+" attack:"+c1.attack+" defend:"+c1.defend);
//		System.out.println("Class:"+c2.charClass+" hp:"+c2.hp+" attack:"+c2.attack+" defend:"+c2.defend);
		Battle b = new Battle();
//		b.battle(c1, c2);
		
//		System.out.println("Class:"+d1.charClass+" hp:"+d1.hp+
//				" attack: "+d1.attack+" d1.mAttack: "+d1.mAtttack+ 
//				" defend: "+d1.defend+" d1.mDefend: "+d1.mDefend);
//		System.out.println("Class:"+d2.charClass+" hp:"+d2.hp+
//				" attack: "+d2.attack+" d2.mAttack: "+d2.mAtttack+ 
//				" defend: "+d2.defend+" d2.mDefend: "+d2.mDefend);
//		b.battle2(d1, d2);
		
		
		
	}

}
