package net.swen225.pen;

import java.util.*;

public class Game {
private Board board;
private ArrayList<Evidence> answer = new ArrayList<Evidence>();

private Random r = new Random();


public static void main(String[] args) {
	Game g = new Game();
	g.initialise();
	g.run();
}

private void initialise() {
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

	Position[] temppositions =  {new Position(1,9),new Position(12,1),new Position(9,22),new Position(22,14)};
	Player[] tempplayers = {player1,player2,player3,player4};
	Room[] temprooms = {
	new Room("Haunted house"),
	new Room("Manic manor"),
	new Room("Villia celia"),
	new Room("Calamity castle"),
	new Room("Pearl palce")};

	board = new Board(tempplayers,temppositions,temprooms);

	//weapons
	ArrayList<Evidence> weapons = new ArrayList<Evidence>();
	weapons.add(new Weapon("Broom"));
	weapons.add(new Weapon("Sissor"));
	weapons.add(new Weapon("Knife"));
	weapons.add(new Weapon("Ipad"));
	weapons.add(new Weapon("Shovel"));

	//pick murder items
	answer.add(tempplayers[(int) (Math.random()*3)]);
	answer.add(weapons.get((int) (Math.random()*4)));
	answer.add(temprooms[(int) (Math.random()*4)]);

	//creates deck
	ArrayList<Evidence> deck = new ArrayList<Evidence>();
	deck.addAll(Arrays.asList(temprooms));
	deck.addAll(weapons);
	deck.addAll(Arrays.asList(tempplayers));
	Collections.shuffle(deck);

	//giving players their evidence
	Iterator<Player> iter = board.getPlayers().iterator();
	for(Evidence evidence : deck) {
		if(iter.hasNext()) {
			iter.next().addEvidence(evidence);
		} else {
			iter = board.getPlayers().iterator();
		}
	}
}

private void run() {
	System.out.println(board.toString());
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
