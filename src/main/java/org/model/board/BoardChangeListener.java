package org.model.board;

import org.model.util.Vector2d;
import org.model.pieces.Piece;

public interface BoardChangeListener {
    void boardChanged(Board board, Piece piece, Vector2d move);
}
