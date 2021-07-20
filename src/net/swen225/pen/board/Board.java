package net.swen225.pen.board;

public class Board implements Space {

	private final Tile[][] boardData = new Tile[24][24];
	private final StringBuilder output = new StringBuilder();

	public Board() {
		for (int x = 0; x < boardData.length; x++) {
			for (int y = 0; y < boardData[x].length; y++) {
				boardData[x][y] = Tile.EMPTY;
			}
		}
	}

	@Override
	public boolean isSpaceFree(Position pos) {
		return getTile(pos).isPassable();
	}

	@Override
	public void drawChar(int x, int y, char st) {

	}

	private Tile getTile(Position pos) {
		return boardData[pos.x][pos.y];
	}
}
