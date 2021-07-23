package net.swen225.pen;

public class Weapon implements Movable{
  String weapon;

  public Weapon(String weapon){
    this.weapon = weapon;
  }

  public Character charIcon() {
	  return weapon.charAt(0);
  }
  public String getName() {
	  return weapon;
  }
}
