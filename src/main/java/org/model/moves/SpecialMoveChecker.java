package org.model.moves;

import org.model.util.Vector2d;

@FunctionalInterface
public interface SpecialMoveChecker {
    public boolean isValidMove(Vector2d field);
}
