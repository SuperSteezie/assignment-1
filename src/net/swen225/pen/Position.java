package net.swen225.pen;

public class Position {
	public final int x;
	public final int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the position, moved one up.
	 */
	public Position up() {
		return new Position(x, y + 1);
	}

	/**
	 * @return the position, moved one down.
	 */
	public Position down() {
		return new Position(x, y - 1);
	}

	/**
	 * @return the position, moved one to the right.
	 */
	public Position right() {
		return new Position(x + 1, y);
	}

	/**
	 * @return the position, moved one to the left.
	 */
	public Position left() {
		return new Position(x - 1, y);
	}
}
