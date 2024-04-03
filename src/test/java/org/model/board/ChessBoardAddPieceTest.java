package org.model.board;

import org.junit.jupiter.api.Test;
import org.model.pieces.*;
import org.model.util.Vector2d;

import static org.junit.jupiter.api.Assertions.*;

class ChessBoardAddPieceTest {

    @Test
    void addWhitePawnAt0_0() {
        Board board = new ChessBoard();
        Pawn pawn = new Pawn(true);
        board.addPiece(pawn, new Vector2d(0, 0));

        Pawn pawnToCheck = new Pawn(true);
        pawnToCheck.setPosition(new Vector2d(0, 0));
        assertEquals(pawn, pawnToCheck);
    }

    @Test
    void addWhitePawnAt7_7() {
        Board board = new ChessBoard();
        Pawn pawn = new Pawn(true);
        board.addPiece(pawn, new Vector2d(7, 7));

        Pawn pawnToCheck = new Pawn(true);
        pawnToCheck.setPosition(new Vector2d(7, 7));
        assertEquals(pawn, pawnToCheck);
    }

    @Test
    void addWhiteRookAt0_0() {
        Board board = new ChessBoard();
        Rook rook = new Rook(true);
        board.addPiece(rook, new Vector2d(0, 0));

        Rook rookToCheck = new Rook(true);
        rookToCheck.setPosition(new Vector2d(0, 0));
        assertEquals(rook, rookToCheck);
    }

    @Test
    void addBlackRookAt7_7() {
        Board board = new ChessBoard();
        Rook rook = new Rook(false);
        board.addPiece(rook, new Vector2d(7, 7));

        Rook rookToCheck = new Rook(false);
        rookToCheck.setPosition(new Vector2d(7, 7));
        assertEquals(rook, rookToCheck);
    }

    @Test
    void addWhiteKnightAt0_0() {
        Board board = new ChessBoard();
        Knight knight = new Knight(true);
        board.addPiece(knight, new Vector2d(0, 0));

        Knight knightToCheck = new Knight(true);
        knightToCheck.setPosition(new Vector2d(0, 0));
        assertEquals(knight, knightToCheck);
    }

    @Test
    void addBlackKnightAt7_7() {
        Board board = new ChessBoard();
        Knight knight = new Knight(false);
        board.addPiece(knight, new Vector2d(7, 7));

        Knight knightToCheck = new Knight(false);
        knightToCheck.setPosition(new Vector2d(7, 7));
        assertEquals(knight, knightToCheck);
    }

    @Test
    void addWhiteBishopAt0_0() {
        Board board = new ChessBoard();
        Bishop bishop = new Bishop(true);
        board.addPiece(bishop, new Vector2d(0, 0));

        Bishop bishopToCheck = new Bishop(true);
        bishopToCheck.setPosition(new Vector2d(0, 0));
        assertEquals(bishop, bishopToCheck);
    }

    @Test
    void addBlackBishopAt7_7() {
        Board board = new ChessBoard();
        Bishop bishop = new Bishop(false);
        board.addPiece(bishop, new Vector2d(7, 7));

        Bishop bishopToCheck = new Bishop(false);
        bishopToCheck.setPosition(new Vector2d(7, 7));
        assertEquals(bishop, bishopToCheck);
    }

    @Test
    void addWhiteQueenAt0_0() {
        Board board = new ChessBoard();
        Queen queen = new Queen(true);
        board.addPiece(queen, new Vector2d(0, 0));

        Queen queenToCheck = new Queen(true);
        queenToCheck.setPosition(new Vector2d(0, 0));
        assertEquals(queen, queenToCheck);
    }

    @Test
    void addBlackQueenAt7_7() {
        Board board = new ChessBoard();
        Queen queen = new Queen(false);
        board.addPiece(queen, new Vector2d(7, 7));

        Queen queenToCheck = new Queen(false);
        queenToCheck.setPosition(new Vector2d(7, 7));
        assertEquals(queen, queenToCheck);
    }

    @Test
    void addWhiteKingAt0_0() {
        Board board = new ChessBoard();
        King king = new King(true);
        board.addPiece(king, new Vector2d(0, 0));

        King kingToCheck = new King(true);
        kingToCheck.setPosition(new Vector2d(0, 0));
        assertEquals(king, kingToCheck);
    }

    @Test
    void addBlackKingAt7_7() {
        Board board = new ChessBoard();
        King king = new King(false);
        board.addPiece(king, new Vector2d(7, 7));

        King kingToCheck = new King(false);
        kingToCheck.setPosition(new Vector2d(7, 7));
        assertEquals(king, kingToCheck);
    }

