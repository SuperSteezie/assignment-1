public class Door implements Tile {
  private GameBoard board;
  private Room room;
  private char direction;//direction to leave
  
  public Room(GameBoard board, Room room, char direction){
    this.board = board;
    this.room = room;
    this.direction = direction;
  }
  
  
}
