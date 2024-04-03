package org.model.pieces;

import org.model.moves.Moves;
import org.model.moves.SpecialMove;
import org.model.util.Vector2d;

public class King extends ChessPiece {

    public King(boolean isWhite){
        super(isWhite);
        moves = Moves.getQueenMoves();
        canMoveMultipleTiles = false;
        //Castle King side
        setUpCastling(1, 3);
        //Castle Queen side
        setUpCastling(-1, 4);
    }

    private void setUpCastling(int multiplayer, int rookSpace){
        SpecialMove castle = new SpecialMove(new Vector2d(multiplayer * 2, 0), false, (Vector2d field) -> {
            if (hasMoved) return false;
            if (board.isOccupied(position.add(new Vector2d(multiplayer, 0))) || board.isOccupied(position.add(new Vector2d(multiplayer * 2, 0)))) return false;
            if (rookSpace == 4 && board.isOccupied(position.add(new Vector2d(multiplayer * 3, 0)))) return false; //additional case for long castle
            Vector2d posToCheck = position.add(new Vector2d(multiplayer * rookSpace, 0));
            if (board.isOccupied(posToCheck) && board.objectAt(posToCheck) instanceof Rook && !board.objectAt(posToCheck).getHasMoved()) {
                board.castle(board.objectAt(posToCheck), field.add(new Vector2d(-multiplayer, 0)));
                return true;
            }
            return false;
        });
        castle.setCanTakeOnMove(false);
        specialMoves.add(castle);
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        return o instanceof King;
    }
}
