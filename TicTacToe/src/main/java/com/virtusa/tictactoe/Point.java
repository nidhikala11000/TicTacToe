package com.virtusa.tictactoe;

/**
 * used to represent a position
 */

public class Point {
	public int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "[" + (x + 1) + "," + (y + 1) + "]"; // to display the content of point object
	}

}
