package slayDragon;

import java.util.Scanner;

public class TestGame {

	public static void main(String[] args) {
		int playerInput;
		int difficulty = 1;
		double[] itemProperties;
		String playerName;
		boolean enoughGold;
		boolean endGame = false;
		Item itemInfo = new Item();
		Player player = new Player();
		Monster monster = new Monster();
		Combat battle = new Combat();
		Gamble gambling = new Gamble();
		MinionGame minions = new MinionGame();
		PathSequence path = new PathSequence();
		Scanner input = new Scanner(System.in);

		System.out.print("Enter your name: ");
		playerName = input.nextLine();

		while (!endGame) {
			System.out.println("1. Go on Quest");
			System.out.println("2. Store");
			System.out.println("3. Kill Boss (Boss Level: " + difficulty + ")");
			System.out.println("4. Stats");
			playerInput = input.nextInt();

			switch (playerInput) {
			case 1:
				System.out.println("1. Path Sequences");
				if (!path.isGameWon) {
					System.out.println("2. Killing minions");
				} else {
					System.out.println("2. Killing minions (quest complete)");
				}
				System.out.println("3. Gambling");
				playerInput = input.nextInt();
				switch (playerInput) {
				case 1:
					if (!path.isGameWon) {
						path.displayIntro();
						while (!path.isGameWon && !path.isPlayerDead) {
							
							path.getPlayerInput();
							path.calculate();
						}
						if (path.isGameWon) {
							player.addGold(1000);
						}
					} else {
						System.out.println("You already got the treasure!");
					}
					path.playerReset();
					break;
				case 2:
					minions.displayIntro();
					while (!minions.isGameOver()) {
						
						minions.generateNumber();
						minions.getPlayerInput();
						minions.calculate();
					}
					System.out.println("You got a total of $" + minions.getGold() + " gold!");
					player.addGold(minions.getGold());
					break;
				case 3:
					gambling.getPlayerInput(player.getGold());
					gambling.generateNumber();
					player.addGold(gambling.calculateGuess());
					System.out.println("You have " + player.getGold() + "$ left");
					break;
				}
				break;
			case 2:
				System.out.println("Gold: $" + player.getGold()); 
				System.out.print(itemInfo);
				System.out.print("Which item do you want to buy? (any other integer to quit): ");
				playerInput = input.nextInt();
				if (playerInput <=0 || playerInput > 11) {
					System.out.println("\n");
					break;
				}
				enoughGold = itemInfo.getItem(playerInput, player.getGold());
				if (enoughGold) {
					itemProperties = itemInfo.itemProperty(playerInput);
					player.updateInventory(playerInput, itemProperties);
				} else {
					System.out.println("Not Enough Gold");
				}
				break;
			case 3:
				monster.bossLevel(difficulty);
				battle.info(player.getPlayerHealth(), player.getPlayerArmour(), player.getPlayerMagicResist(),
						monster.getMonsterHealth(), monster.getName(), monster.getArmour(), monster.getMagicResist(),
						monster.getMagicRandomizer(), player.getLifeSteal(), player.getRelfectDmg(), player.getInvetory());

				while (battle.getPlayerCurrentHealth() > 0 && battle.getMonsterCurrentHealth() > 0) {
					System.out.print("Enter 1 to do physical damage and 2 to do ability damage or 3 to use your potion: ");					
					playerInput = input.nextInt();
					
					//Blank line
					System.out.println("");
					
					int typeSelector = (int) (100 * Math.random() + 1);
					battle.startBattle(player.playerAttack(playerInput), monster.monsterAttack(typeSelector),
							playerInput, typeSelector);
					if (battle.getMonsterCurrentHealth() <= 0) {
						player.addGold(monster.getAward());
						if (difficulty == 10) {
							endGame = true;
							System.out.println("You have beat the Game!!!");
						} else {
							System.out.println("You earned $" + monster.getAward() + " after killing " + monster.getName()+ "!!!");
							difficulty += 1;
						}
					}
				}
				player.healthPotionLeft(battle.healthPotions);
				break;
			case 4:
				player.stats(playerName, difficulty);
			}
		}
	}

}
