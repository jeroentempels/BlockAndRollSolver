package solver;

import java.util.HashSet;
import java.util.Set;

public class GameState {

    private final int movesPerformed;
    private final Board board;
    private final GameState previous;
    private final Direction move;

    private GameState(int movesPerformed, Board board, GameState previous, Direction move) {
        this.movesPerformed = movesPerformed;
        this.board = board;
        this.move = move;
        this.previous = previous;
    }

    GameState(Board board) {
        this(0, board, null, null);
    }

    public int getMovesPerformed() {
        return movesPerformed;
    }

    public Board getBoard() {
        return board;
    }

    public Direction getMove() {
        return move;
    }

    Set<GameState> getNextStates() {
        Set<GameState> nextStates = new HashSet<>();
        for (Direction dir : Direction.values()) {
            if (dir == move) {
                continue;
            }
            nextStates.add(new GameState(movesPerformed + 1, board.copyAndMove(dir), this, dir));
        }
        return nextStates;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "movesPerformed=" + movesPerformed +
                ", board=" + board +
                ", move=" + move +
                '}';
    }

    public boolean isFinished(int x, int y, Direction dir) {
        return board.isFinished(x, y, dir);
    }

    public void print() {
        System.out.println("===================");
        System.out.println(move);
        board.print();
        if(this.previous != null) {
            previous.print();
        }
    }

    public void printSequence() {
        if(previous != null && previous.move != null) {
            previous.printSequence();
        }
        System.out.println(move);
    }
}
