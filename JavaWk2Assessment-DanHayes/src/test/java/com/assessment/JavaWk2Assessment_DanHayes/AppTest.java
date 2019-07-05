package com.assessment.JavaWk2Assessment_DanHayes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.assessment.JavaWk2Assessment_DanHayes.entities.Direction;
import com.assessment.JavaWk2Assessment_DanHayes.entities.Player;
import com.assessment.JavaWk2Assessment_DanHayes.exceptions.InvalidMoveException;

public class AppTest {
	
	@Test
	public void testPlayerMove() {
		Player p = new Player();
		int prevX = p.getX();
		p.move(Direction.WEST);
		assertEquals("moving player west should reduce x by 1", prevX - 1, p.getX());
	}
	
	//THIS TEST CHECKS TO SEE IF AN EXCEPTION IS THROWN (if the correct one is thrown, the test passes)
	@Test(expected = InvalidMoveException.class) 
	public void testPlayerMoveInvalid() {
		new Player().move(Direction.NONE);
	}
	
}
