package lol.hub.codewars.simple_finite_state_machine_compiler;

public class Result {
    public final String finalState;
    public final int output;
    public final String[] path;

    public Result(String finalState, int output, String... path) {
        this.finalState = finalState;
        this.output = output;
        this.path = path;
    }
}