    @Test
    void addBlackPawnAt3_5() {
        Board board = new ChessBoard();
        Pawn pawn = new Pawn(false);
        board.addPiece(pawn, new Vector2d(3, 5));

        Pawn pawnToCheck = new Pawn(false);
        pawnToCheck.setPosition(new Vector2d(3, 5));
        assertEquals(pawn, pawnToCheck);
    }

    @Test
    void addWhiteRookAt6_2() {
        Board board = new ChessBoard();
        Rook rook = new Rook(true);
        board.addPiece(rook, new Vector2d(6, 2));

        Rook rookToCheck = new Rook(true);
        rookToCheck.setPosition(new Vector2d(6, 2));
        assertEquals(rook, rookToCheck);
    }

    @Test
    void addBlackRookAt1_4() {
        Board board = new ChessBoard();
        Rook rook = new Rook(false);
        board.addPiece(rook, new Vector2d(1, 4));

        Rook rookToCheck = new Rook(false);
        rookToCheck.setPosition(new Vector2d(1, 4));
        assertEquals(rook, rookToCheck);
    }

    @Test
    void addWhiteKnightAt4_7() {
        Board board = new ChessBoard();
        Knight knight = new Knight(true);
        board.addPiece(knight, new Vector2d(4, 7));

        Knight knightToCheck = new Knight(true);
        knightToCheck.setPosition(new Vector2d(4, 7));
        assertEquals(knight, knightToCheck);
    }

    @Test
    void addBlackKnightAt0_3() {
        Board board = new ChessBoard();
        Knight knight = new Knight(false);
        board.addPiece(knight, new Vector2d(0, 3));

        Knight knightToCheck = new Knight(false);
        knightToCheck.setPosition(new Vector2d(0, 3));
        assertEquals(knight, knightToCheck);
    }

    @Test
    void addWhiteBishopAt5_1() {
        Board board = new ChessBoard();
        Bishop bishop = new Bishop(true);
        board.addPiece(bishop, new Vector2d(5, 1));

        Bishop bishopToCheck = new Bishop(true);
        bishopToCheck.setPosition(new Vector2d(5, 1));
        assertEquals(bishop, bishopToCheck);
    }

    @Test
    void addBlackBishopAt2_6() {
        Board board = new ChessBoard();
        Bishop bishop = new Bishop(false);
        board.addPiece(bishop, new Vector2d(2, 6));

        Bishop bishopToCheck = new Bishop(false);
        bishopToCheck.setPosition(new Vector2d(2, 6));
        assertEquals(bishop, bishopToCheck);
    }

    @Test
    void addWhiteQueenAt7_0() {
        Board board = new ChessBoard();
        Queen queen = new Queen(true);
        board.addPiece(queen, new Vector2d(7, 0));

        Queen queenToCheck = new Queen(true);
        queenToCheck.setPosition(new Vector2d(7, 0));
        assertEquals(queen, queenToCheck);
    }

    @Test
    void addBlackQueenAt2_2() {
        Board board = new ChessBoard();
        Queen queen = new Queen(false);
        board.addPiece(queen, new Vector2d(2, 2));

        Queen queenToCheck = new Queen(false);
        queenToCheck.setPosition(new Vector2d(2, 2));
        assertEquals(queen, queenToCheck);
    }

    @Test
    void addWhiteKingAt3_6() {
        Board board = new ChessBoard();
        King king = new King(true);
        board.addPiece(king, new Vector2d(3, 6));

        King kingToCheck = new King(true);
        kingToCheck.setPosition(new Vector2d(3, 6));
        assertEquals(king, kingToCheck);
    }

    @Test
    void addBlackKingAt6_3() {
        Board board = new ChessBoard();
        King king = new King(false);
        board.addPiece(king, new Vector2d(6, 3));

        King kingToCheck = new King(false);
        kingToCheck.setPosition(new Vector2d(6, 3));
        assertEquals(king, kingToCheck);
    }

    @Test
    void addBlackBishopAt2_6AndThenWhitePawnAt2_6() {
        Board board = new ChessBoard();
        Bishop bishop = new Bishop(false);
        board.addPiece(bishop, new Vector2d(2, 6));

        Pawn pawn = new Pawn(true);
        board.addPiece(pawn, new Vector2d(2, 6));

        Bishop bishopToCheck = new Bishop(false);
        bishopToCheck.setPosition(new Vector2d(2, 6));
        assertEquals(bishop, bishopToCheck);
    }

    @Test
    void addWhiteKnightAt3_2AndThenWhiteKnightAt3_2() {
        Board board = new ChessBoard();
        Knight knight = new Knight(false);
        board.addPiece(knight, new Vector2d(2, 6));

        Knight knight2 = new Knight(true);
        board.addPiece(knight2, new Vector2d(2, 6));

        Knight knightToCheck = new Knight(false);
        knightToCheck.setPosition(new Vector2d(2, 6));
        assertEquals(knight, knightToCheck);
    }

}