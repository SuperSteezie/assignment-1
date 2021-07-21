package net.swen225.pen.board;

public class Board implements Space {

	private final int LENGTH = 24;
	private final int HEIGHT = 24;
	private final Tile[][] boardData = new Tile[LENGTH][HEIGHT];
	private final StringBuilder output = new StringBuilder();

	public Board() {
		for (int x = 0; x < boardData.length; x++) {
			for (int y = 0; y < boardData[x].length; y++) {
				boardData[x][y] = Tile.EMPTY; //REMOVE AND REPLACE WITH WHITE TILE
			}
		}
		initialiseGreySquares();
		initialiseRooms();
	}
	
	public void initialiseRooms() {
		//HAUNTED HOUSE
		int hauntedX = 2;
		int hauntedY = 2;
		initialiseRoomsHelper(hauntedX, hauntedY, 5, 5);

		//MANIC MANOR
		int manicX = 17;
		int manicY = 2;
		initialiseRoomsHelper(manicX, manicY, 5, 5);

		//CALAMITY CASTLE
		int calamityX = 2;
		int calamityY = 17;
		initialiseRoomsHelper(calamityX, calamityY, 5, 5);

		//PERIL PALACE
		int perilX = 17;
		int perilY = 17;
		initialiseRoomsHelper(perilX, perilY, 5, 5);

		//VILLA CELIA
		int villaX = 9;
		int villaY = 10;
		initialiseRoomsHelper(villaX, villaY, 6, 4);
	}

	public void initialiseRoomsHelper(int x, int y, int length, int width) {
		for(int i = x; i < x+length; i++) {
			boardData[y][i] = new Wall(); //MAKE WALLS
			boardData[y+width-1][i] = new Wall(); //MAKE WALLS
		}
		for(int i = y; i < y+width; i++) {
			boardData[i][x] = new Wall(); //MAKE WALLS
			boardData[i][x+length-1] = new Wall(); //MAKE WALLS
		}
	}

	public void initialiseGreySquares() {
		boardData[5][11] = new GreySquare();
		boardData[5][12] = new GreySquare();
		boardData[6][11] = new GreySquare();
		boardData[6][12] = new GreySquare();
		
		boardData[11][5] = new GreySquare();
		boardData[11][6] = new GreySquare();
		boardData[12][5] = new GreySquare();
		boardData[12][6] = new GreySquare();
		
		boardData[11][17] = new GreySquare();
		boardData[11][18] = new GreySquare();
		boardData[12][17] = new GreySquare();
		boardData[12][18] = new GreySquare();

		
		boardData[17][11] = new GreySquare();
		boardData[17][12] = new GreySquare();
		boardData[18][11] = new GreySquare();
		boardData[18][12] = new GreySquare();
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
	
	public String drawBoard(){
		//RETURN STRING OF BOARD
	}
}
