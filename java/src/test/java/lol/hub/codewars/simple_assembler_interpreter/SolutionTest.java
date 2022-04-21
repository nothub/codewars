package lol.hub.codewars.simple_assembler_interpreter;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void simple_1() {
        /*
        set register a to 5,
        increase its value by 1,
        decrease its value by 2,
        then decrease its value until it is zero (jnz a -1 jumps to the previous instruction if a is not zero)
        and then increase its value by 1, leaving register a at 1
        So, the function should return: {a=1}
         */
        String[] program = new String[]{"mov a 5", "inc a", "dec a", "dec a", "jnz a -1", "inc a"};
        Map<String, Integer> out = new HashMap<>();
        out.put("a", 1);
        assertEquals(out, SimpleAssembler.interpret(program));
    }

    @Test
    public void simple_2() {
        String[] program = new String[]{"mov a -10", "mov b a", "inc a", "dec b", "jnz a -2"};
        Map<String, Integer> out = new HashMap<>();
        out.put("a", 0);
        out.put("b", -20);
        assertEquals(out, SimpleAssembler.interpret(program));
    }
}
