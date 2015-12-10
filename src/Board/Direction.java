package Board;


import Board.Block;
import Board.Index;

import java.util.*;
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
}
