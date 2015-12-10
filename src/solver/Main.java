package solver;

public class Main {

    public static void main(String[] args) {

        /*
         * TRUE if a block can move to and over this tile.
         * FALSE otherwise
         */
        boolean[][] field = {
                {true, false, true, true, false},
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, true, true, false, false},
                {true, true, true, true, false}
        };

        BoardBuilder builder = new BoardBuilder(field);

        /*
             Add blocks to builder

             first 2 numbers are the index, counting like:
             [(0,0) (0,1)]
             [(1,0) (1,1)]


             last 4 booleans indicate whether the block has a wall on this position.

             bool1 : block has wall on north side.
             bool2 : block has wall on east side.
             bool3 : block has wall on south side.
             bool4 : block has wall on west side.
         */
        builder.addMovingBlock(0, 2, true, false, true, true);
        builder.addMovingBlock(1,1,true, true, true, false);
        builder.addMovingBlock(2,0,true, false, true, false);
        builder.addMovingBlock(3,0,true, true,false,true);
        builder.addMovingBlock(3,1,false,false,true,true);

        // Add the bird
        builder.addBird(0, 2);

        /*
            Solve the puzzle and print it.

            first argument is the given board

            the two numbers are the index of the goal

            last argument is the direction of the goal

            example: goal = block on 0,0 with bird and open wall on north side => 0,0,Direction.UP
         */

        Solver.solve(builder.toBoard(), 4, 2, Direction.DOWN).forEach(System.out::println);

    }


}
