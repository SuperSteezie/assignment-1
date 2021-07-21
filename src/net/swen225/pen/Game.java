package net.swen225.pen;

import java.util.Random;
import java.util.*;

public class Game {
public board = new Board();
public ArrayList<Player> players = new ArrayList<Player>();

public ArrayList<Card> answer = new ArrayList<Card>();
	
private Random r = new Random();

public static void main(String[] args) {
	//input names of players
	Scanner sc= new Scanner(System.in);
	System.out.print("Enter player 1's name: ");
	player1 = new player(sc.next(), "Bert");
	System.out.print("Enter player 2's name: ");
	player2 = new player(sc.next(), "Bert");
	System.out.print("Enter player 3's name: ");
	player3 = new player(sc.next(), "Bert");
	
	//or blank for no player
	System.out.print("Enter player 4's name: ");
	player4 = new player(sc.next(), "Bert");
	
	players.add(player1);
	players.add(player2);
	players.add(player3);
	players.add(player4);
	
	//people
	players2 = (ArrayList) players.clone();
	
	//weapons
	ArrayList<Evidence> weapons = new ArrayList<Evidence>();
	weapons.add(new weapon("Broom"));
	weapons.add(new weapon("Sissor"));
	weapons.add(new weapon("Knife"));
	weapons.add(new weapon("Ipad"));
	weapons.add(new weapon("Shovel"));
	
	//rooms
	ArrayList<Evidence> rooms = new ArrayList<Evidence>();
	rooms.add(new room("Haunted house"));
	rooms.add(new room("Manic manor"));
	rooms.add(new room("Villia celia"));
	rooms.add(new room("Calamity castle"));
	rooms.add(new room("Pearl palce"));
	
	//shuffle
	Collections.shuffle(player2);
	Collections.shuffle(weapons);
	Collections.shuffle(rooms);
	
	//pick murder items
	answer.add(player2.remove(0));
	answer.add(weapons.remove(0));
	answer.add(rooms.remove(0));
	
	//deals the rest of the deck
	ArrayList<Evidence> deck = new ArrayList<Evidence>();
	deck.addAll(rooms);
	deck.addAll(weapons);
	deck.addAll(players);
	Collections.shuffle(deck);
	
	players[0].evidence=deck.sublist(0,2);
	players[1].evidence=deck.sublist(3,5);
	players[2].evidence=deck.sublist(6,8);
	players[3].evidence=deck.sublist(9,11);
	
	System.out.println(deck.size()); //should be 0

	
	System.out.println(Board.drawBoard());
	
	count= r.nextInt(3);
	while(true){
		turn(players[counter]);
		counter++;
		if(counter==4) counter=0;
}
}
private void turn(player){
//press enter to roll (random 1-12)
	int moves = r.nextInt(5) + r.nextInt(5) + 2; 
//read inputs to move
}
private void move(player, moves){
//"input movement"
//if on door tile can make guess
//if W isValid(board[player.x, player.y+1])
//board[player.x,player.y] = blank tile
//board[player.x, player.y+1] = player
//move(player, moves-1)
//else "invaild move, try agian"
//move(player, moves)
}
private guess(){
//"input player"
//"input weapon"
// move player and weapon to room
}
}
