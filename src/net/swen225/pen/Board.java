package net.swen225.pen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board{

	private HashMap<Player,Position> players = new HashMap<Player,Position>();
	private HashMap<Door, Position> doors = new HashMap<Door, Position>();
	private HashSet<Room> rooms = new HashSet<Room>();

	private final int LENGTH = 24;
	private final int HEIGHT = 24;
	private final Tile[][] boardData = new Tile[LENGTH][HEIGHT];
	private final StringBuilder output = new StringBuilder();

	public Board(Player[] players, Position[] positions,Room[] rooms) {
		for(int i = 0;i<3;i++) {
			this.players.put(players[i],positions[i]);
		}
		for(int i = 0;i<4;i++) {
			this.rooms.add(rooms[i]);
		}
		generateBoard();
	}

	public Set<Player> getPlayers(){
		return players.keySet();
	}
	public Set<Room> getRooms(){
		return rooms;
	}

	public void generateBoard() {
		for (int x = 0; x < boardData.length; x++) {
			for (int y = 0; y < boardData[x].length; y++) {
				boardData[x][y] = new GameTile(false,false,'_'); //REMOVE AND REPLACE WITH WHITE TILE
			}
		}
		initialisePillars();
		initialiseRooms();
		initialiseDoors();
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

	public void initialiseRoomsHelper(int x, int y, int length, int width) {//makes walls surrounding a room
		for(int i = x; i < x+length; i++) {
			boardData[y][i] = new GameTile(true,false,'x'); //MAKE WALLS
			boardData[y+width-1][i] = new GameTile(true,false,'x'); //MAKE WALLS
		}
		for(int i = y; i < y+width; i++) {
			boardData[i][x] = new GameTile(true,false,'x'); //MAKE WALLS
			boardData[i][x+length-1] = new GameTile(true,false,'x'); //MAKE WALLS
		}
	}

	public void initialisePillars() {//makes the random pillars
		boardData[5][11] = new GameTile(true,false,'X');
		boardData[5][12] = new GameTile(true,false,'X');
		boardData[6][11] = new GameTile(true,false,'X');
		boardData[6][12] = new GameTile(true,false,'X');

		boardData[11][5] = new GameTile(true,false,'X');
		boardData[11][6] = new GameTile(true,false,'X');
		boardData[12][5] = new GameTile(true,false,'X');
		boardData[12][6] = new GameTile(true,false,'X');

		boardData[11][17] = new GameTile(true,false,'X');
		boardData[11][18] = new GameTile(true,false,'X');
		boardData[12][17] = new GameTile(true,false,'X');
		boardData[12][18] = new GameTile(true,false,'X');

		boardData[17][11] = new GameTile(true,false,'X');
		boardData[17][12] = new GameTile(true,false,'X');
		boardData[18][11] = new GameTile(true,false,'X');
		boardData[18][12] = new GameTile(true,false,'X');
	}

	public void initialiseDoors() {

	}


	public boolean isSpaceFree(Position pos) {
		return getTile(pos).isPassable();
	}

	public void drawChar(int x, int y, char st) {

	}

	private Tile getTile(Position pos) {
		return boardData[pos.x][pos.y];
	}

	public String toString(){
		//RETURN STRING OF BOARD
	}
}
