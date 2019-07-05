package com.assessment.JavaWk2Assessment_DanHayes.entities;

import java.util.Random;

public class Mob extends Entity {

	private static final double MAX_DISTANCE_FROM_PLAYER = 10D;
	
	private Player player;
	private Random r;
	
	public Mob(Player player) {
		this.player = player;
		this.r = new Random();
		
		placeInRangeOfPlayer(15);
	}
	
	//mob can move diagonally
	public void move() {
		if(Double.parseDouble(getDistance(player)) >= MAX_DISTANCE_FROM_PLAYER) {
			//teleport mob closer to player
			placeInRangeOfPlayer(10);
		} else {
			//move randomly
			setY(getY() + r.nextInt(3) - 1);
			setY(getY() + r.nextInt(3) - 1);
		}
	}
	
	private void placeInRangeOfPlayer(int maxDistance) {
		//place mob anywhere in a MAX_DISTANCE_FROM_PLAYER radius
		setX(player.getX() + r.nextInt(maxDistance) - (maxDistance / 2));
		setY(player.getY() + r.nextInt(maxDistance) - (maxDistance / 2));
	}
	
}
