package org.model.pieces;

import org.model.moves.Moves;

public class Bishop extends ChessPiece {

    public Bishop(boolean isWhite){
        super(isWhite);
        moves = Moves.getDiagonalMoves();
        canMoveMultipleTiles = true;
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        return o instanceof Bishop;
    }
}
