package org.model.pieces;

import org.model.moves.Moves;

public class Rook extends ChessPiece {

    public Rook(boolean isWhite){
        super(isWhite);
        moves = Moves.getRookMoves();
        canMoveMultipleTiles = true;
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        return o instanceof Rook;
    }
}
