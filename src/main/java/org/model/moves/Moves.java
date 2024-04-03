package org.model.moves;

import org.model.util.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Moves {
    static final Vector2d[] verticalMoves = {new Vector2d(0, 1), new Vector2d(0, -1)};
    static final Vector2d[] horizontalMoves = {new Vector2d(1, 0), new Vector2d(-1, 0)};
    static final Vector2d[] diagonalMoves = {new Vector2d(1, 1), new Vector2d(1, -1),
            new Vector2d(-1, -1), new Vector2d(-1, 1)};

    public static List<Vector2d> getVerticalMoves(){
        return new ArrayList<>(List.of(verticalMoves));
    }

    public static List<Vector2d> getHorizontalMoves(){
        return new ArrayList<>(List.of(horizontalMoves));
    }

    public static List<Vector2d> getDiagonalMoves(){
        return new ArrayList<>(List.of(diagonalMoves));
    }

    public static List<Vector2d> getRookMoves(){
        List<Vector2d> rookMoves = new ArrayList<>();
        rookMoves.addAll(getHorizontalMoves());
        rookMoves.addAll(getVerticalMoves());
        return rookMoves;
    }

    public static List<Vector2d> getQueenMoves(){
        List<Vector2d> queenMoves = new ArrayList<>();
        queenMoves.addAll(getRookMoves());
        queenMoves.addAll(List.of(diagonalMoves));
        return queenMoves;
    }

    public static List<Vector2d> getKnightMoves(){
        Vector2d[] knightMoves = {new Vector2d(1, 2), new Vector2d(2, 1),
        new Vector2d(2, -1), new Vector2d(1, -2),
        new Vector2d(-1, -2), new Vector2d(-2, -1),
        new Vector2d(-2, 1), new Vector2d(-1, 2)};
        return List.of(knightMoves);
    }
}



