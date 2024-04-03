package org.model.pieces;

import org.model.moves.Moves;

public class Knight extends ChessPiece {

    public Knight(boolean isWhite){
        super(isWhite);
        moves = Moves.getKnightMoves();
        canMoveMultipleTiles = false;
    }

    @Override
    public String toString() {
        return "N";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        return o instanceof Knight;
    }
}
