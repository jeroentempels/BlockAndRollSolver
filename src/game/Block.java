package game;

import java.util.HashSet;
import java.util.Set;

/**
 * Class representing a moving block on the field.
 */
class Block {

    // Index at which this block is located.
    private final Index index;

    // An array containing all the directions of the walls of this block.
    private final Set<Direction> directions;

    /**
     * Create a new block.
     *
     * @param index The index at which this block is located.
     * @param directions An array containing all the directions of the walls of this block.
     */
    public Block(Index index, Set<Direction> directions) {
        if (index == null) {
            throw new IllegalArgumentException("index can't be null.");
        }
        if( directions == null) {
            throw new IllegalArgumentException("directions can't be null.");
        }
        this.index = index;
        this.directions = directions;
    }

    /**
     * Create a copy of an old block with a new index.
     *
     * @param index The new index at which the new block is located.
     * @param block The old block describing the walls of the new block.
     */
    public Block(Index index, Block block) {
        this(index, new HashSet<>(block.directions));
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
        return directions.contains(dir);
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
        return this.hasWall(dir.getOpposite());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Block block = (Block) o;

        if (!index.equals(block.index)) return false;
        return directions.equals(block.directions);

    }

    @Override
    public int hashCode() {
        int result = index.hashCode();
        result = 31 * result + directions.hashCode();
        return result;
    }
}
