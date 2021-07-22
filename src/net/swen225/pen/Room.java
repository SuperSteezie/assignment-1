package net.swen225.pen;

public class Room implements Evidence{
  private String roomname;
  private Set<Moveable> moveables = new HashSet<Moveable>();
  public Room(String roomname){
    this.roomname = roomname;
  }


  /**
   * moves a Moveable from this room to another
   *
   * @param the room to move the Moveable to
   * @param the Moveable to be moved
   */
  public void shiftMoveable(Room newroom, Moveable moveable){
    for(Moveable current : moveables){
      if(current.equals(moveable)){
        newroom.addMoveable(current);
        moveables.remove(current);
        return;
      }
    }
  }

  public void addMoveable(Moveable moveable){
    moveables.add(moveables);
  }


  /**
   * returns .charIcon() values of all moveables to be used for drawing
   *
   * @return the list containing char representations of every moveable in the room
   */
  public List<char> getMoveables(){
    List<char> returner = new ArrayList<char>();
    for(Moveable current : moveables){
      returner.add(current.charIcon());
    }
    return returner;
  }
}


