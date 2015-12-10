package solver;

import game.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Class that represents the state of the game at a certain point in time.
 */
public class GameState {

    // Amount of moves performed since initial state.
    private final int movesPerformed;

    // The current state of the board;
    private final Board board;

    // The previous state the game was in.
    private final GameState previous;

    // The move performed in the previous state to get to this state.
    private final Direction move;

    private GameState(int movesPerformed, Board board, GameState previous, Direction move) {
        this.movesPerformed = movesPerformed;
        this.board = board;
        this.move = move;
        this.previous = previous;
    }

    /**
     * Create a initial game state.
     *
     * @param board The initial board.
     */
    GameState(Board board) {
        this(0, board, null, null);
    }

    /**
     * @return The amount of moves performed to get to this state from the initial state.
     */
    public int getMovesPerformed() {
        return movesPerformed;
    }

    /**
     * @return The board belonging to this state.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @return The move performed in the previous state to get to this state.
     */
    public Direction getMove() {
        return move;
    }

    /**
     * @return The state the game was in before this one.
     */
    public GameState getPrevious() {
        return previous;
    }


    /**
     * Check whether this state is an end state.
     *
     * @param index The index of the goal position for the bird.
     * @param dir The goal direction for the bird.
     *
     * @return True if this state is a end state. False otherwise.
     */
    public boolean isFinished(Index index, Direction dir) {
        return board.isFinished(index, dir);
    }

    /**
     * Calculate the states following this one.
     *
     * @return The set of all states that follow this state.
     */
    Set<GameState> getNextStates() {
        Set<GameState> nextStates = new HashSet<>();
        for (Direction dir : Direction.values()) {
            if (dir == move) { // optimization
                continue;
            }
            nextStates.add(new GameState(movesPerformed + 1, board.copyAndMove(dir), this, dir));
        }
        return nextStates;
    }
}
