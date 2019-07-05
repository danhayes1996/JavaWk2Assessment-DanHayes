package com.assessment.JavaWk2Assessment_DanHayes;

import java.util.Scanner;

import com.assessment.JavaWk2Assessment_DanHayes.entities.Direction;
import com.assessment.JavaWk2Assessment_DanHayes.entities.Mob;
import com.assessment.JavaWk2Assessment_DanHayes.entities.Player;
import com.assessment.JavaWk2Assessment_DanHayes.entities.Treasure;
import com.assessment.JavaWk2Assessment_DanHayes.exceptions.InvalidMoveException;
import com.assessment.JavaWk2Assessment_DanHayes.utls.RollingText;

/*TODO future implementations:
	- increase number of mobs based on how much treasure a player has
	- treasure chests can drop useful items to defend against mobs
	- different rarity in treasure chests
*/
public class Terrain {

	private Player player;
	private Treasure treasure;
	private Mob mob;
	
	public Terrain() {
		player = new Player();
		treasure = new Treasure(player);
		mob = new Mob(player);
	}
	
	public void start() {
		String input;
		Scanner scan = new Scanner(System.in);
		
		printIntro();
		
		while(!(input = scan.nextLine().toUpperCase()).equals("QUIT")){
			//move player in indicated direction
			try {
				player.move(getDirection(input));
				mob.move();
			} catch(InvalidMoveException ime) {
				if(input.equals("HELP")) 
					RollingText.print("Commands: \"North\", \"South\", \"East\", \"West\", \"Quit\"\n", 20);
				else 
					RollingText.print("Invalid command, enter \"help\" to view commands\n", 10);
			}
			
			if(hasMobReachedPlayer()) break;
			
			//get distance to treasure
			String dist = player.getDistance(treasure);
			if(dist.equals("0")) collectTreasure();
			else RollingText.print("The dial reads " + dist + "m\n> ");

		}
		scan.close();
		RollingText.print("Game Over! You found " + player.getTreasureCount() + " treasure chest(s)");
	}
	
	private boolean hasMobReachedPlayer() {
		//get distance to mob
		double dToMob = Double.parseDouble(player.getDistance(mob));
		if(dToMob <= 3 && dToMob >= 2) {
			RollingText.print("You see your dial flashing, maybe its warning you of something!\n", 15);
		}
		else if(dToMob < 2 && dToMob != 0) {
			RollingText.print("Your dial starts flashing rapidly, there must be danger nearby!\n", 15);
		}
		else if(dToMob == 0) {
			RollingText.print("Suddenly out of nowhere, a moster jumps towards you\n");
			RollingText.print(". . .\n", 300);
			return true;
		}
		return false;
	}

	private Direction getDirection(String input) {
		switch(input) {
			case "N": 
			case "NORTH": return Direction.NORTH;
			case "E":
			case "EAST" : return Direction.EAST;
			case "S":
			case "SOUTH": return Direction.SOUTH;
			case "W":
			case "WEST" : return Direction.WEST;
			default: return Direction.NONE;
		}
	}
	
	private void collectTreasure() {
		RollingText.print("You see a box sitting on the plain. Its filled with treasure!\n");
		player.foundTreasure();
		treasure.relocate(player);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		RollingText.print("You see the dial change to " + player.getDistance(treasure) + "m. Maybe there's more treasure around!\n> ");
	}
	
	private void printIntro() {
		RollingText.print("Grey foggy clouds float oppressively close to you,\n" + 
				"reflected in the murky grey water which reaches up your shins.\n" +
				"Some black plants barely poke out of the shallow water.\n" +
				"Try \"north\", \"south\", \"east\", or \"west\"\n" + 
				"You notice a small watch-like device in your left hand.\n" +
				"It has hands like a watch, but the hands don't seem to tell time.\n", 10);
		RollingText.print("\nThe dial reads " + player.getDistance(treasure) + "m\n> ");
	}
}
