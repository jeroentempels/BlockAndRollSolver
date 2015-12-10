# BlockAndRollSolver

BlockAndRollSolver is a solver for the android game BlockAndRoll by AppolloGames.

It can be downloaded at the following link: <https://play.google.com/store/apps/details?id=be.appollogames.blockandroll>

## How to use

First create a boolean array. The elements are true if a block can move to or over the position, false otherwise.

```java
boolean[][] field = {
	{true, false, false},
	{true, true, true},
	{false, false, true}	
};

```
