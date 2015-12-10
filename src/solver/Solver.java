package solver;


import Board.*;

import java.util.*;

public class Solver {

    public static List<Direction> solve(Board board, int x, int y, Direction dir) {

        Queue<GameState> states = new LinkedList<>();
        states.add(new GameState(board));
        Set<Board> cache = new HashSet<>();

        while(!states.peek().isFinished(x,y,dir)) {
            for(GameState state : states.poll().getNextStates()) {
                if(cache.contains(state.getBoard())) {
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
