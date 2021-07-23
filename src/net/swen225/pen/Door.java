package net.swen225.pen;

import java.util.HashSet;
import java.util.Set;

public class Door implements Tile {
  private Board board;
  private Position position; //position on the board
  private Room room;
  private char direction;//direction to leave: 'l' for left, 'u' for up etc

  public Door(Board board, Room room, char direction,Position position){
    this.board = board;
    this.room = room;
    this.direction = direction;
    this.position = position;
  }

  public boolean isWall() {
	  return false;
  }

  public char charIcon() {
	  return '/';
  }


}
