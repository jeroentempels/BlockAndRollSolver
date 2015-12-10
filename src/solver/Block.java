package solver;

/**
 * Created by jeroen on 9/12/15.
 */
public class Block {

    private final Index index;
    private final boolean up;
    private final boolean right;
    private final boolean down;
    private final boolean left;

    public Block(Index index, boolean up, boolean right, boolean down, boolean left) {
        this.index = index;
        this.up = up;
        this.right = right;
        this.down = down;
        this.left = left;
    }

    public Block(Index index, Block b) {
        this(index, b.up, b.right, b.down, b.left);
    }

    public Index getIndex() {
        return index;
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
    public String toString() {
        String up = " ";
        String down = " ";
        String left = " ";
        String right = " ";

        if(this.up) {
            up =  "-";
        }

        if(this.down) {
            down = "-";
        }

        if(this.left) {
            left = "|";
        }

        if(this.right) {
            right = "|";
        }

        return index + "\n" + " " + up + " \n"
                + left + "b" + right + "\n"
                + " " + down + " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Block block = (Block) o;

        if (up != block.up) return false;
        if (right != block.right) return false;
        if (down != block.down) return false;
        if (left != block.left) return false;
        return index.equals(block.index);

    }

    @Override
    public int hashCode() {
        int result = index.hashCode();
        result = 31 * result + (up ? 1 : 0);
        result = 31 * result + (right ? 1 : 0);
        result = 31 * result + (down ? 1 : 0);
        result = 31 * result + (left ? 1 : 0);
        return result;
    }
}
