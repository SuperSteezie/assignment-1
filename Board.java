import java.util.ArrayList;

public class Board {
	private ArrayList<ArrayList<Tile>> board = new ArrayList<ArrayList<Tile>>();
	private final int LENGTH = 24;
	private final int HEIGHT = 24;

	public Board() {
		for(int i = 0; i < HEIGHT; i++) {
			ArrayList<Tile> row = new ArrayList<Tile>();
			for(int j = 0; j < LENGTH; j++) {
				row.add(new WhiteSquare());
			}
			board.add(row);
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
			board.get(y).set(i, new Wall());
			board.get(y+width-1).set(i, new Wall());
		}
		for(int i = y; i < y+width; i++) {
			board.get(i).set(x, new Wall());
			board.get(i).set(x+length-1, new Wall());
		}
	}

	public void initialiseGreySquares() {
		board.get(5).set(11, new GreySquare());
		board.get(5).set(12, new GreySquare());
		board.get(6).set(11, new GreySquare());
		board.get(6).set(12, new GreySquare());

		board.get(11).set(5, new GreySquare());
		board.get(11).set(6, new GreySquare());
		board.get(12).set(5, new GreySquare());
		board.get(12).set(6, new GreySquare());

		board.get(11).set(17, new GreySquare());
		board.get(11).set(18, new GreySquare());
		board.get(12).set(17, new GreySquare());
		board.get(12).set(18, new GreySquare());

		board.get(17).set(11, new GreySquare());
		board.get(17).set(12, new GreySquare());
		board.get(18).set(11, new GreySquare());
		board.get(18).set(12, new GreySquare());
	}

	public String drawBoard() {
		String b = "";
		for(ArrayList<Tile> row : board) {
			b = b + "\n";
			for(Tile t : row) {
				b = b + t.toString();
			}
		}
		return b;
	}
}
