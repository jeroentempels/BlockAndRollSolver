package solver;

/**
 * Created by jeroen on 9/12/15.
 */
public class Index {

    private final int first;
    private final int second;

    public Index(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public Index plus(Index index) {
        return new Index(first+index.first, second+index.second);
    }

    public Index min(Index index) {
        return new Index(first-index.first, second-index.second);
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
