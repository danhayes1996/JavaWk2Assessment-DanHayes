package com.assessment.JavaWk2Assessment_DanHayes.entities;

import java.text.DecimalFormat;

public abstract class Entity {

	private int x, y;

	public String getDistance(Entity other) {
		int distX = Math.abs(this.getX() - other.getX());
		int distY = Math.abs(this.getY() - other.getY());
		return new DecimalFormat("#.##").format(Math.hypot(distX, distY));
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
