package org.model.pieces;

import org.model.moves.Moves;

public class Queen extends ChessPiece {

    public Queen(boolean isWhite){
        super(isWhite);
        moves = Moves.getQueenMoves();
        canMoveMultipleTiles = true;
    }

    @Override
    public String toString() {
        return "Q";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        return o instanceof Queen;
    }
}
