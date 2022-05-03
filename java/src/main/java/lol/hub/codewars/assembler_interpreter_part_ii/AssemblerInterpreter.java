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
                case "mov" -> registers.put(inst[1], resolve(inst[2], registers));
                case "inc" -> registers.put(inst[1], registers.getOrDefault(inst[1], 0) + 1);
                case "dec" -> registers.put(inst[1], registers.getOrDefault(inst[1], 0) - 1);
                case "add" -> registers.put(inst[1], registers.getOrDefault(inst[1], 0) + resolve(inst[2], registers));
                case "sub" -> registers.put(inst[1], registers.getOrDefault(inst[1], 0) - resolve(inst[2], registers));
                case "mul" -> registers.put(inst[1], registers.getOrDefault(inst[1], 0) * resolve(inst[2], registers));
                case "div" -> registers.put(inst[1], registers.getOrDefault(inst[1], 0) / resolve(inst[2], registers));
                case "jmp" -> pointer = labels.get(inst[1]) - 1;
                case "cmp" -> {
                    cmpX = resolve(inst[1], registers);
                    cmpY = resolve(inst[2], registers);
                    cmp = true;
                }
                case "jne" -> {
                    if (cmp && cmpX != cmpY) pointer = labels.get(inst[1]) - 1;
                }
                case "je" -> {
                    if (cmp && cmpX == cmpY) pointer = labels.get(inst[1]) - 1;
                }
                case "jge" -> {
                    if (cmp && cmpX >= cmpY) pointer = labels.get(inst[1]) - 1;
                }
                case "jg" -> {
                    if (cmp && cmpX > cmpY) pointer = labels.get(inst[1]) - 1;
                }
                case "jle" -> {
                    if (cmp && cmpX <= cmpY) pointer = labels.get(inst[1]) - 1;
                }
                case "jl" -> {
                    if (cmp && cmpX < cmpY) pointer = labels.get(inst[1]) - 1;
                }
                case "call" -> {
                    callStack.add(pointer);
                    pointer = labels.get(inst[1]);
                }
                case "ret" -> pointer = callStack.remove(callStack.size() - 1);
                case "msg" -> message = constructMessage(inst, registers);
                case "end" -> end = true;
                default -> {
                    if (!labels.containsValue(pointer)) System.err.println("unknown instruction: " + inst[0]);
                }
            }
            if (end) break;
            pointer++;
        }
        System.out.println("-------------result-------------");
        System.out.println("    " + message);
        return end ? message : defaultOutput;
    }

    private static String constructMessage(String[] inst, Map<String, Integer> registers) {
        String rawArgs = String.join(" ", Arrays.copyOfRange(inst, 1, inst.length));
        StringBuilder message = new StringBuilder();
        var escaped = false;
        for (char c : rawArgs.toCharArray()) {
            if (c == '\'') {
                escaped = !escaped;
                continue;
            }
            if (escaped) message.append(c);
            else {
                if (c == ',' || c == ' ') continue;
                message.append(registers.getOrDefault(""+c, 0));
            }
        }
        return message.toString();
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
