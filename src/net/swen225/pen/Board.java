package net.swen225.pen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board{

	private HashSet<Player> players = new HashSet<Player>();
	private HashMap<Position, Door> doors = new HashMap<Position, Door>();
	private HashMap<String,Room> rooms = new HashMap<String,Room>();

	private final int LENGTH = 24;
	private final int HEIGHT = 24;
	private final Tile[][] boardData = new Tile[LENGTH][HEIGHT];

	public Board(Player[] players, Position[] positions,Room[] rooms) {
		for(int i = 0;i<4;i++) {
			players[i].setPosition(positions[i]);
			this.players.add(players[i]);
		}
		for(int i = 0;i<4;i++) {
			this.rooms.put(rooms[i].getName(),rooms[i]);
		}
		generateBoard();
	}

	public Set<Player> getPlayers(){
		return players;
	}
	public Set<Room> getRooms(){
		return (Set<Room>) rooms.values();
	}

	public void generateBoard() {
		//adding while tiles
		for (int x = 0; x < boardData.length; x++) {
			for (int y = 0; y < boardData[x].length; y++) {
				boardData[x][y] = new GameTile(false,false,'_');
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
		//haunted house
		doors.put(new Position(7,2),new Door(this,rooms.get("Haunted House"),'r',new Position(7,2)));
		doors.put(new Position(5,6),new Door(this,rooms.get("Haunted House"),'d',new Position(5,6)));
		//manic manor
		doors.put(new Position(16,6),new Door(this,rooms.get("Manic Manor"),'l',new Position(16,6)));
		doors.put(new Position(20,7),new Door(this,rooms.get("Manic Manor"),'d',new Position(20,7)));
		//calamity castle
		doors.put(new Position(16,3),new Door(this,rooms.get("Calamity Castle"),'u',new Position(16,3)));
		doors.put(new Position(18,7),new Door(this,rooms.get("Calamity Castle"),'r',new Position(18,7)));
		//peril palace
		doors.put(new Position(16,20),new Door(this,rooms.get("Peril Palace"),'l',new Position(16,20)));
		doors.put(new Position(18,16),new Door(this,rooms.get("Peril Palace"),'u',new Position(18,16)));
		//villa celia
		doors.put(new Position(12,9),new Door(this,rooms.get("Villa Celia"),'u',new Position(12,9)));
		doors.put(new Position(11,14),new Door(this,rooms.get("Villa Celia"),'d',new Position(11,14)));
		doors.put(new Position(8,12),new Door(this,rooms.get("Villa Celia"),'l',new Position(8,12)));
		doors.put(new Position(15,11),new Door(this,rooms.get("Villa Celia"),'r',new Position(15,11)));
	}


	public boolean isSpaceFree(Position pos,Player current) {
		for(Player player : players) {
			if(player.getPosition() == current.getPosition() && current !=player) {
				return false;
			}
		}
		return boardData[pos.x][pos.y].isWall();
	}

	private Tile getTile(Position pos) {
		return boardData[pos.x][pos.y];
	}

	public String toString(){
		StringBuilder builder = new StringBuilder();
		for(int i = 0;i < HEIGHT;i++) {
			builder.append('|');
			for(int j = 0;j<LENGTH;j++) {
				builder.append(boardData[i][j].charIcon());
				builder.append('|');
			}
			builder.append('\n');
		}
		for(Player player : players) {
			Position temp = player.getPosition();
			if(temp!=null) {
				int x = temp.x*2+1;
				int y = temp.y*LENGTH*2;
				builder.setCharAt(x+y,player.charIcon());
			}
		}

		for(Position door : (Set<Position>) doors.keySet()) {
				int x = door.x*2+1;
				int y = door.y*LENGTH*2;
				builder.setCharAt(x+y,doors.get(door).charIcon());
		}

		return builder.toString();
	}
}
