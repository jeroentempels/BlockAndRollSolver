package blocks;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jeroen on 8/12/15.
 */
public class BlockFactory {

    private final EmptyBlock emptyBlock;
    private final FullBlock fullBlock;
    private final Set<MovingBlock> blocks;

    public BlockFactory() {
        this.emptyBlock = new EmptyBlock();
        this.fullBlock = new FullBlock();
        this.blocks = new HashSet<>();
    }

    public EmptyBlock getEmptyBlock() {
        return this.emptyBlock;
    }

    public FullBlock getFullBlock() {
        return fullBlock;
    }

    public MovingBlock getBlock(boolean bird, boolean up, boolean right, boolean down, boolean left) {
        return new MovingBlock(bird, new Walls(up, right, down, left));
    }

    public MovingBlock getBlock(boolean bird, Walls walls) {
        return new MovingBlock(bird, walls);
    }
}
