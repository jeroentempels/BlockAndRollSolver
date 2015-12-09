package blocks;

import solver.Direction;

public class FullBlock implements Block {

    FullBlock() {
        super();
    }
    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public boolean canBeMovedTo() {
        return false;
    }

    @Override
    public boolean hasWall(Direction dir) {
        return true;
    }

    @Override
    public boolean hasWallFrom(Direction dir) {
        return true;
    }

    @Override
    public Walls getWalls() {
        return new Walls(true, true, true, true);
    }

    @Override
    public boolean hasBird() {
        return false;
    }

    @Override
    public String toString() {
        return "x";
    }
}
