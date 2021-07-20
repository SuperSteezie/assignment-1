package net.swen225.pen.board;

public interface Movable {

	Space getSpace();

	/**
	 * Tries to move the object to the given space.
	 *
	 * @param space the space to move to
	 * @return if the move was successful
	 */
	boolean moveToSpace(Space space);

	Position getPosition();

	/**
	 * Tries to move the object to the given position.
	 *
	 * @param pos the position to move to
	 * @return if the move was successful
	 */
	boolean moveToPosition(Position pos);
}
