package net.swen225.pen.board;

public interface Tile {

	Tile EMPTY = new Tile() {
		@Override
		public boolean isPassable() {
			return true;
		}

		@Override
		public void draw(Space space, int x, int y) {
			space.drawChar(x, y, ' ');
		}
	};

	Tile BLOCKED = new Tile() {
		@Override
		public boolean isPassable() {
			return false;
		}

		@Override
		public void draw(Space space, int x, int y) {
			space.drawChar(x, y, 'X');
		}
	};

	/**
	 * Checks if the tile can be moved over.
	 *
	 * @return true if the tile can be walked on, false otherwise.
	 */
	boolean isPassable();

	/**
	 * Draws the tile at the position to the given space.
	 *
	 * @param space the space to draw to.
	 * @param x     the x pos.
	 * @param y     the y pos.
	 */
	void draw(Space space, int x, int y);
}