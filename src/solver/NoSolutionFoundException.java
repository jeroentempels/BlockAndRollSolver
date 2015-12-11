package solver;

/**
 * Created by jeroen on 12/12/15.
 */
public class NoSolutionFoundException extends RuntimeException {

    public NoSolutionFoundException() {
        super();
    }

    public NoSolutionFoundException(String s) {
        super(s);
    }
}
