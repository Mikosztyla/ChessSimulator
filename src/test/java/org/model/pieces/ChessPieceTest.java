package org.model.pieces;

import org.junit.jupiter.api.Test;
import org.model.board.Board;
import org.model.board.ChessBoard;
import org.model.util.Vector2d;

import static org.junit.jupiter.api.Assertions.*;

class ChessPieceTest {

    //Pawns
    @Test
    void whitePawnMovesFrom2_3To2_4() {
        Board board = new ChessBoard();
        Pawn pawn = new Pawn(true);
        board.addPiece(pawn, new Vector2d(2, 3));
        pawn.move(new Vector2d(2, 4));

        Pawn pawnToCheck = new Pawn(true);
        pawnToCheck.setPosition(new Vector2d(2, 4));

        assertEquals(pawn, pawnToCheck);
    }

    @Test
    void whitePawnMovesFrom1_1To1_3() {
        Board board = new ChessBoard();
        Pawn pawn = new Pawn(true);
        board.addPiece(pawn, new Vector2d(1, 1));
        pawn.move(new Vector2d(1, 3));

        Pawn pawnToCheck = new Pawn(true);
        pawnToCheck.setPosition(new Vector2d(1, 3));

        assertEquals(pawn, pawnToCheck);
    }

    @Test
    void whitePawnMovesFrom4_6To4_7() {
        Board board = new ChessBoard();
        Pawn pawn = new Pawn(true);
        board.addPiece(pawn, new Vector2d(4, 6));
        pawn.move(new Vector2d(4, 7));

        Pawn pawnToCheck = new Pawn(true);
        pawnToCheck.setPosition(new Vector2d(4, 7));

        assertEquals(pawn, pawnToCheck);
    }

    @Test
    void whitePawnMovesFrom1_1To1_2AndThenTo1_4ShouldStayAt1_2() {
        Board board = new ChessBoard();
        Pawn pawn = new Pawn(true);
        board.addPiece(pawn, new Vector2d(1, 1));
        pawn.move(new Vector2d(1, 2));
        pawn.move(new Vector2d(1, 4));

        Pawn pawnToCheck = new Pawn(true);
        pawnToCheck.setPosition(new Vector2d(1, 2));

        assertEquals(pawn, pawnToCheck);
    }

    @Test
    void blackPawnMovesFrom6_3To6_2() {
        Board board = new ChessBoard();
        Pawn pawn = new Pawn(false);
        board.addPiece(pawn, new Vector2d(6, 3));
        pawn.move(new Vector2d(6, 2));

        Pawn pawnToCheck = new Pawn(false);
        pawnToCheck.setPosition(new Vector2d(6, 2));

        assertEquals(pawn, pawnToCheck);
    }

    @Test
    void blackPawnMovesFrom3_4To3_3() {
        Board board = new ChessBoard();
        Pawn pawn = new Pawn(false);
        board.addPiece(pawn, new Vector2d(3, 4));
        pawn.move(new Vector2d(3, 3));

        Pawn pawnToCheck = new Pawn(false);
        pawnToCheck.setPosition(new Vector2d(3, 3));

        assertEquals(pawn, pawnToCheck);
    }

    @Test
    void blackPawnMovesFrom6_5To6_4AndThenTo6_2ShouldStayAt6_4() {
        Board board = new ChessBoard();
        Pawn pawn = new Pawn(false);
        board.addPiece(pawn, new Vector2d(6, 5));
        pawn.move(new Vector2d(6, 4));
        pawn.move(new Vector2d(6, 2));

        Pawn pawnToCheck = new Pawn(false);
        pawnToCheck.setPosition(new Vector2d(6, 4));

        assertEquals(pawn, pawnToCheck);
    }

    @Test
    void blackPawnMovesFrom3_4To3_5ShouldNotMove() {
        Board board = new ChessBoard();
        Pawn pawn = new Pawn(false);
        board.addPiece(pawn, new Vector2d(3, 4));
        pawn.move(new Vector2d(3, 5));

        Pawn pawnToCheck = new Pawn(false);
        pawnToCheck.setPosition(new Vector2d(3, 4));

        assertEquals(pawn, pawnToCheck);
    }

