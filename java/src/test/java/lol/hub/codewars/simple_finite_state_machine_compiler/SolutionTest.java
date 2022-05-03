package lol.hub.codewars.simple_finite_state_machine_compiler;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// TODO: Replace examples and use TDD by writing your own tests

public class SolutionTest {
    @Test
    public void exampleTest() {
        assertEquals(new Result("S1", 9, "S1", "S1", "S2", "S3", "S4", "S1"), new FSM("S1; S1, S2; 9\nS2; S1, S3; 10\nS3; S4, S3; 8\nS4; S4, S1; 0").runFSM("S1", new int[]{0, 1, 1, 0, 1}));
    }
}
