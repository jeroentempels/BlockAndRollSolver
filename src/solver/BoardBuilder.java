package solver;

import java.util.HashMap;

/**
 * Created by jeroen on 8/12/15.
 */
public class BoardBuilder {

    private Index bird;
    private final boolean tiles[][];
    private final HashMap<Index, Block> blocks;


    public BoardBuilder(boolean[][] tiles) {
        this.tiles = tiles;
        blocks = new HashMap<>();
    }

    public void addMovingBlock(int i, int j, boolean up, boolean right, boolean down, boolean left) {
        Index ind = new Index(i,j);
        blocks.put(ind, new Block(ind, up, right, down, left));
    }

    public void addBird(int i, int j) {
        bird = new Index(i, j);
    }

    public void addBird(Index i) {
        bird = i;
    }

    public Index getBird() {
        return bird;
    }

    public void addMovingBlock(Index i, Block block) {
        blocks.put(i, block);
    }

    public Board getBoard() {
        return new Board(bird, tiles, blocks);
    }

}
