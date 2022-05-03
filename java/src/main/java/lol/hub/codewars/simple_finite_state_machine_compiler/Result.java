package lol.hub.codewars.simple_finite_state_machine_compiler;

import java.util.Arrays;

public class Result {
    public final String finalState;
    public final int output;
    public final String[] path;

    public Result(String finalState, int output, String... path) {
        this.finalState = finalState;
        this.output = output;
        this.path = path;
    }

    @Override
    public String toString() {
        return "Result{" +
            "finalState='" + finalState + '\'' +
            ", output=" + output +
            ", path=" + Arrays.toString(path) +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (output != result.output) return false;
        if (finalState != null ? !finalState.equals(result.finalState) : result.finalState != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(path, result.path);
    }

    @Override
    public int hashCode() {
        int result = finalState != null ? finalState.hashCode() : 0;
        result = 31 * result + output;
        result = 31 * result + Arrays.hashCode(path);
        return result;
    }
}
