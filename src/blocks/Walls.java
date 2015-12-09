package blocks;

import solver.Direction;

/**
 * Created by jeroen on 8/12/15.
 */
public class Walls {

    private final boolean up;
    private final boolean right;
    private final boolean down;
    private final boolean left;

    public Walls(boolean up, boolean right, boolean down, boolean left) {
        this.up = up;
        this.right = right;
        this.down = down;
        this.left = left;
    }

    public boolean hasWall(Direction dir) {
        switch (dir) {
            case UP:
                return up;
            case DOWN:
                return down;
            case LEFT:
                return left;
            case RIGHT:
                return right;
            default:
                throw new IllegalArgumentException();
        }
    }

    public boolean hasWallFrom(Direction dir) {
        switch (dir) {
            case UP:
                return down;
            case DOWN:
                return up;
            case LEFT:
                return right;
            case RIGHT:
                return left;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Walls walls = (Walls) o;

        if (up != walls.up) return false;
        if (right != walls.right) return false;
        if (down != walls.down) return false;
        return left == walls.left;

    }

    @Override
    public int hashCode() {
        int result = (up ? 1 : 0);
        result = 31 * result + (right ? 1 : 0);
        result = 31 * result + (down ? 1 : 0);
        result = 31 * result + (left ? 1 : 0);
        return result;
    }
}
