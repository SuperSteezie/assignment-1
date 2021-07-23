package net.swen225.pen;

import java.util.ArrayList;
import java.util.HashSet;

public class Player implements Movable{
  String character;
  String name;
  Position position;
  HashSet<Evidence> evidence = new HashSet<Evidence>();

  public Player(String character, String name){
    this.character = character;
    this.name = name;
  }

  public void addEvidence(Evidence evidence) {
	  this.evidence.add(evidence);
  }

  public void setPosition(Position p) {
	  this.position = p;
  }
  public Position getPosition() {
	  return this.position;
  }

  public String getName() {
	return this.name;
  }

  //returns the char representing the person. used for drawing
  public Character charIcon() {
	  return name.charAt(0);
  }
}

