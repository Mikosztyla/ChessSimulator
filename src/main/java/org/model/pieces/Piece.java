package org.model.pieces;

import org.model.util.Vector2d;
import org.model.board.Board;

public interface Piece {
    public void move(Vector2d tile);
    public void setPosition(Vector2d position);
    public Vector2d getPosition();
    public void setBoard(Board board);
    public boolean getIsWhite();
    boolean getHasMoved();
    void pieceMoved();
}
