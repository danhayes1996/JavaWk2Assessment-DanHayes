package com.assessment.JavaWk2Assessment_DanHayes.entities;

import java.util.Random;

public class Treasure extends Entity {

	private static final int MAX_DISTANCE_FROM_PLAYER = 10;
	
	public Treasure(Player player) {
		relocate(player);
	}
	
	public void relocate(Player player) {
		Random r = new Random();
		//place treasure anywhere in a MAX_DISTANCE_FROM_PLAYER radius
		setX(player.getX() + r.nextInt(MAX_DISTANCE_FROM_PLAYER) - (MAX_DISTANCE_FROM_PLAYER / 2));
		setY(player.getY() + r.nextInt(MAX_DISTANCE_FROM_PLAYER) - (MAX_DISTANCE_FROM_PLAYER / 2));
		
		//make sure the relocation isn't on top of the player
		if(player.getX() == getX() && player.getY() == getY()) 
			relocate(player);
	}
}
