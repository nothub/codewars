package lol.hub.codewars.assembler_interpreter_part_ii;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @see <a href="https://www.codewars.com/kata/58e61f3d8ff24f774400002c">codewars.com</a>
 */
public class AssemblerInterpreter {
    private static final String defaultOutput = null;
    private static final Pattern labelPattern = Pattern.compile("^([^ \\n]+):");
    private static final Set<String> instructions = Set.of("mov", "inc", "dec", "add", "sub", "mul", "div", "jmp", "cmp", "jne", "je", "jge", "jg", "jle", "jl", "call", "ret", "msg", "end");

    public static String interpret(final String input) {
        List<String> code = sanitize(input.split(System.lineSeparator()));

        System.out.println("--------------code--------------");
        System.out.println(String.join(System.lineSeparator(), code));
        System.out.println("--------------------------------");

        /* label: - (label = identifier + ":", an identifier being a string that does not match any other command).
        Jump commands and call are aimed to these labels positions in the program. */
        Map<String, Integer> labels = new HashMap<>();
        for (int i = 0; i < code.size(); i++) {
            String line = code.get(i);
            if (line.equals("msg")) continue;
            if (instructions.contains(line)) continue;
            Matcher matcher = labelPattern.matcher(line);
            if (matcher.matches()) {
                labels.put(matcher.group(1), i);
            }
        }

        List<Integer> callStack = new ArrayList<>();
        Map<String, Integer> registers = new HashMap<>();

        var cmp = false;
        var cmpX = 0;
        var cmpY = 0;

        var message = "";
        var end = false;

        int pointer = 0;
        while (pointer >= 0 && pointer < code.size()) {
            String[] inst = code.get(pointer).split(" ");
            switch (inst[0]) {

                /* mov x, y - copy y (either an integer or the value of a register) into register x. */
                case "mov" -> {
                    registers.put(inst[1], resolve(inst[2], registers));
                }

                /* inc x - increase the content of register x by one. */
                case "inc" -> {
                    registers.put(inst[1], registers.getOrDefault(inst[1], 0) + 1);
                }

                /* dec x - decrease the content of register x by one. */
                case "dec" -> {
                    registers.put(inst[1], registers.getOrDefault(inst[1], 0) - 1);
                }

                /* add x, y - add the content of the register x with y (either an integer or the value of a register) and stores the result in x (i.e. register[x] += y). */
                case "add" -> {
                    registers.put(inst[1], registers.getOrDefault(inst[1], 0) + resolve(inst[2], registers));
                }

                /* sub x, y - subtract y (either an integer or the value of a register) from the register x and stores the result in x (i.e. register[x] -= y). */
                case "sub" -> {
                    registers.put(inst[1], registers.getOrDefault(inst[1], 0) - resolve(inst[2], registers));
                }

                /* mul x, y - same with multiply (i.e. register[x] *= y). */
                case "mul" -> {
                    registers.put(inst[1], registers.getOrDefault(inst[1], 0) * resolve(inst[2], registers));
                }

                /* div x, y - same with integer division (i.e. register[x] /= y). */
                case "div" -> {
                    registers.put(inst[1], registers.getOrDefault(inst[1], 0) / resolve(inst[2], registers));
                }

                /* jmp lbl - jumps to the label lbl. */
                case "jmp" -> {
                    pointer = labels.get(inst[1]) - 1;
                }

                /* cmp x, y - compares x (either an integer or the value of a register)
                                   and y (either an integer or the value of a register).
                The result is used in the conditional jumps (jne, je, jge, jg, jle and jl) */
                case "cmp" -> {
                    cmpX = resolve(inst[1], registers);
                    cmpY = resolve(inst[2], registers);
                    cmp = true;
                }

                /* jne lbl - jump to the label lbl if the values of the previous cmp command were not equal. */
                case "jne" -> {
                    if (cmp && cmpX != cmpY) pointer = labels.get(inst[1]) - 1;
                }

                /* je lbl - jump to the label lbl if the values of the previous cmp command were equal. */
                case "je" -> {
                    if (cmp && cmpX == cmpY) pointer = labels.get(inst[1]) - 1;
                }

                /* jge lbl - jump to the label lbl if x was greater or equal than y in the previous cmp command. */
                case "jge" -> {
                    if (cmp && cmpX >= cmpY) pointer = labels.get(inst[1]) - 1;
                }

                /* jg lbl - jump to the label lbl if x was greater than y in the previous cmp command. */
                case "jg" -> {
                    if (cmp && cmpX > cmpY) pointer = labels.get(inst[1]) - 1;
                }

                /* jle lbl - jump to the label lbl if x was less or equal than y in the previous cmp command. */
                case "jle" -> {
                    if (cmp && cmpX <= cmpY) pointer = labels.get(inst[1]) - 1;
                }

                /* jl lbl - jump to the label lbl if x was less than y in the previous cmp command. */
                case "jl" -> {
                    if (cmp && cmpX < cmpY) pointer = labels.get(inst[1]) - 1;
                }

                /* call lbl - call to the subroutine identified by lbl. When a ret is found in a subroutine, the instruction pointer should return to the instruction next to this call command. */
                case "call" -> {
                    callStack.add(pointer);
                    pointer = labels.get(inst[1]);
                }

                /* ret - when a ret is found in a subroutine, the instruction pointer should return to the instruction that called the current function. */
                case "ret" -> {
                    pointer = callStack.remove(callStack.size() - 1);
                }

                /* msg 'Register: ', x - this instruction stores the output of the program. It may contain text strings (delimited by single quotes) and registers. The number of arguments isn't limited and will vary, depending on the program. */
                case "msg" -> {
                    message = String.join(", ", Arrays.copyOfRange(inst, 1, inst.length));
                }

                /* end - this instruction indicates that the program ends correctly, so the stored output is returned (if the program terminates without this instruction it should return the default output: see below). */
                case "end" -> {
                    end = true;
                }

                default -> {
                    if (!labels.containsValue(pointer)) System.err.println("unknown instruction: " + inst[0]);
                }
            }
            if (end) break;
            pointer++;
        }

        return end ? message : defaultOutput;
    }

    private static List<String> sanitize(String[] source) {
        return Arrays.stream(source).map(AssemblerInterpreter::sanitize).filter(s -> !s.isBlank()).toList();
    }

    private static String sanitize(String line) {
        line = line.replaceAll("\\t", " ") // tabs are spaces
            .replaceAll("[ ]{2,}", " ") // merge spaces
            .replaceAll(";.*", "") // strip comments
            .trim();
        if (!line.split(" ")[0].equals("msg")) {
            return line.replaceAll(", ", " "); // argument separators are spaces
        }
        return line;
    }

    private static int resolve(String s, Map<String, Integer> registers) {
        if (isValue(s)) return Integer.parseInt(s);
        else return registers.getOrDefault(s, 0);
    }

    private static boolean isValue(String value) {
        return value.matches("^-?[0-9]+$");
    }
}
