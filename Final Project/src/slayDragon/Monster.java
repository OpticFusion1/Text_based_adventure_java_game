package slayDragon;

public class Monster {
	public int health, DPH, MPH, armour, magicResist, missChance, award;
	private int magicRandomizer;
	public String name;
	
	/*
	 * pre: none;
	 * post: set varaibles
	 */
	public Monster() {
		missChance = 0;
		health = 0;
		DPH = 0;
		MPH = 0;
		armour = 0;
		magicRandomizer = 0;
		magicResist = 0;
		award = 0;
	}
	/*
	 * Difficulty will be a number from 1 to 10
	 * This is internal, not entered, will change to different monsters when player selects to fight
	 */
	public void bossLevel(int difficulty) {
		switch (difficulty) {
		case 1:
			name = "Teemo";
			missChance = 10;
			health = 10;
			DPH = 1;
			MPH = 1;
			armour = 0;
			magicRandomizer = 50;
			magicResist = 0;
			award = 100; 
			break;			
		case 2: 
			name = "Lulu";
			missChance = 9;
			health = 50;
			DPH = 3;
			MPH = 5;
			armour = 6;
			magicRandomizer = 65;
			magicResist = 6;
			award = 300; 
			break;
		case 3: 
			name = "Tristana";
			missChance = 8;
			health = 100;
			DPH = 15;
			MPH = 10;
			armour = 10;
			magicRandomizer = 35;
			magicResist = 10;
			award = 500; 
			break;
		case 4: 
			name = "Zoe";
			missChance = 8;
			health = 350;
			DPH = 20;
			MPH = 50;
			armour = 15;
			magicRandomizer = 80;
			magicResist = 15;
			award = 1000;
			break;
		case 5: 
			name = "Udyr";
			missChance = 8;
			health = 1000;
			DPH = 40;
			MPH = 20;
			armour = 16;
			magicRandomizer = 30; 
			magicResist = 16;
			award = 1000;
			break;
		case 6: 
			name = "Karthus";
			missChance = 7;
			health = 2500;
			DPH = 50;
			MPH = 75;
			armour = 20;
			magicRandomizer = 90; 
			magicResist = 20;
			award = 1000;
			break;
		case 7: 
			name = "LeBlanc";
			missChance = 7;
			health = 5000;
			DPH = 100;
			MPH = 150;
			armour = 30;
			magicRandomizer = 85; 
			magicResist = 30;
			award = 1000;
			break;
		case 8:
			name = "Riven";
			missChance = 7;
			health = 8000;
			DPH = 250;
			MPH = 50;
			armour = 35;
			magicRandomizer = 10; 
			magicResist = 35;
			award = 1000;
			break;
		case 9: 
			name = "Yasuo";
			missChance = 6;
			health = 10000;
			DPH = 300;
			MPH = 100;
			armour = 40;
			magicRandomizer = 10; 
			magicResist = 40;
			award = 1000;
			break;
		case 10: 
			name = "Zed";
			missChance = 5;
			health = 15000;
			DPH = 400;
			MPH = 250;
			armour = 45;
			magicRandomizer = 5; 
			magicResist = 45;break;
		}
	}
	
	/*
	 * pre: typeSelector paramter passed to determine what the damage the monster does (ap or ad)
	 * post: returns the damage the mosnter does to the player
	 */
	public int monsterAttack(int typeSelector) {
		int randomizer = (int)(100*Math.random()+1);
		if (randomizer <= missChance) {
			System.out.println("Monster missed");
			return(0);
		} else {
			if (typeSelector <= magicRandomizer) {
				return(MPH);
			} else {
				return(DPH);
			}
			
		}
	}
	
	/*
	 * pre: none;
	 * post: return the chance of monster doing magic damage
	 */
	public int getMagicRandomizer() {
		return (magicRandomizer);
	}
	
	/*
	 * pre: none;
	 * post: returns the mosnter's name
	 */
	public String getName() {
		return(name);
	}
	
	/*
	 * pre: none;
	 * post: returns the mosnter's health
	 */
	public int getMonsterHealth() {
		return (health);
	}
	
	/*
	 * pre: none;
	 * post: returns the mosnter's armour
	 */
	public int getArmour() {
		return (armour);
	}
	
	/*
	 * pre: none;
	 * post: returns the mosnter's magic resist
	 */
	public int getMagicResist() {
		return (magicResist);
	}
	
	/*
	 * pre: none;
	 * post: returns the gold award after killing the monster
	 */
	public int getAward() {
		return (award);
	}
	
}