    //Knights
    @Test
    void whiteKnightMovesFrom2_3To3_1() {
        Board board = new ChessBoard();
        Knight knight = new Knight(true);
        board.addPiece(knight, new Vector2d(2, 3));
        knight.move(new Vector2d(3, 1));

        Knight knightToCheck = new Knight(true);
        knightToCheck.setPosition(new Vector2d(3, 1));

        assertEquals(knight, knightToCheck);
    }

    @Test
    void whiteKnightMovesFrom4_5To5_7() {
        Board board = new ChessBoard();
        Knight knight = new Knight(true);
        board.addPiece(knight, new Vector2d(4, 5));
        knight.move(new Vector2d(5, 7));

        Knight knightToCheck = new Knight(true);
        knightToCheck.setPosition(new Vector2d(5, 7));

        assertEquals(knight, knightToCheck);
    }

    @Test
    void blackKnightMovesFrom5_2To4_0() {
        Board board = new ChessBoard();
        Knight knight = new Knight(false);
        board.addPiece(knight, new Vector2d(5, 2));
        knight.move(new Vector2d(4, 0));

        Knight knightToCheck = new Knight(false);
        knightToCheck.setPosition(new Vector2d(4, 0));

        assertEquals(knight, knightToCheck);
    }

    @Test
    void blackKnightMovesFrom1_6To0_4() {
        Board board = new ChessBoard();
        Knight knight = new Knight(false);
        board.addPiece(knight, new Vector2d(1, 6));
        knight.move(new Vector2d(0, 4));

        Knight knightToCheck = new Knight(false);
        knightToCheck.setPosition(new Vector2d(0, 4));

        assertEquals(knight, knightToCheck);
    }

    @Test
    void whiteBishopMovesFrom3_3To5_5() {
        Board board = new ChessBoard();
        Bishop bishop = new Bishop(true);
        board.addPiece(bishop, new Vector2d(3, 3));
        bishop.move(new Vector2d(5, 5));

        Bishop bishopToCheck = new Bishop(true);
        bishopToCheck.setPosition(new Vector2d(5, 5));

        assertEquals(bishop, bishopToCheck);
    }

    @Test
    void whiteBishopMovesFrom4_2To2_0() {
        Board board = new ChessBoard();
        Bishop bishop = new Bishop(true);
        board.addPiece(bishop, new Vector2d(4, 2));
        bishop.move(new Vector2d(2, 0));

        Bishop bishopToCheck = new Bishop(true);
        bishopToCheck.setPosition(new Vector2d(2, 0));

        assertEquals(bishop, bishopToCheck);
    }

    @Test
    void blackBishopMovesFrom5_4To6_5() {
        Board board = new ChessBoard();
        Bishop bishop = new Bishop(false);
        board.addPiece(bishop, new Vector2d(5, 4));
        bishop.move(new Vector2d(6, 5));

        Bishop bishopToCheck = new Bishop(false);
        bishopToCheck.setPosition(new Vector2d(6, 5));

        assertEquals(bishop, bishopToCheck);
    }

    @Test
    void blackBishopMovesFrom2_7To0_5() {
        Board board = new ChessBoard();
        Bishop bishop = new Bishop(false);
        board.addPiece(bishop, new Vector2d(2, 7));
        bishop.move(new Vector2d(0, 5));

        Bishop bishopToCheck = new Bishop(false);
        bishopToCheck.setPosition(new Vector2d(0, 5));

        assertEquals(bishop, bishopToCheck);
    }

    @Test
    void whiteQueenMovesFrom3_3To5_5() {
        Board board = new ChessBoard();
        Queen queen = new Queen(true);
        board.addPiece(queen, new Vector2d(3, 3));
        queen.move(new Vector2d(5, 5));

        Queen queenToCheck = new Queen(true);
        queenToCheck.setPosition(new Vector2d(5, 5));

        assertEquals(queen, queenToCheck);
    }

    @Test
    void whiteQueenMovesFrom4_2To2_0() {
        Board board = new ChessBoard();
        Queen queen = new Queen(true);
        board.addPiece(queen, new Vector2d(4, 2));
        queen.move(new Vector2d(2, 0));

        Queen queenToCheck = new Queen(true);
        queenToCheck.setPosition(new Vector2d(2, 0));

        assertEquals(queen, queenToCheck);
    }

