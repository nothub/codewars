package lol.hub.codewars.esoteric_language_poohbear_interpreter;

import java.util.concurrent.atomic.AtomicInteger;

public class Context {
    private final Memory memory;
    private final String[] commands;
    private final AtomicInteger pointer;
    private final String instruction;

    public Context(Memory memory, String[] commands, AtomicInteger pointer, String instruction) {
        this.memory = memory;
        this.commands = commands;
        this.pointer = pointer;
        this.instruction = instruction;
    }

    public Memory memory() {
        return memory;
    }

    public String[] commands() {
        return commands;
    }

    public AtomicInteger pointer() {
        return pointer;
    }

    public String instruction() {
        return instruction;
    }
}
