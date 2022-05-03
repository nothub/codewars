package lol.hub.codewars.simple_finite_state_machine_compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://www.codewars.com/kata/59923f1301726f5430000059">codewars.com</a>
 */
public class FSM {
    private record State(String t0, String t1, Integer o) {}
    private final Map<String, State> states = new HashMap<>();

    public FSM(String instructions) {
        for (String state : instructions.split("\n")) {
            String[] parts = state.split("; ");
            String[] transitions = parts[1].split(", ");
            states.put(parts[0], new State(transitions[0], transitions[1], Integer.valueOf(parts[2])));
        }
    }

    public Result runFSM(String start, int[] inputs) {
        List<String> path = new ArrayList<>();
        path.add(start);
        String state = start;
        for (int i : inputs) {
            state = (i == 0) ? states.get(state).t0 : states.get(state).t1;
            path.add(state);
        }
        return new Result(state, states.get(state).o, path.toArray(String[]::new));
    }
}
