package solver;

import java.util.*;

public class Solver {

    private static final Block dummy = new Block(new Index(-1,-1),true, true, true, true);

    public static List<Direction> solve(Board board, int x, int y, Direction dir) {

        Queue<GameState> states = new LinkedList<>();
        states.add(new GameState(board));
        Set<Set<Block>> cache = new HashSet<>();

        while(!states.peek().isFinished(x,y,dir)) {
            GameState state =  states.poll();
            Set<Block> c = state.getBoard().getBlocks();
            c.add(new Block(state.getBoard().getBird(), dummy));
            if(cache.contains(c)) {
                continue;
            }
            cache.add(c);
            state.getNextStates().forEach(st -> states.add(st));
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
