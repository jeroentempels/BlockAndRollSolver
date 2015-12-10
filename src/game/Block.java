package game;

/**
 * Class representing a moving block on the field.
 */
public class Block {

    // Index at which this block is located.
    private final Index index;

    // boolean indicating whether this block has a wall on the north side.
    private final boolean up;

    // boolean indicating whether this block has a wall on the east side.
    private final boolean right;

    // boolean indicating whether this block has a wall on the south side.
    private final boolean down;

    // boolean indicating whether this block has a wall on the west side.
    private final boolean left;

    /**
     * Create a new block.
     *
     * @param index The index at which this block is located.
     * @param up    Boolean indicating whether this block has a wall on the north side.
     * @param right Boolean indicating whether this block has a wall on the east side.
     * @param down  Boolean indicating whether this block has a wall on the south side.
     * @param left  Boolean indicating whether this block has a wall on the west side.
     */
    public Block(Index index, boolean up, boolean right, boolean down, boolean left) {
        if (index == null) {
            throw new IllegalArgumentException("index can't be null.");
        }
        this.index = index;
        this.up = up;
        this.right = right;
        this.down = down;
        this.left = left;
    }

    /**
     * Create a copy of an old block with a new index.
     *
     * @param index The new index at which the new block is located.
     * @param block The old block describing the walls of the new block.
     */
    public Block(Index index, Block block) {
        this(index, block.up, block.right, block.down, block.left);
    }

    /**
     * @return The index at which this block is located.
     */
    public Index getIndex() {
        return index;
    }

    /**
     * Check whether this block has a wall on the side of a given direction.
     *
     * @param dir The direction to check.
     * @return True is the block has a wall on the side of a given direction.
     */
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

    /**
     * Check whether this block has a wall on the opposite side of a given direction.
     * <p>
     * UP <-> DOWN
     * LEFT <-> RIGHT
     *
     * @param dir The direction to check.
     * @return True is the block has a wall on the opposite side of a given direction.
     */
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
