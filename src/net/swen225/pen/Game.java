package net.swen225.pen;
import java.util.*;
import java.io.IOException;

public class Game {
private Board board;
private ArrayList<Evidence> answer = new ArrayList<Evidence>();
private ArrayList<Evidence> weapons = new ArrayList<Evidence>();
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
	for(Player x : board.getPlayers()) {
		turn(x);
	}

}

private void turn(Player player){
	Scanner sc= new Scanner(System.in);
	draw("Press enter to roll dice");
	sc.next();
//press enter to roll (random 1-12)
	int moves = r.nextInt(5) + r.nextInt(5) + 2;
	for(int i=0; i<moves; i++) {
		draw(
				"Enter W to move up"+"\n"+
				"Enter A to move left"+"\n"+
				"Enter S to move down"+"\n"+
				"Enter D to move right"+"\n"+"\n"+
				"You have "+(moves-i)+" moves remaining" 
				);
		move(player, sc.next());
		
	}
}
private void move(Player player, String move){
	if(move.toLowerCase().equals("w")) {
		if(board.isSpaceFree(player.position.up(), player)) player.setPosition(player.position.up());
	}
	else if(move.toLowerCase().equals("a")) {
		if(board.isSpaceFree(player.position.left(), player)) player.setPosition(player.position.left());
	}
	else if(move.toLowerCase().equals("s")) {
		if(board.isSpaceFree(player.position.down(), player)) player.setPosition(player.position.down());
	}
	else if(move.toLowerCase().equals("d")) {
		if(board.isSpaceFree(player.position.right(), player)) player.setPosition(player.position.right());
	}
	else {
		Scanner sc= new Scanner(System.in);
		draw(
			"Enter W to move up"+"\n"+
			"Enter A to move left"+"\n"+
			"Enter S to move down"+"\n"+
			"Enter D to move right"+"\n"+"\n"+
			"That was an invalid move" 
			);
	move(player, sc.next());
	}
}
private void guess(Player player){
	Scanner sc= new Scanner(System.in);
	
	
	System.out.println("What character do you want to guess? ");
	String character = sc.next();
	while(!board.getPlayers().contains(character)) {
		System.out.println("Sorry that is not a character please try again");
		character = sc.next();
	}
	
	System.out.println("What weapon do you want to guess? ");
	String weapon = sc.next();
	while(!weapons.contains(weapon)) {
		System.out.println("Sorry that is not a weapon please try again");
		weapon = sc.next();
	}
	
	//String room = player.getRoom;
	//if(room is middle room)
	//ask for room and check to see if its the right guess, if wrong eliminate them 
	
	
	//character.setRoom(room);
	//weapon.setRoom(room);
	//Check other players decks
}

private void draw(String txt){
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println(board.toString());
	System.out.println();
	System.out.println();
	System.out.println(txt);
	
}


}
