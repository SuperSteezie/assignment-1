package net.swen225.pen.board;

public interface Space {

	/**
	 * Checks if the given space is free to move into.
	 *
	 * @param pos the position to check.
	 * @return true if the space is empty, false otherwise.
	 */
	boolean isSpaceFree(Position pos);

	/**
	 * Draws a string to the display at the given position.
	 *
	 * @param x the x position.
	 * @param y the y position.
	 * @param ch the string to draw.
	 */
	void drawChar(int x, int y, char ch);
}
