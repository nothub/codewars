package lol.hub.codewars.esoteric_language_poohbear_interpreter;

import java.util.HashMap;
import java.util.Map;

public class Memory {

    private final Map<Integer, Byte> cells = new HashMap<>();

    private int pointer;
    private int clipboard;

    public void left() {
        pointer--;
    }

    public void right() {
        pointer++;
    }

    public int read() {
        return Byte.toUnsignedInt(cells.getOrDefault(pointer, (byte) 0));
    }

    public void write(int value) {
        value = ((value % 256) + 256) % 256;
        if (value == 0) return;
        cells.put(pointer, (byte) value);
    }

    public void copy() {
        clipboard = read();
    }

    public void paste() {
        write(clipboard);
    }

}
