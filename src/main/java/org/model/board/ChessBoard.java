package org.model.board;

import org.model.moves.ChessMove;
import org.model.pieces.Piece;
import org.model.util.Vector2d;
import org.model.pieces.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessBoard implements Board{

    private final List<BoardChangeListener> observers = new ArrayList<>();
    private ChessMove lastMove;

    private final Map<Vector2d, Piece> pieces = new HashMap<>();

    private final int width;
    private final int height;

    public ChessBoard(){
        width = 8;
        height = 8;
    }

    public ChessBoard(int width, int height){
        this.width = width;
        this.height = height;
    }

    //Add the piece to the board if the place is available.
    public void addPiece(Piece piece, Vector2d position){
        if (isOccupied(position)) return;
        piece.setPosition(position);
        piece.setBoard(this);
        pieces.put(position, piece);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return pieces.containsKey(position);
    }

    @Override
    public Piece objectAt(Vector2d position) {
        if (!isOccupied(position)) return null;
        return pieces.get(position);
    }

    @Override
    public boolean isInBoundaries(Vector2d position) {
        return position.getX() >= 0 && position.getX() < width && position.getY() >= 0 && position.getY() < height;
    }

    //Performs the move on the board
    @Override
    public void move(Piece piece, Vector2d position) {
        lastMove = new ChessMove(piece, position.subtract(piece.getPosition()), isOccupied(position));
        pieces.remove(piece.getPosition());
        if (pieces.containsKey(position)){
            //todo: in the future, handle capturing here
            pieces.remove(position);
        }

        piece.setPosition(position);
        pieces.put(position, piece);
        pieceMoved(lastMove.getPiece(), lastMove.getMove());
        piece.pieceMoved();
    }

    public ChessMove getLastMove(){
        return lastMove;
    }

    //Notify observers, that piece has been moved
    public void pieceMoved(Piece piece, Vector2d move){
        for (BoardChangeListener observer : observers){
            observer.boardChanged(this, piece, move);
        }
    }

    @Override
    public Vector2d getBoundaries() {
        return new Vector2d(width, height);
    }

    //Add observer
    @Override
    public void subscribeObserver(BoardChangeListener listener) {
        if (observers.contains(listener)) return;
        observers.add(listener);
    }

    //Remove observer
    @Override
    public void unSubscribeObserver(BoardChangeListener listener) {
        observers.remove(listener);
    }

    //Sets up the board to its default state
    @Override
    public void resetBoard() {
        for (int i = 0; i < 8; i++){
            addPiece(new Pawn(false), new Vector2d(i, 6));
            addPiece(new Pawn(true), new Vector2d(i, 1));
        }

        addPiece(new Rook(true), new Vector2d(0, 0));
        addPiece(new Rook(false), new Vector2d(0, 7));
        addPiece(new Rook(true), new Vector2d(7, 0));
        addPiece(new Rook(false), new Vector2d(7, 7));

        Knight knight = new Knight(true);
        addPiece(knight, new Vector2d(1, 0));
        addPiece(new Knight(true), new Vector2d(6, 0));
        addPiece(new Knight(false), new Vector2d(1, 7));
        addPiece(new Knight(false), new Vector2d(6, 7));

        addPiece(new Bishop(true), new Vector2d(2, 0));
        addPiece(new Bishop(true), new Vector2d(5, 0));
        addPiece(new Bishop(false), new Vector2d(2, 7));
        addPiece(new Bishop(false), new Vector2d(5, 7));

        Piece king = new King(true);
        addPiece(king, new Vector2d(4, 0));
        addPiece(new King(false), new Vector2d(4, 7));

        addPiece(new Queen(true), new Vector2d(3, 0));
        Piece queen = new Queen(false);
        addPiece(queen, new Vector2d(3, 7));
        pieceMoved(null, null);
    }

    @Override
    public Map<Vector2d, Piece> getElements() {
        return pieces;
    }

    @Override
    public void capturePiece(Vector2d position) {
        if (!isOccupied(position)) return;
        //todo: in the future, do something with captured piece
        pieces.remove(position);
    }

    @Override
    public void castle(Piece piece, Vector2d destination) {
        piece.move(destination);
    }
}
