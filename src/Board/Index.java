package Board;

/**
 * Class representing an index of a 2d-array.
 */
public class Index {

    // row index
    private final int first;

    // column index
    private final int second;

    /**
     * Create a new index.
     *
     * @param first  The row index of the index.
     * @param second The column index of the index.
     */
    public Index(int first, int second) {
        this.first = first;
        this.second = second;
    }

    /**
     * @return The row index.
     */
    public int getFirst() {
        return first;
    }

    /**
     * @return The column index.
     */
    public int getSecond() {
        return second;
    }

    /**
     * Add a index to this index.
     *
     * @param index The index to add.
     * @return The index that is the result of adding this index to the given one.
     */
    public Index plus(Index index) {
        return new Index(first + index.first, second + index.second);
    }

    /**
     * Subtract an index from this index.
     *
     * @param index The index to subtract.
     * @return The index that is the result of subtracting the given index from this one.
     */
    public Index min(Index index) {
        return new Index(first - index.first, second - index.second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Index index = (Index) o;

        if (first != index.first) return false;
        return second == index.second;

    }

    @Override
    public int hashCode() {
        int result = first;
        result = 31 * result + second;
        return result;
    }

    @Override
    public String toString() {
        return "Index{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
