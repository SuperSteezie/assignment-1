public class GameTile implements Tile {
  private boolean iswall;
  private boolean hasplayer;
  private char drawchar;//direction to leave
  
  public Room(boolean iswall, boolean hasplayer, char drawchar){
    this.iswall = iswall;
    this.hasplayer = hasplayer;
    this.drawchar = drawchar;
  }
  
  
}
