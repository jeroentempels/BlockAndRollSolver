package game;

import java.util.HashMap;

/**
 * Class that builds a board.
 */
public class BoardBuilder {

    // Index at which the bird is located.
    private Index bird;

    // Boolean array indicating whether a block can move to/over the position.
    private final boolean tiles[][];

    // Map from index to block at the index.
    private final HashMap<Index, Block> blocks;


    /**
     * Create a new board builder.
     *
     * @param tiles A boolean 2d-array indicating whether a block can move to/over the position.
     */
    public BoardBuilder(boolean[][] tiles) {
        this.tiles = tiles;
        blocks = new HashMap<>();
    }

    /**
     * Add a block to the builder.
     *
     * @param i     The row index of the block.
     * @param j     The column index of the block.
     * @param up    Boolean indicating whether this block has a wall on the north side.
     * @param right Boolean indicating whether this block has a wall on the east side.
     * @param down  Boolean indicating whether this block has a wall on the south side.
     * @param left  Boolean indicating whether this block has a wall on the west side.
     */
    public void addBlock(int i, int j, boolean up, boolean right, boolean down, boolean left) {
        Index ind = new Index(i, j);
        addBlock(ind, new Block(ind, up, right, down, left));
    }

    /**
     * Add a block to the builder.
     *
     * @param index The index at which the block is located.
     * @param block The block to add.
     */
    public void addBlock(Index index, Block block) {
        if (!index.equals(block.getIndex())) {
            throw new IllegalArgumentException("The given index " + index + " was different from the index of the block " + block + ".");
        }
        blocks.put(index, block);
    }

    /**
     * Add a bird to the builder.
     *
     * @param i The row index of the bird.
     * @param j The column index of the bird.
     */
    public void addBird(int i, int j) {
        bird = new Index(i, j);
    }

    /**
     * Add a bird to the builder
     *
     * @param index The index of the bird.
     */
    public void addBird(Index index) {
        bird = index;
    }

    /**
     * Create a board.
     *
     * @return The newly created board.
     */
    public Board toBoard() {
        if (!blocks.containsKey(bird)) {
            throw new IllegalArgumentException("The bird is at index " + bird + " but there is no block at this index.");
        }
        return new Board(bird, tiles, blocks);
    }

}
