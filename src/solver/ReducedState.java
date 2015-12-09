package solver;

/**
 * Created by jeroen on 8/12/15.
 */
class ReducedState {
    private final Board board;
    private final Direction move;

    public ReducedState(Board board, Direction move) {
        this.board = board;
        this.move = move;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReducedState that = (ReducedState) o;

        if (board != null ? !board.equals(that.board) : that.board != null) return false;
        return move == that.move;

    }

    @Override
    public int hashCode() {
        int result = board != null ? board.hashCode() : 0;
        result = 31 * result + (move != null ? move.hashCode() : 0);
        return result;
    }
}
