package slayDragon;

public class Player {
	public int health, DPH, gold, armour, magicResist, maxHealth;
	public double lifeSteal, critChance, reflectDamage, abilityPower;
	public String name;
	public int[] inventory = new int[10];
	int typeSelector;

	/*
	 * pre: none
	 * post: player property set
	 */
	public Player() {
		health = 15;
		maxHealth = 15;
		DPH = 1;
		gold = 50;
		armour = 0;
		magicResist = 0;
		lifeSteal = 0;
		critChance = 0;
		reflectDamage = 0;
	}

	/*
	 * pre: none
	 * post: returns integer gold
	 */
	public int getGold() {
		return gold;
	}

	/*
	 * pre: none
	 * post: returns a array inventory
	 */
	public int[] getInvetory() {
		return inventory;
	}

	/*
	 * pre: playerInput and array itemProperties are passed
	 * post: modifies the player's property and subtract the gold it costs
	 */
	public void updateInventory(int playerInput, double[] itemProperties) {
		inventory[playerInput - 1] = 1;
		gold -= itemProperties[0];
		health += itemProperties[1];
		DPH += itemProperties[2];
		armour += itemProperties[3];
		switch (playerInput) {
		case 4:
			lifeSteal = itemProperties[4];
			break;
		case 6:
			inventory[5] = 1;
			break;
		case 7:
			critChance = itemProperties[4];
			break;
		case 8:
			reflectDamage = itemProperties[4];
			break;
		case 9:
			magicResist = (int) itemProperties[4];
			break;
		case 11:
			abilityPower = itemProperties[4];
			break;
		}
	}

	/*
	 * pre: typeselector paramter passed
	 * post: returns the damage the player does
	 */
	public int playerAttack(int typeSelector) {
		if (typeSelector == 1) {
			if ((100 * Math.random() + 1) <= critChance) {
				System.out.println("You crited the damage");
				return (DPH * 2);
			} else {
				return (DPH);
			}
		} else {
			return (int) (abilityPower);
		}
	}

	/*
	 * pre: none
	 * post: return player health
	 */
	public int getPlayerHealth() {
		return (health);
	}

	/*
	 * pre: none
	 * post: return player armour
	 */
	public int getPlayerArmour() {
		return (armour);
	}

	/*
	 * pre: none
	 * post: return player magic resist
	 */
	public int getPlayerMagicResist() {
		return (magicResist);
	}

	/*
	 * pre: none
	 * post: return player dmaage per hit
	 */
	public int getPlayerDPH() {
		return (DPH);
	}

	/*
	 * pre: none
	 * post: return player ap
	 */
	public double getPlayerAp() {
		return (abilityPower);
	}

	/*
	 * pre: none
	 * post: return player crit chance
	 */
	public double getCritChance() {
		return (critChance);
	}

	/*
	 * pre: none
	 * post: return player life steal
	 */
	public double getLifeSteal() {
		return (lifeSteal);
	}

	/*
	 * pre: none
	 * post: return player reflect dmage %
	 */
	public double getRelfectDmg() {
		return (reflectDamage);
	}

	/*
	 * pre: gold award paramter passed
	 * post: adds the gold after killing the monster or completing the quest
	 */
	public void addGold(int award) {
		gold += award;
	}

	/*
	 * pre: passes a paramter of health potions left after a combat
	 * post: health potions set to int 'left'
	 */
	public void healthPotionLeft(int left) {
		inventory[0] = left;
	}

	/*
	 * pre: player name passed and diffuclty
	 * post: prints out all the stats of the player
	 */
	public void stats(String playerName, int diffculty) {
		System.out.println("Stats");
		System.out.println("BossLevel: " + diffculty);
		System.out.println("Name: " + playerName);
		System.out.println("Gold: $" + getGold());
		System.out.println("Health: " + getPlayerHealth());
		System.out.println("Armour: " + getPlayerArmour());
		System.out.println("Magic Resists: " + getPlayerMagicResist());
		System.out.println("DPH: " + getPlayerDPH());
		System.out.println("AP: " + getPlayerAp());
		System.out.println("Critical Chance %: " + getCritChance());
		System.out.println("Life Steal: " + getLifeSteal());
		System.out.println("Reflect Damage: " + getRelfectDmg());
		System.out.println("\n");
	}
}
