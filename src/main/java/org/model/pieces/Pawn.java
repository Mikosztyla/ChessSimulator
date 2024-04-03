package org.model.pieces;

import org.model.util.Vector2d;
import org.model.moves.ChessMove;
import org.model.moves.SpecialMove;

public class Pawn extends ChessPiece {

    public Pawn(boolean isWhite){
        super(isWhite);
        if (isWhite){
            moves.add(new Vector2d(0, 1));
        } else {
            moves.add(new Vector2d(0, -1));
        }
        canMoveMultipleTiles = false;
        canCaptureOnMove = false;
        //Can move 2 pieces unless it already moved
        SpecialMove move2Tiles = new SpecialMove(new Vector2d(0, 2 * moves.get(0).getY()), false, (Vector2d field) -> !hasMoved);
        move2Tiles.setCanTakeOnMove(false);
        specialMoves.add(move2Tiles);
        //Can capture on diagonal
        specialMoves.add(new SpecialMove(new Vector2d(1, moves.get(0).getY()), true, (Vector2d field) -> true));
        specialMoves.add(new SpecialMove(new Vector2d(-1, moves.get(0).getY()), true, (Vector2d field) -> true));
        //En passant
        setUpEnPassant(new Vector2d(1, moves.get(0).getY()));
        setUpEnPassant(new Vector2d(-1, moves.get(0).getY()));
    }

    @Override
    public String toString() {
        return "P";
    }

    private void setUpEnPassant(Vector2d move){
        SpecialMove enPassant = new SpecialMove(move, false, this::checkEnPassant);
        enPassant.setCanTakeOnMove(false);
        specialMoves.add(enPassant);
    }

    private boolean checkEnPassant(Vector2d field){
        ChessMove lastMove = board.getLastMove();
        if (!(lastMove.getPiece() instanceof Pawn) || !(lastMove.getMove().getX() == 0 && Math.abs(lastMove.getMove().getY()) == 2)) return false;
        Vector2d posToCheck = field.subtract(new Vector2d(0, moves.get(0).getY()));
        if (board.isOccupied(posToCheck) && board.objectAt(posToCheck).getIsWhite() != isWhite &&
                lastMove.getPiece().equals(board.objectAt(posToCheck))){
            board.capturePiece(posToCheck);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        return o instanceof Pawn;
    }
}
