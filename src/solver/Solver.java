package solver;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solver {

    public static void solve(Board board, int x, int y, Direction dir) {
        Set<ReducedState> done = new HashSet<>();
        GameState state = new GameState(board);
        Queue<GameState> states = new LinkedList<>();
        states.add(state);

        while (!states.peek().isFinished(x, y, dir)) {
            GameState st = states.poll();
            ReducedState reducedState = new ReducedState(st.getBoard(), st.getMove());
            if(done.contains(reducedState)) {
                continue;
            }
            done.add(reducedState);
            st.getNextStates().forEach(s -> states.add(s));
        }

        states.poll().printSequence();
    }

}
