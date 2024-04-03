package org.model.board;

import org.junit.jupiter.api.Test;
import org.model.pieces.Pawn;
import org.model.util.Vector2d;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChessBoardIsOccupiedTest {

    @Test
    void isOccupiedShouldReturnFalseWhenPositionIsEmpty() {
        Board board = new ChessBoard();
        Vector2d position = new Vector2d(3, 4);

        boolean result = board.isOccupied(position);

        assertFalse(result);
    }

    @Test
    void isOccupiedShouldReturnTrueWhenPositionIsOccupied() {
        Board board = new ChessBoard();
        Vector2d position = new Vector2d(3, 4);
        board.addPiece(new Pawn(true), position);

        boolean result = board.isOccupied(position);

        assertTrue(result);
    }

    @Test
    void isOccupiedShouldReturnFalseWhenPositionIsOccupiedThenPieceMoves() {
        Board board = new ChessBoard();
        Vector2d position = new Vector2d(3, 4);
        Pawn pawn = new Pawn(true);
        board.addPiece(pawn, position);
        pawn.move(new Vector2d(3, 5));

        boolean result = board.isOccupied(position);

        assertFalse(result);
    }
}