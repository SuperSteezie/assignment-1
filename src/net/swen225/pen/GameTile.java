package net.swen225.pen;
public class GameTile implements Tile {
  private boolean iswall;
  private boolean hasplayer;
  private char drawchar;//direction to leave

  public GameTile(boolean iswall, boolean hasplayer, char drawchar){
    this.iswall = iswall;
    this.hasplayer = hasplayer;
    this.drawchar = drawchar;
  }

  public boolean isWall() {
	  return iswall;
  }
  public char charIcon() {
	  if(isWall()) {
		  return '#';
	  }
	  return '_';
  }

}