    @Test
    void blackQueenMovesFrom5_4To6_5() {
        Board board = new ChessBoard();
        Queen queen = new Queen(false);
        board.addPiece(queen, new Vector2d(5, 4));
        queen.move(new Vector2d(6, 5));

        Queen queenToCheck = new Queen(false);
        queenToCheck.setPosition(new Vector2d(6, 5));

        assertEquals(queen, queenToCheck);
    }

    @Test
    void blackQueenMovesFrom2_7To0_5() {
        Board board = new ChessBoard();
        Queen queen = new Queen(false);
        board.addPiece(queen, new Vector2d(2, 7));
        queen.move(new Vector2d(0, 5));

        Queen queenToCheck = new Queen(false);
        queenToCheck.setPosition(new Vector2d(0, 5));

        assertEquals(queen, queenToCheck);
    }

    @Test
    void whiteKingMovesFrom3_3To4_4() {
        Board board = new ChessBoard();
        King king = new King(true);
        board.addPiece(king, new Vector2d(3, 3));
        king.move(new Vector2d(4, 4));

        King kingToCheck = new King(true);
        kingToCheck.setPosition(new Vector2d(4, 4));

        assertEquals(king, kingToCheck);
    }

    @Test
    void whiteKingMovesFrom4_2To3_1() {
        Board board = new ChessBoard();
        King king = new King(true);
        board.addPiece(king, new Vector2d(4, 2));
        king.move(new Vector2d(3, 1));

        King kingToCheck = new King(true);
        kingToCheck.setPosition(new Vector2d(3, 1));

        assertEquals(king, kingToCheck);
    }

    @Test
    void blackKingMovesFrom5_4To6_5() {
        Board board = new ChessBoard();
        King king = new King(false);
        board.addPiece(king, new Vector2d(5, 4));
        king.move(new Vector2d(6, 5));

        King kingToCheck = new King(false);
        kingToCheck.setPosition(new Vector2d(6, 5));

        assertEquals(king, kingToCheck);
    }

    @Test
    void testWhiteKingSideCastling() {
        Board board = new ChessBoard();
        King king = new King(true);
        Rook rook = new Rook(true);

        board.addPiece(king, new Vector2d(4, 0));
        board.addPiece(rook, new Vector2d(7, 0));

        king.move(new Vector2d(6, 0));

        King kingToCheck = new King(true);
        kingToCheck.setPosition(new Vector2d(6, 0));
        assertEquals(king, kingToCheck);

        Rook rookToCheck = new Rook(true);
        rookToCheck.setPosition(new Vector2d(5, 0));
        assertEquals(rook, rookToCheck);
    }

    @Test
    void testWhiteQueenSideCastling() {
        Board board = new ChessBoard();
        King king = new King(true);
        Rook rook = new Rook(true);

        board.addPiece(king, new Vector2d(4, 0));
        board.addPiece(rook, new Vector2d(0, 0));

        king.move(new Vector2d(2, 0));

        King kingToCheck = new King(true);
        kingToCheck.setPosition(new Vector2d(2, 0));
        assertEquals(king, kingToCheck);

        Rook rookToCheck = new Rook(true);
        rookToCheck.setPosition(new Vector2d(3, 0));
        assertEquals(rook, rookToCheck);
    }

    @Test
    void testBlackKingSideCastling() {
        Board board = new ChessBoard();
        King king = new King(false);
        Rook rook = new Rook(false);

        board.addPiece(king, new Vector2d(4, 7));
        board.addPiece(rook, new Vector2d(7, 7));

        king.move(new Vector2d(6, 7));

        King kingToCheck = new King(false);
        kingToCheck.setPosition(new Vector2d(6, 7));
        assertEquals(king, kingToCheck);

        Rook rookToCheck = new Rook(false);
        rookToCheck.setPosition(new Vector2d(5, 7));
        assertEquals(rook, rookToCheck);
    }

    @Test
    void testBlackQueenSideCastling() {
        Board board = new ChessBoard();
        King king = new King(false);
        Rook rook = new Rook(false);

        board.addPiece(king, new Vector2d(4, 7));
        board.addPiece(rook, new Vector2d(0, 7));

        king.move(new Vector2d(2, 7));

        King kingToCheck = new King(false);
        kingToCheck.setPosition(new Vector2d(2, 7));
        assertEquals(king, kingToCheck);

        Rook rookToCheck = new Rook(false);
        rookToCheck.setPosition(new Vector2d(3, 7));
        assertEquals(rook, rookToCheck);
    }
}