package net.swen225.pen;

import net.swen225.pen.board.Movable;
import net.swen225.pen.board.Position;
import net.swen225.pen.board.Space;

public class Player implements Movable{
  String character;
  String name;

  public Player(String character, String name){
    this.character = character;
    this.name = name;

  }

@Override
public Space getSpace() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean moveToSpace(Space space) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public Position getPosition() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean moveToPosition(Position pos) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public String getName() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void setName(String name) {
	// TODO Auto-generated method stub

}
}
