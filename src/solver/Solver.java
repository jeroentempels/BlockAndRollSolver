package solver;


import game.*;

import java.util.*;

/**
 * Class that finds the shortest list of moves to perform so that the bird finds the exit.
 */
public class Solver {

    /**
     * Solve the board.
     *
     * @param board The board to solve.
     * @param x     The row index of the goal position.
     * @param y     The column index of the goal position.
     * @param dir   The direction at which there is a exit at the goal position.
     * @return A list containing the moves in order to win.
     */
    public static List<Direction> solve(Board board, int x, int y, Direction dir) {

        Queue<GameState> states = new LinkedList<>();
        states.add(new GameState(board));
        Set<Board> cache = new HashSet<>();

        while (!states.peek().isFinished(new Index(x, y), dir)) {
            for (GameState state : states.poll().getNextStates()) {
                if (cache.contains(state.getBoard())) {
                    continue;
                }
                cache.add(state.getBoard());
                states.add(state);
            }
        }
        return getMoves(states.poll());
    }

    private static List<Direction> getMoves(GameState state) {
        List<Direction> directions = new ArrayList<>();
        while (state.getPrevious() != null) {
            directions.add(state.getMove());
            state = state.getPrevious();
        }
        Collections.reverse(directions);
        return directions;
    }

}
