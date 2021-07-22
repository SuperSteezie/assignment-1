package net.swen225.pen;

import java.util.HashSet;
import java.util.Set;

public class Door implements Tile {
  private Board board;
  private Room room;
  private char direction;//direction to leave

  public Door(Board board, Room room, char direction){
    this.board = board;
    this.room = room;
    this.direction = direction;
  }

  public boolean isWall() {
	  return false;
  }


}
