package blocks;

import solver.Direction;

/**
 * Created by jeroen on 8/12/15.
 */
public class EmptyBlock implements Block {

    EmptyBlock() {
        super();
    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public boolean canBeMovedTo() {
        return true;
    }

    @Override
    public boolean hasWall(Direction dir) {
        return false;
    }

    @Override
    public boolean hasWallFrom(Direction dir) {
        return false;
    }

    @Override
    public Walls getWalls() {
        return new Walls(false, false, false, false);
    }

    @Override
    public boolean hasBird() {
        return false;
    }

    @Override
    public String toString() {
        return " ";
    }


}
