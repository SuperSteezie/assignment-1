package net.swen225.pen;

import java.util.ArrayList;
import java.util.HashSet;

public class Player implements Movable{
  String character;
  String name;
  HashSet<Evidence> evidence = new HashSet<Evidence>();

  public Player(String character, String name){
    this.character = character;
    this.name = name;
  }

  public void addEvidence(Evidence evidence) {
	  this.evidence.add(evidence);
  }

  public String getName() {
	// TODO Auto-generated method stub
	return null;
  }
}

