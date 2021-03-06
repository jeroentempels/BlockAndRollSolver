package game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class representing the game board.
 */
public class Board {

    // The index of the bird.
    private final Index bird;

    // A boolean array indicating whether there can be moved to/over a certain position.
    private final boolean[][] field;

    // A map from an index of a block to the corresponding block.
    private final Map<Index, Block> blocks;

    /**
     * Create a new board.
     *
     * @param bird   The index at which the bird is located.
     * @param field  A boolean array indicating whether there can be moved to/over a certain position.
     * @param blocks A map from an index of a block to the corresponding block.
     */
    Board(Index bird, boolean[][] field, Map<Index, Block> blocks) {
        this.bird = bird;
        this.field = field;
        this.blocks = blocks;
    }


    /**
     * Check whether this board is in a goal state.
     *
     * @param ind The index at which the bird needs to be.
     * @param dir The direction at which the bird can escape.
     * @return True if this board is in a goal state. False otherwise.
     */
    public boolean isFinished(Index ind, Direction dir) {
        if (!blocks.containsKey(ind)) {
            return false;
        } else if (blocks.get(ind).hasWall(dir) || !bird.equals(ind)) {
            return false;
        }
        return true;
    }

    /**
     * Get a new board that is the result of moving this board in the given direction.
     *
     * @param direction The direction to move in.
     * @return A new board that is the result of moving this board in the given direction.
     */
    public Board copyAndMove(Direction direction) {
        BoardBuilder builder = new BoardBuilder(field);
        Map<Index, Block> newBlocks = new HashMap<>();
        List<Block> tempBlocks = direction.sort(blocks.values());
        tempBlocks.forEach(block -> moveBlock(block, direction, newBlocks, builder));
        newBlocks.forEach(builder::addBlock);
        return builder.toBoard();
    }

    private void moveBlock(Block block, Direction direction, Map<Index, Block> map, BoardBuilder builder) {
        Index current = block.getIndex().plus(direction.getIndex());

        while (isValid(current) && getElem(current, field) && !map.containsKey(current)) {
            current = current.plus(direction.getIndex());
        }

        Index newIndex = current.min(direction.getIndex());
        map.put(newIndex, new Block(newIndex, block));

        if(bird.equals(block.getIndex())) {
            builder.addBird(moveBird(newIndex, direction, map));
        }
    }

    private Index moveBird(Index index, Direction direction, Map<Index, Block> map) {
        Index current = index;
        while(!map.get(current).hasWall(direction)
                && map.containsKey(current.plus(direction.getIndex()))
                && !map.get(current.plus(direction.getIndex())).hasWallFrom(direction)) {
            current = current.plus(direction.getIndex());
        }
        return current;
    }

    private boolean isValid(Index i) {
        return i.getFirst() >= 0 && i.getSecond() >= 0 && i.getFirst() < field.length && i.getSecond() < field[0].length;
    }

    private boolean getElem(Index index, boolean[][] field) {
        return field[index.getFirst()][index.getSecond()];
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        if (!bird.equals(board.bird)) return false;
        if (!blocks.equals(board.blocks)) return false;
        return Arrays.deepEquals(field, board.field);
    }

    @Override
    public int hashCode() {
        int result = bird.hashCode();
        result = 31 * result + Arrays.deepHashCode(field);
        result = 31 * result + blocks.hashCode();
        return result;
    }
}
