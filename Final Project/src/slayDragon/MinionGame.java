package slayDragon;

import java.util.Scanner;

public class MinionGame {

	public int totalGold;
	public int randomInt;
	public int playerInput;
	public int guessesNumber;
	public int minionRandomizer;
	public int goldPerMinion;
	
	/*
	 * pre: none
	 * post: prints out the rules of the game
	 */
	public void displayIntro() {
		System.out.println("A hoarde of minions have appeared!\n"
				+ "You have to guess numbers from 1 to 3. If you are correct, the minion will die and you will get gold.");
	}
	
	/*
	 * pre: none
	 * post: set all the varaibles
	 */
	public MinionGame() {
		totalGold = 0;
		randomInt = 0;
		playerInput = 0;
		guessesNumber = 0;
		minionRandomizer = 0;
		goldPerMinion = 0;
	}
	
	/*
	 * pre: none
	 * post: generates a random integer for the integer that the user needs to guess
	 */
	public void generateNumber() {
		randomInt = (int)(3*Math.random()+1);
	}
	
	/*
	 * pre: none
	 * post: gets the player input
	 */
	public void getPlayerInput() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number between 1 and 3:");
		playerInput = input.nextInt();
		while (playerInput > 3 || playerInput <1) {
			System.out.println("You have not entered a valid number. Please enter again (1 to 3)");
			playerInput = input.nextInt();
		}
	}
	
	/*
	 * pre: none
	 * post: earns the gold award after guessing the right number
	 */
	public void calculate() {
		if (playerInput == randomInt) {
			minionRandomizer = (int)(6*Math.random() +1);
			switch (minionRandomizer) {
			case 1: goldPerMinion = 5;break;
			case 2: goldPerMinion = 6;break;
			case 3: goldPerMinion = 7;break;
			case 4: goldPerMinion = 8;break;
			case 5: goldPerMinion = 9;break;
			case 6: goldPerMinion = 10;break;
			}
			System.out.println("The minion died and you got " + goldPerMinion + " gold!");
			totalGold += goldPerMinion;
			
		} else {
			if (guessesNumber != 9) {
				System.out.println("The minion didn't die! Try again:");
			} else {
				System.out.println("The minion didn't die!");
			}
			
			
		}
		guessesNumber += 1;
	
	}
	
	/*
	 * pre: none
	 * post: game ends after 10 guesses 
	 */
	public boolean isGameOver() {
		if (guessesNumber == 10) {
			guessesNumber = 0;
			return(true);
		} else {
			return(false);
		}
	}
	
	/*
	 * pre: none
	 * post: returns the total amount of gold the player earns
	 */
	public int getGold() {
		return(totalGold);
	}
	
}
