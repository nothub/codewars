package lol.hub.codewars.simple_assembler_interpreter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://www.codewars.com/kata/58e24788e24ddee28e000053">codewars.com</a>
 */
public class SimpleAssembler {
    private static final Map<String, Integer> registers = new HashMap<>();

    public static Map<String, Integer> interpret(String[] program) {
        System.out.println(Arrays.toString(program));
        System.out.println("-----");
        for (int i = 0; i < program.length; i++) {
            System.out.println("index: " + i);
            System.out.println("instr: " + program[i]);
            String[] inst = program[i].split(" ");
            switch (inst[0]) {
                case "mov":
                    // mov x y - copies y (either a constant value or the content of a register) into register x
                    registers.put(inst[1], resolve(inst[2]));
                    break;
                case "inc":
                    // inc x - increases the content of the register x by one
                    registers.put(inst[1], registers.getOrDefault(inst[1], 0) + 1);
                    break;
                case "dec":
                    // dec x - decreases the content of the register x by one
                    registers.put(inst[1], registers.getOrDefault(inst[1], 0) - 1);
                    break;
                case "jnz":
                    // jnz x y - jumps to an instruction y steps away (positive means forward, negative means backward, y can be a register or a constant), but only if x (a constant or a register) is not zero
                    int x = resolve(inst[1]);
                    if (x == 0) break;
                    int y = resolve(inst[2]);
                    System.out.println("jumping " + y);
                    i = (i - 1) + y;
                    break;
                default:
                    throw new IllegalStateException();
            }
            System.out.println(registers);
            System.out.println("-----");
        }
        return registers;
    }

    private static int resolve(String s) {
        if (isNumber(s)) return Integer.parseInt(s);
        else return registers.getOrDefault(s, 0);
    }

    static boolean isNumber(String value) {
        return value.matches("^-?[0-9]+$");
    }
}
