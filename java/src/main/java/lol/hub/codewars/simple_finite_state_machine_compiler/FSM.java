package lol.hub.codewars.simple_finite_state_machine_compiler;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://www.codewars.com/kata/59923f1301726f5430000059">codewars.com</a>
 */
public class FSM {
    private final Map<String, Pair<Pair<String, String>, Integer>> transitions = new HashMap<>();

    public FSM(String instructions) {
        for (String line : instructions.split("\n")) {
            String[] split = line.split("; ");
            String[] nexts = split[1].split(", ");
            transitions.put(split[0], Pair.of(Pair.of(nexts[0], nexts[1]), Integer.valueOf(split[2])));
        }
    }

    public Result runFSM(String start, int[] inputs) {
        List<String> path = new ArrayList<>();
        path.add(start);
        String state = start;
        for (int i : inputs) {
            Pair<Pair<String, String>, Integer> t = transitions.get(state);
            state = (i == 0) ? t.getLeft().getLeft() : t.getLeft().getRight();
            path.add(state);
        }
        return new Result(state, transitions.get(state).getRight(), path.toArray(String[]::new));
    }
}
