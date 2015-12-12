package game;


import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Direction {
    UP {
        @Override
        public Index getIndex() {
            return new Index(-1, 0);
        }

        @Override
        public List<Block> sort(Collection<Block> blocks) {
            Comparator<Block> comp = (Block b1, Block b2) -> Integer.compare(b1.getIndex().getFirst(), b2.getIndex().getFirst());
            return sort(blocks, comp);
        }

        @Override
        public Direction getOpposite() {
            return Direction.DOWN;
        }
    }, DOWN {
        @Override
        public Index getIndex() {
            return new Index(1, 0);
        }

        @Override
        public List<Block> sort(Collection<Block> blocks) {
            Comparator<Block> comp = (Block b1, Block b2) -> Integer.compare(-b1.getIndex().getFirst(), -b2.getIndex().getFirst());
            return sort(blocks, comp);
        }

        @Override
        public Direction getOpposite() {
            return Direction.UP;
        }
    }, LEFT {
        @Override
        public Index getIndex() {
            return new Index(0, -1);
        }

        @Override
        public List<Block> sort(Collection<Block> blocks) {
            Comparator<Block> comp = (Block b1, Block b2) -> Integer.compare(b1.getIndex().getSecond(), b2.getIndex().getSecond());
            return sort(blocks, comp);
        }

        @Override
        public Direction getOpposite() {
            return Direction.RIGHT;
        }
    }, RIGHT {
        @Override
        public Index getIndex() {
            return new Index(0, 1);
        }

        @Override
        public List<Block> sort(Collection<Block> blocks) {
            Comparator<Block> comp = (Block b1, Block b2) -> Integer.compare(-b1.getIndex().getSecond(), -b2.getIndex().getSecond());
            return sort(blocks, comp);
        }

        @Override
        public Direction getOpposite() {
            return Direction.LEFT;
        }
    };

    /**
     * @return Index representing the movement in this direction.
     */
    public abstract Index getIndex();


    /**
     * Sort block according to this direction.
     *
     * @param blocks The blocks to sort.
     * @return A sorted list of blocks.
     */
    public abstract List<Block> sort(Collection<Block> blocks);

    /**
     * Sort blocks with given comparator.
     *
     * @param blocks          The blocks to sort.
     * @param blockComparator The comparator to use while sorting.
     * @return A sorted list of the given blocks.
     */
    List<Block> sort(Collection<Block> blocks, Comparator<Block> blockComparator) {
        return blocks.stream().sorted(blockComparator).collect(Collectors.toList());
    }

    public abstract Direction getOpposite();
}
