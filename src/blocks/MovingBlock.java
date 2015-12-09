package blocks;

import solver.Direction;

/**
 * Created by jeroen on 8/12/15.
 */
public class MovingBlock implements Block {

    private final boolean bird;
    private final Walls walls;

    MovingBlock(boolean bird, Walls walls) {
        this.bird = bird;
        this.walls = walls;
    }

    @Override
    public boolean canMove() {
        return true;
    }

    @Override
    public boolean canBeMovedTo() {
        return false;
    }

    @Override
    public boolean hasWall(Direction dir) {
        return walls.hasWall(dir);
    }

    @Override
    public boolean hasWallFrom(Direction dir) {
        return walls.hasWallFrom(dir);
    }

    @Override
    public Walls getWalls() {
        return walls;
    }

    @Override
    public boolean hasBird() {
        return bird;
    }

    @Override
    public String toString() {
        if(hasBird()) {
            return "b";
        }
        return "m";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovingBlock that = (MovingBlock) o;

        if (bird != that.bird) return false;
        return !(walls != null ? !walls.equals(that.walls) : that.walls != null);

    }

    @Override
    public int hashCode() {
        int result = (bird ? 1 : 0);
        result = 31 * result + (walls != null ? walls.hashCode() : 0);
        return result;
    }
}
