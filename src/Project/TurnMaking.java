package Project;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TurnMaking extends SimulationWindow {
	static int boost = 0;
	static int attackRNG;
	static int healRNG;
	static int fireRNG;
	static int messageRNG = 0;
	static boolean specialAttack = false;
	static int enemyBoost = 0;
	
	public static void process(String turnInput) {
		playerTurn(turnInput);
	}
	
	public static void playerTurn(String turnInput) {
		int playerHP = SimulationWindow.getPlayerHP();
		int enemyHP = SimulationWindow.getEnemyHP();
		int playerMP = SimulationWindow.getPlayerMP();

		
		if (turnInput.equals("Attack")) {
			List<Integer> range = Arrays.asList(40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 60, 61, 62);
		    Random random = new Random();
		    attackRNG = range.get(random.nextInt(range.size())) + boost;
		    boost = 0;
		    SimulationWindow.setEnemyHP(enemyHP - attackRNG);
		}
		
		if (turnInput.equals("Charge")) {
			// charge will give the player more MP 
			// and boost the next attack's DMG.
			// This boost can be stacked if charge
			// is uses repeatedly.
			boost = boost + 15;
			playerMP = playerMP + 15;
			SimulationWindow.setPlayerMP(playerMP);
			if (playerMP > 70) {
				SimulationWindow.setPlayerMP(70);
			}
		}
		
		if (turnInput.equals("Heal")) {
			// heal will cost 25 MP and add 60-65
			// HP to the player.
			List<Integer> range = Arrays.asList(65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75);
		    Random random = new Random();
		    healRNG = range.get(random.nextInt(range.size()));
		    playerHP = playerHP + healRNG;
			SimulationWindow.setPlayerHP(playerHP);
			if (playerHP > 250) {
				SimulationWindow.setPlayerHP(250);
			}
			playerMP = playerMP - 20;
			SimulationWindow.setPlayerMP(playerMP);
			if (playerMP < 0) {
				SimulationWindow.setPlayerMP(0);
			}
		}
		
		if (turnInput.equals("Fire")) {
			// fire will do 70-80 DMG to the
			// enemy at the cost of 30 MP.
			List<Integer> range = Arrays.asList(70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80);
		    Random random = new Random();
		    fireRNG = range.get(random.nextInt(range.size()));
		    SimulationWindow.setEnemyHP(enemyHP - fireRNG);
		    playerMP = playerMP - 30;
		    SimulationWindow.setPlayerMP(playerMP);
			if (playerMP < 0) {
				SimulationWindow.setPlayerMP(0);
			}
		}
		
	}
	
	public static String enemyTurnMessage() {
		String name = enemyGenerator.getName();
		String attack = enemyGenerator.getAttackOne();
		String special = enemyGenerator.getAttackTwo();
		List<Integer> range = Arrays.asList(1, 2, 3);
	    Random random = new Random();
	    messageRNG = range.get(random.nextInt(range.size()));
	    if (messageRNG == 3) {
	    	specialAttack = true;
	    	return name + " used " + special + "!";
	    }
	    specialAttack = false;
	    return name + " used " + attack + "!";
	}
	
	public static int enemyTurn() {
		int DMG = 0;
		if (specialAttack == false) {
			List<Integer> range = Arrays.asList(42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58);
		    Random random = new Random();
		    DMG = range.get(random.nextInt(range.size())) + enemyBoost;
		    playerHP = playerHP - DMG;
		}
		return DMG;
	}
	
	public static void absorb() {
		int curMP = SimulationWindow.getPlayerMP();
		curMP = curMP - 15;
		SimulationWindow.setPlayerMP(curMP);
		if (curMP < 0) {
			SimulationWindow.setPlayerMP(0);
		}
	}
	
	public static String generateSpecial() {
		List<String> range = Arrays.asList("healed", "grew stronger", "stole MP");
	    Random random = new Random();
	    String special = range.get(random.nextInt(range.size()));
	    return special;
	}

	
	public int getBoost() {
		return boost;
	}

	public void setBoost(int boost) {
		TurnMaking.boost = boost;
	}

	public static boolean isSpecialAttack() {
		return specialAttack;
	}

	public static void setSpecialAttack(boolean specialAttack) {
		TurnMaking.specialAttack = specialAttack;
	}

	public static int getAttackRNG() {
		return attackRNG;
	}

	public static void setAttackRNG(int attackRNG) {
		TurnMaking.attackRNG = attackRNG;
	}

	public static int getHealRNG() {
		return healRNG;
	}

	public static void setHealRNG(int healRNG) {
		TurnMaking.healRNG = healRNG;
	}

	public static int getFireRNG() {
		return fireRNG;
	}

	public static void setFireRNG(int fireRNG) {
		TurnMaking.fireRNG = fireRNG;
	}

	public static int getMessageRNG() {
		return messageRNG;
	}

	public static void setMessageRNG(int messageRNG) {
		TurnMaking.messageRNG = messageRNG;
	}
	
	
	// For Assignment2 in SENG210
	// This class will simulate a coin toss, returning
	// a string that's either 'heads' or 'tails'.
	public static String coinToss() {
		List<String> range = Arrays.asList("heads", "tails");
	    Random random = new Random();
	    String result = range.get(random.nextInt(range.size()));
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many tosses?");
		String inpt = scanner.next();
		multiToss(Integer.parseInt(inpt));
		
	}
	
	public static void multiToss(int tosses) {
		for (int i = 0; i < tosses; i++) {
			System.out.println(coinToss());
		}
	}
	
}
