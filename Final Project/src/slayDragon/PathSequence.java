package slayDragon;

import java.util.Scanner;

public class PathSequence {

	private int playerInput;
	private int forkNumber;
	private int F1 ,F2, F3, F4, F5;
	public boolean isPlayerDead, isGameWon;
	
	/*
	 * pre: none
	 * post: prints out the rules for the game
	 */
	public void displayIntro() {
		System.out.println("You have wandered around the world and found a huge cave. "
				+ "However, you hear the mythical dragon of legend which is rumored to be invincible."
				+ " You must avoid it at all costs.");
	}
	
	/*
	 * pre: none
	 * post: sets the sequences
	 */
	public PathSequence() {
		playerInput = 0;
		forkNumber = 1;
		F1 = 1;
		F2 = 1;
		F3 = 2; 
		F4 = 1;
		F5 = 2;
		isGameWon = false;
		isPlayerDead = false;
	}
	
	/*
	 * pre: none
	 * post: gets player input
	 */
	public void getPlayerInput() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Do you want to go left or right? (1 for left, 2 for right): ");
		playerInput = input.nextInt();
		
		while (playerInput <1 || playerInput > 2) {
			System.out.println("The number was entered in the incorrect range. Please enter 1 for left, 2 for right");
			playerInput = input.nextInt();
		}
		}
	
	/*
	 * pre: none;
	 * post: calculates if the player gets the correct path
	 */
	public void calculate() {
		switch (forkNumber) {
		case 1: if (playerInput == F1) {
					System.out.println("You turned the corner and didn't see the dragon! Keep going!");
				} else {
					System.out.println("You turned the corner and came face to face with the dragon... and died.");
					isPlayerDead = true;
				};break;
				 
		case 2: if (playerInput == F2) {
					System.out.println("You turned the corner and didn't see the dragon! Keep going!");
				} else {
					System.out.println("You turned the corner and came face to face with the dragon... and died.");
					isPlayerDead = true;
					};break;
					
		case 3: if (playerInput == F3) {
					System.out.println("You turned the corner and didn't see the dragon! Keep going!");
				} else {
					System.out.println("You turned the corner and came face to face with the dragon... and died.");
					isPlayerDead = true;
				};break;
				
		case 4: if (playerInput == F4) {
					System.out.println("You turned the corner and didn't see the dragon! Keep going!");
				} else {
					System.out.println("You turned the corner and came face to face with the dragon... and died.");
					isPlayerDead = true;
					
				};break;
		case 5: if (playerInput == F5) {
					System.out.println("You turned the corner and didn't see the dragon!");
					System.out.println("Congratulations, you've made it through the cave safely!. You also found a treasure chest"
							+ " with 1000 gold! Congratulations!!");
					isGameWon = true;
				} else {
					System.out.println("You turned the corner and came face to face with the dragon... and died.");
					isPlayerDead = true;
				};break;
		
		}
		forkNumber +=1;
	}
	/*
	 * pre: none
	 * The player won if this returns true
	 */
	public boolean isGameWon() {
		return(isGameWon);
	}
	/*
	 * pre: none
	 * The player is dead if true
	 */
	public boolean isPlayerDead() {
		return(isPlayerDead);
	}
	
	/*
	 * pre: none
	 * post: resets the path if the player did not complete the quest
	 */
	public void playerReset() {
		isPlayerDead = false;
		forkNumber = 1;
	}
}
