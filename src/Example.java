import game.BoardBuilder;
import game.Direction;
import solver.Solver;

public class Example {

    public static void main(String[] args) {

        boolean[][] field = {
                {true, false, false},
                {true, true, true},
                {false, false, true}
        };

        BoardBuilder builder = new BoardBuilder(field);

        builder.addBlock(0, 0, true, true, false, true);
        builder.addBlock(1, 2, false, true, false, true);

        builder.addBird(0, 0);

        Solver.solve(builder.toBoard(), 2, 2, Direction.DOWN).forEach(System.out::println);

    }


}
