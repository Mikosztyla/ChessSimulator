package org.model.board;

import org.model.moves.ChessMove;
import org.model.pieces.Piece;
import org.model.util.Vector2d;

import java.util.Map;

public interface Board {
    public boolean isOccupied(Vector2d position);
    public Piece objectAt(Vector2d position);
    public boolean isInBoundaries(Vector2d position);
    public void addPiece(Piece piece, Vector2d position);
    public void move(Piece piece, Vector2d position);
    public ChessMove getLastMove();
    Vector2d getBoundaries();
    void subscribeObserver(BoardChangeListener listener);
    void unSubscribeObserver(BoardChangeListener listener);
    void resetBoard();
    Map<Vector2d, Piece> getElements();
    void capturePiece(Vector2d position);
    void castle(Piece piece, Vector2d destination);
}
