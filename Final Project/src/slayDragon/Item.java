package slayDragon;

public class Item {
	public int healthModifier, DPHModifier, armourModifier;
	public String[] itemName = { "Health potions(restore 20% of your maximum health)",
			"Shatered Blade (Health 100, DPH 50)", "Rusty Sword(DPH 80)",
			"Bloodthirster(20% life steal of Physical Damage DPH 80)", "Gross Cutter(DPH 120, Armour 20)",
			"Cat's Armor(Restores 50% of your max health after you died, Health 300, Armour 20)",
			"Infinity Edge(50% Crit Chance, DPH 120)",
			"Thornmail(Reflects 10% of the monster Damage Health: 250 Armour:10)",
			"Spirit Visage(Health 300 Magic Resist 10)", "Wit's End(DPH 150)", "Lich Bane(Ability power: 100)" };// item
																												// name
	public int[] costs = { 50, 125, 250, 800, 800, 800, 800, 800, 800, 600, 700 }; // costs for each item
	public int[] healthBuffs = { 0, 100, 0, 0, 0, 300, 0, 250, 300, 0, 0 }; // health corresponds to every item
	public int[] DPHBuffs = { 0, 50, 70, 80, 120, 0, 120, 0, 0, 150, 0 }; // DPH corresponds to every item
	public int[] armourBuffs = { 0, 0, 0, 0, 0, 20, 0, 10, 0, 0, 0 }; // armour corresponds to every item
	public double lifeSteal = 0.2; // bloodthirster passive lifeSteal 10% of DPH
	public double critChance = 50; // infinty edge passive have critical chance of 50% (double the damage)
	public double reflectDamage = 0.1; // Reflects 10% of the damage when monster attacks you
	public double abilityPower = 100; // corresponds to the 'Lich Bane' item
	public double magicResist = 10; // corresponds to spirit visage
	public double[] itemProperty = new double[5]; // passes the costs healtBuffs DPHBuffs armourBuffs and passive

	public Item() {
	}

	/*
	 * pre: player enters a input post: return true if player have enough gold to
	 * buy item otherwise return false
	 */
	public boolean getItem(int playerInput, int gold) {
		if (costs[playerInput - 1] <= gold) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * pre: none post: print out item informations
	 */
	public String toString() {
		String storeInfo = "";
		for (int i = 1; i <= itemName.length; i++) {
			storeInfo += i + ". " + itemName[i - 1] + " $" + costs[i - 1] + "\n";
		}
		return (storeInfo);
	}

	/*
	 * pre: player's input passed post: returns all the properties of item that the
	 * player bought
	 */
	public double[] itemProperty(int userInput) {
		itemProperty[0] = costs[userInput - 1];
		itemProperty[1] = healthBuffs[userInput - 1];
		itemProperty[2] = DPHBuffs[userInput - 1];
		itemProperty[3] = armourBuffs[userInput - 1];
		if (userInput == 4) {
			itemProperty[4] = lifeSteal;
		} else if (userInput == 7) {
			itemProperty[4] = critChance;
		} else if (userInput == 8) {
			itemProperty[4] = reflectDamage;
		} else if (userInput == 9) {
			itemProperty[4] = magicResist;
		} else if (userInput == 11) {
			itemProperty[4] = abilityPower;
		} else {
			itemProperty[4] = 0;
		}
		return itemProperty;
	}

}
