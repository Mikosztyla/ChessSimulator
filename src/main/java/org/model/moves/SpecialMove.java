package org.model.moves;

import org.model.util.Vector2d;

public class SpecialMove {
    private final Vector2d move;
    private final boolean hasToTakeOnDestinationField;
    private final SpecialMoveChecker additionalConditions;
    private boolean canTakeOnMove;

    public SpecialMove(Vector2d move, boolean hasToTakeOnDestinationField, SpecialMoveChecker additionalConditions) {
        this.move = move;
        this.hasToTakeOnDestinationField = hasToTakeOnDestinationField;
        this.additionalConditions = additionalConditions;
        canTakeOnMove = true;
    }

    public Vector2d getMove() {
        return move;
    }

    public boolean getHasToTakeOnDestinationField() {
        return hasToTakeOnDestinationField;
    }

    public SpecialMoveChecker getAdditionalConditions() {
        return additionalConditions;
    }

    public boolean getCanTakeOnMove(){
        return canTakeOnMove;
    }

    public void setCanTakeOnMove(boolean value){
        canTakeOnMove = value;
    }
}
