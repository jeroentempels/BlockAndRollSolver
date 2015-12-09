package solver;

import blocks.Block;
import blocks.BlockFactory;
import blocks.Walls;

/**
 * Created by jeroen on 8/12/15.
 */
public class BoardBuilder {

    private final Block[][] board;
    private final BlockFactory factory;

    public BoardBuilder(boolean[][] tiles) {
        board = new Block[tiles.length][tiles[0].length];
        factory = new BlockFactory();

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if(tiles[i][j]) {
                    board[i][j] = factory.getEmptyBlock();
                } else {
                    board[i][j] = factory.getFullBlock();
                }
            }
        }
    }

    public void addMovingBlock(int i, int j, boolean bird, boolean up, boolean right, boolean down, boolean left) {
        board[i][j] = factory.getBlock(bird, up, right, down, left);
    }

    public Board getBoard() {
        return new Board(board);
    }

}
