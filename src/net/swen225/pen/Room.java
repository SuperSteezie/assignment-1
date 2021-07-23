package net.swen225.pen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Room implements Evidence{
  private String roomname;
  private Set<Movable> movables = new HashSet<Movable>();
  public Room(String roomname){
    this.roomname = roomname;
  }


  /**
   * moves a Moveable from this room to another
   *
   * @param the room to move the Moveable to
   * @param the Moveable to be moved
   */
  public void shiftMoveable(Room newroom, Movable moveable){
    for(Movable current : movables){
      if(current.equals(moveable)){
        newroom.addMoveable(current);
        movables.remove(current);
        return;
      }
    }
  }

  public void addMoveable(Movable moveable){
    movables.add(moveable);
  }

  public String getName() {
	  return this.roomname;
  }

  /**
   * returns .charIcon() values of all moveables to be used for drawing
   *
   * @return the list containing char representations of every moveable in the room
   */
  public List<Character> getMovables(){
    List<Character> returner = new ArrayList<Character>();
    for(Movable current : movables){
      returner.add(current.charIcon());
    }
    return returner;
  }
}


