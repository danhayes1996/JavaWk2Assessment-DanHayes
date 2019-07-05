package com.assessment.JavaWk2Assessment_DanHayes.entities;

import com.assessment.JavaWk2Assessment_DanHayes.exceptions.InvalidMoveException;

//player always starts out at (0, 0) and everything else spawns around its
public class Player extends Entity {

	private static final int STEP_DISTANCE = 1;
	
	private int treasureCount;
	
	public void move(Direction direction) throws InvalidMoveException {
		switch(direction) {
			case NORTH: 
				setY(getY() - STEP_DISTANCE);
				break;
			case SOUTH:
				setY(getY() + STEP_DISTANCE);
				break;
			case WEST:
				setX(getX() - STEP_DISTANCE);
				break;
			case EAST:
				setX(getX() + STEP_DISTANCE);
				break;
			default:
				throw new InvalidMoveException();
		}
	}
	
	public void foundTreasure() {
		treasureCount++;
	}
	
	public int getTreasureCount() {
		return treasureCount;
	}
	
}
