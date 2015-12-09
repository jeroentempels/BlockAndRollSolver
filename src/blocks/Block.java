package blocks;

import solver.Direction;

public interface Block {

    boolean canMove();

    boolean canBeMovedTo();

    boolean hasWall(Direction dir);

    boolean hasWallFrom(Direction dir);

    Walls getWalls();

    boolean hasBird();

}
