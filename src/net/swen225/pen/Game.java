package net.swen225.pen;

import java.util.Random;

import net.swen225.pen.board.Room;

import java.util.*;

public class Game {
//public Board board = new Board();
private ArrayList<Player> players = new ArrayList<Player>();

private ArrayList<Evidence> answer = new ArrayList<Evidence>();

private Random r = new Random();


public static void main(String[] args) {
	Game g = new Game();
	g.run();
}

private void run() {
	//input names of players
	Scanner sc= new Scanner(System.in);
	System.out.print("Enter player 1's name: ");
	Player player1 = new Player(sc.next(), "Bert");
	System.out.print("Enter player 2's name: ");
	Player player2 = new Player(sc.next(), "Lucilla");
	System.out.print("Enter player 3's name: ");
	Player player3 = new Player(sc.next(), "Maline");

	//or blank for no player
	System.out.print("Enter player 4's name: ");
	Player player4 = new Player(sc.next(), "Percy");

	players.add(player1);
	players.add(player2);
	players.add(player3);
	players.add(player4);

	//people
	ArrayList<Player> players2 = (ArrayList) players.clone();

	//weapons
	ArrayList<Evidence> weapons = new ArrayList<Evidence>();
	weapons.add(new Weapon("Broom"));
	weapons.add(new Weapon("Sissor"));
	weapons.add(new Weapon("Knife"));
	weapons.add(new Weapon("Ipad"));
	weapons.add(new Weapon("Shovel"));

	//rooms
	ArrayList<Evidence> rooms = new ArrayList<Evidence>();
	rooms.add(new Room("Haunted house"));
	rooms.add(new Room("Manic manor"));
	rooms.add(new Room("Villia celia"));
	rooms.add(new Room("Calamity castle"));
	rooms.add(new Room("Pearl palce"));

	//shuffle
	Collections.shuffle(players2);
	Collections.shuffle(weapons);
	Collections.shuffle(rooms);

	//pick murder items
	answer.add(players2.remove(0));
	answer.add(weapons.remove(0));
	answer.add(rooms.remove(0));

	//deals the rest of the deck
	ArrayList<Evidence> deck = new ArrayList<Evidence>();
	deck.addAll(rooms);
	deck.addAll(weapons);
	deck.addAll(players);
	Collections.shuffle(deck);

	players.get(0).evidence= new ArrayList<Evidence>(deck.subList(0, 3));
	players.get(1).evidence= new ArrayList<Evidence>(deck.subList(4, 6));
	players.get(2).evidence= new ArrayList<Evidence>(deck.subList(7, 9));
	players.get(3).evidence= new ArrayList<Evidence>(deck.subList(10, 12));

	//System.out.println(Board.drawBoard());

	int count= r.nextInt(3);
	turn(players.get(count));
/*	while(true){
		turn(players.get(count));
		count++;
		if(count==4) count=0;
}*/

}
private void turn(Player player){
	//clear txt (plz help)
	//System.out.print(Board.drawBoard());
	System.out.println("-----------------------");
	System.out.println("Press enter to roll dice");

//press enter to roll (random 1-12)
	int moves = r.nextInt(5) + r.nextInt(5) + 2;
//read inputs to move
}
private void move(Player player, int moves){
//"input movement"
//if on door tile can make guess
//if W isValid(board[player.x, player.y+1])
//board[player.x,player.y] = blank tile
//board[player.x, player.y+1] = player
//move(player, moves-1)
//else "invaild move, try agian"
//move(player, moves)
}
private void guess(){
//"input player"
//"input weapon"
// move player and weapon to room
}


}
