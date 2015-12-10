# BlockAndRollSolver

BlockAndRollSolver is a solver for the android game BlockAndRoll by AppolloGames.

It can be downloaded at the following link: <https://play.google.com/store/apps/details?id=be.appollogames.blockandroll>

## How to use

As an example we will solve the given puzzle:

![Image of level](https://github.com/jeroentempels/BlockAndRollSolver/blob/master/example.png)

First create a boolean array. The elements are true if a block can move to or over the position, false otherwise.

```java
boolean[][] field = {
	{true, false, false},
	{true, true, true},
	{false, false, true}	
};
```

Then we construct a board builder which we will use to create the game board. We pass the boolean array as a parameter.

```java
BoardBuilder builder = new BoardBuilder(field);
```

Then we add the blocks to the builder.
The first two numbers are the coordinate of the block.
For a 3x3 grid, these are the coordinates of the field:

(0,0) (0,1) (0,2)

(1,0) (1,1) (1,2)

(2,0) (2,1) (2,2)

The next four booleans indicate the walls of the block. The order of the walls is NORTH, EAST, SOUTH, WEST.

```java
builder.addBlock(0, 0, true, true, false, true);
builder.addBlock(1, 2, false, true, false, true);
```

We add the bird to the builder.

```java
builder.addBird(0, 0);
```

Finally we run the solver and print the moves. We pass the board created by the builder and the coordinate and direction of the exit.

```java
Solver.solve(builder.toBoard(), 2, 2, Direction.DOWN).forEach(System.out::println);
```