package com.assessment.JavaWk2Assessment_DanHayes.utls;

public final class RollingText {

	private RollingText() {}
	
	public static void print(String str, int speedMs) {
		for(char c : str.toCharArray()) {
			System.out.print(c);
			try {
				Thread.sleep(speedMs);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void print(String str) {
		print(str, 30);
	}
	
}
