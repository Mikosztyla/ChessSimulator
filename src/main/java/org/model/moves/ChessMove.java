package org.model.moves;

import org.model.util.Vector2d;
import org.model.pieces.Piece;

public class ChessMove {
    private Piece piece;
    private Vector2d move;
    private boolean hasTaken;

    public ChessMove(Piece piece, Vector2d move, boolean hasTaken) {
        this.piece = piece;
        this.move = move;
        this.hasTaken = hasTaken;
    }

    public Piece getPiece() {
        return piece;
    }

    public Vector2d getMove() {
        return move;
    }

    public boolean getHasTaken() {
        return hasTaken;
    }
}
