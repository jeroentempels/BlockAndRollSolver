package Board;

import java.util.*;

public class Board {

    private final Index bird;
    private final boolean[][] field;
    private final Map<Index, Block> blocks;

    Board(Index bird, boolean[][] field, Map<Index, Block> blocks) {
        this.bird = bird;
        this.field = field;
        this.blocks = blocks;
    }

    public Board copyAndMove(Direction direction) {
        BoardBuilder builder = new BoardBuilder(field);
        Map<Index, Block> newBlocks =new HashMap<>();
        List<Block> tempBlocks = direction.sort(blocks.values());
        tempBlocks.forEach(block -> moveBlock(block, direction, newBlocks, builder));
        newBlocks.forEach((k,v) -> builder.addMovingBlock(k,v));
        return builder.toBoard();
    }

    private void moveBlock(Block block, Direction direction, Map<Index, Block> map, BoardBuilder builder) {
        boolean flag = false;
        if(bird.equals(block.getIndex())) {
            if( !block.hasWall(direction)) {
                moveBird(direction, map, builder);
            } else {
                flag = true;
            }
        }


        Index current = block.getIndex().plus(direction.getIndex());

        while(isValid(current) && getElem(current, field) && !map.containsKey(current)) {
            current = current.plus(direction.getIndex());
        }

        Index newIndex = current.min(direction.getIndex());
        map.put(newIndex, new Block(newIndex, block));
        if(flag) {
            builder.addBird(newIndex);
        }
    }

    private void moveBird(Direction direction, Map<Index, Block> map, BoardBuilder builder) {
        Index ind = bird.plus(direction.getIndex());
        while (isValid(ind) && getElem(ind, field)
                && (!map.containsKey(ind) || (!map.get(ind).hasWall(direction) && !map.get(ind).hasWallFrom(direction)))) {
            ind = ind.plus(direction.getIndex());
        }
        if(map.containsKey(ind) && !map.get(ind).hasWallFrom(direction) && map.get(ind).hasWall(direction)) {
            builder.addBird(ind);
        } else {
            builder.addBird(ind.min(direction.getIndex()));
        }

    }

    public Index getBird() {
        return bird;
    }

    private boolean isValid(Index i) {
        return i.getFirst() >= 0 && i.getSecond() >= 0 && i.getFirst() < field.length && i.getSecond() < field[0].length;
    }

    private boolean getElem(Index index, boolean[][] field) {
        return field[index.getFirst()][index.getSecond()];
    }

    public Set<Block> getBlocks() {
        return new HashSet<>(blocks.values());
    }

    public boolean isFinished(int x, int y, Direction dir) {
        Index ind = new Index(x,y);
        if(!blocks.containsKey(ind)) {
            return false;
        } else if (blocks.get(ind).hasWall(dir) || !bird.equals(ind)) {
            return false;
        }
        return true;
    }

    public void print() {
        System.out.println("bird: " + bird);
        blocks.values().forEach(x -> System.out.println(x));
    }
}
