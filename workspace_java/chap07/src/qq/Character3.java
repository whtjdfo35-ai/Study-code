package qq;

public class Character3 {
	String charClass;
	int hp;
	int atk;
	int mAtk;
	int as;
	int def;
	int mDef;
	int wep;
	String wepType;
	int amr;
	String amrType;
	
	int attack;
	int mAtttack;
	int defend;
	int mDefend;

	void setCharacter(String charClass, 
						int hp, 
						int atk, int mAtk, int as,
						int def, int mDef, 
						int wep, String wepType,
						int amr, String amrType) {
		this.charClass = charClass;
		this.hp = hp;
		this.atk = atk;
		this.as = as;
		this.def = def;
		this.wep = wep;
		this.amr = amr;
		this.wepType = wepType;
		this.amrType = amrType;
		
		if(wepType.equals("physics")) {
			this.attack = atk+wep;
			this.mAtttack = mAtk;
		} else {
			this.attack = atk;
			this.mAtttack =mAtk+wep;
		}
		if(amrType.equals("physics")) {
			this.defend = def+amr;
			this.mDefend =mDef;
		} else if(amrType.equals("magic")){
			this.defend = def;
			this.mDefend = mDef+amr;
		} else {
			this.defend = def+amr;
			this.mDefend = mDef+amr;
		}
	}

}
