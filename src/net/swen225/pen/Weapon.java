package net.swen225.pen;

public class Weapon implements Movable{
  String weapon;

  public Weapon(String weapon){
    this.weapon = weapon;
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
