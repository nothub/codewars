package lol.hub.codewars.simple_finite_state_machine_compiler;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
instructions:
S1; S1, S2; 9
S2; S1, S3; 10
S3; S4, S3; 8
S4; S4, S1; 0

start: S1
sequence: 0, 1, 1, 0, 1

input 0: S1->S1
input 1: S1->S2
input 1: S2->S3
input 0: S3->S4
input 1: S4->S1

final state: S1
output: 9
*/

public class SolutionTest {
    @Test
    public void exampleTest() {
        assertEquals(
            new Result("S1", 9, "S1", "S1", "S2", "S3", "S4", "S1"),
            new FSM("S1; S1, S2; 9\nS2; S1, S3; 10\nS3; S4, S3; 8\nS4; S4, S1; 0")
                .runFSM("S1", new int[]{0, 1, 1, 0, 1})
        );
    }
}
