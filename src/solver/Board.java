package solver;

import blocks.Block;
import blocks.BlockFactory;
import blocks.MovingBlock;

import java.util.Arrays;

public class Board {

    private final BlockFactory factory;
    private final Block[][] field;

    public Board(Block[][] field) {
        this.field = field;
        this.factory = new BlockFactory();
    }

    Board copyAndMove(Direction direction) {
        Block[][] copy = copyField();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                moveBlock(i, j, copy, direction);
            }
        }
        return new Board(copy);
    }

    private void moveBlock(int i, int j, Block[][] field, Direction direction) {
        int x = i + direction.getRow();
        int y = j + direction.getColumn();

        if (!field[i][j].canMove() || x < 0 || x >= field.length || y < 0 || y >= field[0].length) {
            return;
        }
        Block next = field[x][y];

        if (next.canBeMovedTo()) {
            swap(i, j, x, y, field);
            moveBlock(x, y, field, direction);
        } else if (next.canMove()) {
            if (field[i][j].hasBird() && !field[i][j].hasWall(direction) && !next.hasWallFrom(direction)) {
                field[x][y] = factory.getBlock(true, field[x][y].getWalls());
                field[i][j] = factory.getBlock(false, field[i][j].getWalls());
            }
            moveBlock(x, y, field, direction);
            if (field[x][y].canBeMovedTo()) {
                moveBlock(i, j, field, direction);
            }
        }
    }

    private void swap(int i, int j, int x, int y, Block[][] field) {
        Block temp = field[i][j];
        field[i][j] = field[x][y];
        field[x][y] = temp;
    }

    private Block[][] copyField() {
        Block[][] copy = new Block[field.length][field[0].length];
        for (int i = 0; i < field.length; i++) {
            copy[i] = field[i].clone();
        }
        return copy;
    }

    public boolean isFinished(int x, int y, Direction dir) {
        Block b = field[x][y];
        return b.hasBird() && !b.hasWall(dir);
    }

    public void print() {
        for (int i = 0; i < field.length; i++) {
            System.out.println(Arrays.toString(field[i]));
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        return Arrays.deepEquals(field, board.field);

    }

    @Override
    public int hashCode() {
        return field != null ? Arrays.deepHashCode(field) : 0;
    }
}
