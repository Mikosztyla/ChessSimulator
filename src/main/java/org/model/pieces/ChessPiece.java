package org.model.pieces;

import org.model.moves.SpecialMove;
import org.model.util.Vector2d;
import org.model.board.Board;

import java.util.ArrayList;
import java.util.List;

public abstract class ChessPiece implements Piece {
    protected Vector2d position;
    protected List<Vector2d> moves;
    protected Board board;
    protected List<SpecialMove> specialMoves;
    protected boolean isWhite;
    protected boolean hasMoved;
    protected boolean canMoveMultipleTiles;
    protected boolean canCaptureOnMove;

    public ChessPiece(boolean isWhite){
        position = new Vector2d(-1, -1);
        moves = new ArrayList<>();
        this.isWhite = isWhite;
        specialMoves = new ArrayList<>();
        hasMoved = false;
        canCaptureOnMove = true;
    }

    // If the move is not valid, this method will do nothing. Otherwise, it will start a procedure to move the piece.
    public void move(Vector2d field) {
        if (!board.isInBoundaries(field)) return;

        //Check for any available special moves.
        for (SpecialMove specialMove : specialMoves){
            if (position.add(specialMove.getMove()).equals(field) &&
            (!specialMove.getHasToTakeOnDestinationField() ||
            specialMove.getHasToTakeOnDestinationField() && board.isOccupied(field) && board.objectAt(field).getIsWhite() != isWhite) &&
            specialMove.getAdditionalConditions().isValidMove(field)){
                if (!specialMove.getCanTakeOnMove() && board.isOccupied(field)) return;
                board.move(this, field);
                return;
            }
        }

        //Do a normal move
        for (Vector2d move : moves){
            int it = canMoveMultipleTiles ? -1 : 1;
            Vector2d currPos = new Vector2d(position.getX(), position.getY()).add(move);
            while (board.isInBoundaries(currPos) && it != 0){
                if (currPos.equals(field)){
                    if (board.isOccupied(currPos) && (isWhite == board.objectAt(currPos).getIsWhite() || !canCaptureOnMove)) break;
                    board.move(this, field);
                    return;
                } else if (board.isOccupied(currPos)) break;
                currPos = currPos.add(move);
                it --;
            }
        }
    }

    public void setPosition(Vector2d position){
        this.position = position;
    }

    public Vector2d getPosition(){
        return position;
    }

    public void setBoard(Board board){
        this.board = board;
    }

    public boolean getIsWhite() {
        return isWhite;
    }

    public boolean getHasMoved(){
        return hasMoved;
    }

    public void pieceMoved(){
        hasMoved = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPiece that = (ChessPiece) o;
        return isWhite == that.isWhite && position.equals(that.position);
    }
}
