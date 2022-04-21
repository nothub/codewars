package lol.hub.codewars.simple_assembler_interpreter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://www.codewars.com/kata/58e24788e24ddee28e000053">codewars.com</a>
 */
public class SimpleAssembler {
    public static Map<String, Integer> interpret(String[] program) {
        System.out.println(Arrays.toString(program));
        Map<String, Integer> registers = new HashMap<>();
        for (int i = 0; i < program.length; i++) {
            String[] inst = program[i].split(" ");
            switch (inst[0]) {
                case "mov":
                    registers.put(inst[1], resolve(inst[2], registers));
                    break;
                case "inc":
                    registers.put(inst[1], registers.getOrDefault(inst[1], 0) + 1);
                    break;
                case "dec":
                    registers.put(inst[1], registers.getOrDefault(inst[1], 0) - 1);
                    break;
                case "jnz":
                    if (resolve(inst[1], registers) != 0) i = (i - 1) + resolve(inst[2], registers);
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
        System.out.println(registers);
        return registers;
    }

    private static int resolve(String s, Map<String, Integer> registers) {
        if (isValue(s)) return Integer.parseInt(s);
        else return registers.getOrDefault(s, 0);
    }

    private static boolean isValue(String value) {
        return value.matches("^-?[0-9]+$");
    }
}
