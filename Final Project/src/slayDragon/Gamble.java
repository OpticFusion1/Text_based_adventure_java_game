package slayDragon;

import java.util.Scanner;


public class Gamble {
	
	public int newAmount;
	public int moneyRisked;
	public int numSelector;
	public int numInput;
	
	/*
	 * pre: none
	 * post: set variables
	 */
	public Gamble() {
		newAmount = 0;
		moneyRisked = 0;
		numSelector = 0;
		numInput = 0;
				
		
	}
	
	/* 
	 * pre: none
	 * post: generates a random integer for gambling
	 */
	public void generateNumber() {
		numSelector = (int)(5*Math.random() +1);
	}
	
	/*
	 * pre: none
	 * post: gets the player input (how much gold to risk) and checks if it has enough gold
	 */
	public void getPlayerInput(int playerGold) {
		Scanner input = new Scanner(System.in);
		System.out.println("How much money do you want to risk (Enter -1 to quit)");
		moneyRisked = input.nextInt();
			if (moneyRisked > playerGold) {
		  		
		  	while (moneyRisked > playerGold){
		  		System.out.println("You do not have that much money, enter another amount");
		  		moneyRisked = input.nextInt();
		  	}
			}		  		
			
		System.out.println("Enter a number guess between 1 and 5");
		numInput = input.nextInt();
		
			  
		 
	}
	
	/*
	 * pre: none
	 * post: checks if the player wins the gamble or not, returns a negative int if player gets wrong and postive otherise
	 */
	public int calculateGuess() {
		if (numInput == numSelector) {
			System.out.println("You guessed correctly!");
			return(moneyRisked);
		} else {
			System.out.println("The number was " + numSelector + ". You guessed wrong!");
			return(moneyRisked*-1);
		}
	}
}
