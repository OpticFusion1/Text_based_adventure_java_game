package slayDragon;

public class Combat {
	public int playerHealth, maxHealth;
	public int monsterHealth;
	public String monsterName;
	public int monsterArmour, monsterMagicResist, magicRandomizer;
	public int playerArmour, playerMagicResist;
	public double lifeSteal, reflectDmg;
	public int healthPotions;
	public int catsAmour;

	/*
	 * pre: none
	 * post: set all the variables needed for this class
	 */
	public void info(int pHealth, int pArmour, int pMagicResist, int mHealth, String z, int mArmor, int mMagicResist,
			int randomizer, double lifeS, double reflect, int[] inventory) {
		playerHealth = pHealth;
		maxHealth = pHealth;
		monsterHealth = mHealth;
		monsterName = z;
		monsterArmour = mArmor;
		monsterMagicResist = mMagicResist;
		magicRandomizer = randomizer;
		playerArmour = pArmour;
		playerMagicResist = pMagicResist;
		lifeSteal = lifeS;
		reflectDmg = reflect;
		catsAmour = inventory[5];
		healthPotions = inventory[0];
	}

	/*
	 * pre: player's/monster's attack damage are passed and which damage they does (ap or ad)
	 * post: calculates the amount of actual damage it does (after considering the armour and magic resists it has)
	 * 		 then player/monster takes the damage
	 */
	public void startBattle(int playerAttack, int monsterAttack, int playerAdOrAp, int typeSelector) {
		if (typeSelector <= magicRandomizer) {
			playerHealth -= (int) (monsterAttack * (1 - ((double) playerMagicResist / 100)) + 0.5);
			System.out.println(monsterName + " did "
					+ (int) (monsterAttack * (1 - ((double) playerMagicResist / 100)) + 0.5) + " magic damage!");
			if (reflectDmg != 0) {
				monsterHealth -= (int) (monsterAttack * (reflectDmg));
				System.out.println("You relfected " + (int) (monsterAttack * (reflectDmg)) + " damage to the monster.");
			}
		} else {
			playerHealth -= (int) (monsterAttack * (1 - ((double) playerArmour / 100)) + 0.5);
			System.out.println(monsterName + " did " + (int) (monsterAttack * (1 - ((double) playerArmour / 100)) + 0.5)
					+ " physical damage!");
			if (reflectDmg != 0) {
				monsterHealth -= (int) (monsterAttack * (reflectDmg));
				System.out.println("You relfected " + (int) (monsterAttack * (reflectDmg)) + " damage to the monster.");
			}
		}
		if (playerAdOrAp == 1) { // ad attack
			monsterHealth -= (int) ((playerAttack * (1 - ((double) monsterArmour / 100))) + 0.5);
			System.out.println("You did " + (int) ((playerAttack * (1 - ((double) monsterArmour / 100))) + 0.5)
					+ " physical damage!");
			if (lifeSteal != 0) {
				playerHealth += (int) (playerAttack * (lifeSteal));
				if (playerHealth > maxHealth) {
					playerHealth = maxHealth;
					System.out.println("You life stealed to max health!");
				} else {
					System.out.println("You life stealed: " + (int) (playerAttack * (lifeSteal)) + " health");
				}
			}

		} else if (playerAdOrAp == 2) { // ap attack
			monsterHealth -= (int) (playerAttack * (1 - ((double) monsterMagicResist / 100)) + 0.5);
			System.out.println("You did " + (int) (playerAttack * (1 - ((double) monsterMagicResist / 100)) + 0.5)
					+ " magic damage!");
		} else { // potion
			if (playerHealth >= (double) (maxHealth * 0.8) && healthPotions > 0) {
				healthPotions -= 1;
				playerHealth = maxHealth;
				System.out.println("You healed to max health. You have " + healthPotions + " left.");
			} else if (healthPotions > 0) {
				healthPotions -= 1;
				playerHealth += (int) (maxHealth * 0.2);
				System.out.println("You healed " + (int) (maxHealth * 0.2) + ". You have " + healthPotions + " left.");
			} else {
				System.out.println("You do not have enough potions left!");
			}
		}
		
		if (playerHealth<=0) {
			System.out.println("You have 0 health left.");
		} else {
			System.out.println("You have " + playerHealth + " health left.");
		}
		
		if (monsterHealth > 0) {
			System.out.println(monsterName + " has " + monsterHealth + " health left.");
		} else {
			System.out.println("You have killed " + monsterName + "!\n");

		}
		if (playerHealth <= 0 && catsAmour == 1) {
			catsAmour -= 1;
			playerHealth = (int) (maxHealth * 0.5);
			System.out.println("You had Cats Armour now you are 50 % of your max health(" + (int) (maxHealth * 0.5)
					+ " health)!!!");
		} else if (playerHealth <= 0) {
			System.out.println("You died to " + monsterName + "!");
		}
	}

	/*
	 * pre: none
	 * post: returns the palyer's health after 1 round of battle
	 */
	public int getPlayerCurrentHealth() {
		return playerHealth;
	}

	/*
	 * pre: none
	 * post: returns the monster's health after 1 round of battle
	 */
	public int getMonsterCurrentHealth() {
		return monsterHealth;
	}

	/*
	 * pre: none
	 * post: returns the health potions left
	 */
	public int healthPotionLeft() {
		return healthPotions;
	}

}
