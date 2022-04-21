package lol.hub.codewars.simple_assembler_interpreter;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void simple_1() {
        String[] program = new String[]{"mov a 5", "inc a", "dec a", "dec a", "jnz a -1", "inc a"};
        Map<String, Integer> expected = Map.of("a", 1);
        assertEquals(expected, SimpleAssembler.interpret(program));
    }

    @Test
    public void simple_2() {
        String[] program = new String[]{"mov a -10", "mov b a", "inc a", "dec b", "jnz a -2"};
        Map<String, Integer> expected = Map.of("a", 0, "b", -20);
        assertEquals(expected, SimpleAssembler.interpret(program));
    }

    @Test
    public void complex_1() {
        String[] program = new String[]{"mov d 100", "dec d", "mov b d", "jnz b -2", "inc d", "mov a d", "jnz 5 10", "mov c a"};
        Map<String, Integer> expected = Map.of("a", 1, "b", 0, "d", 1);
        assertEquals(expected, SimpleAssembler.interpret(program));
    }

    @Test
    public void complex_2() {
        String[] program = new String[]{"mov c 12", "mov b 0", "mov a 200", "dec a", "inc b", "jnz a -2", "dec c", "mov a b", "jnz c -5", "jnz 0 1", "mov c a"};
        Map<String, Integer> expected = Map.of("a", 409600, "b", 409600, "c", 409600);
        assertEquals(expected, SimpleAssembler.interpret(program));
    }
}
