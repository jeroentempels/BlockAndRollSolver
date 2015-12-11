import game.BoardBuilder;
import game.Direction;
import solver.NoSolutionFoundException;
import solver.Solver;

public class Example {

    public static void main(String[] args) {

        boolean[][] field = {
                {true, false, true, true, false},
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, true, true, false, false},
                {true, true, true, true, false}
        };

        BoardBuilder builder = new BoardBuilder(field);

        builder.addBlock(0, 2, true, false, true, true);
        builder.addBlock(1, 1, true, true, true, false);
        builder.addBlock(2, 0, true, false, true, false);
        builder.addBlock(3, 0, true, true, false, true);
        builder.addBlock(3, 1, false, false, true, true);

        builder.addBird(0, 2);

        try {
            Solver.solve(builder.toBoard(), 4, 2, Direction.DOWN).forEach(System.out::println);
        } catch (NoSolutionFoundException e) {
            System.out.println(e.getMessage());
        }

    }


}
