package lol.hub.codewars.esoteric_language_poohbear_interpreter;

import java.util.HashMap;
import java.util.Map;

public class Memory {

    private final Map<Integer, Byte> cells = new HashMap<>();
    private final StringBuilder buffer = new StringBuilder();

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

    public void write(double value) {
        value = Math.min(Integer.MAX_VALUE, value);
        value = Math.max(Integer.MIN_VALUE, value);
        write((int) value);
    }

    public void copy() {
        clipboard = read();
    }

    public void paste() {
        write(clipboard);
    }

    public int clipboard() {
        return clipboard;
    }

    public void jumpLeft() {
        // If you come to an E in the code and the current cell is not 0, jump back to the corresponding W.
        if (read() == 0) return;
        // Jumps back to the matching [ character, if the value under the pointer is 1
        //func jmpb(prog *prog, t *tape) {
        //	if t.read() == true {
        //		level := 0
        //		for i := prog.pointer; i >= 0; i-- {
        //			if prog.code[i] == JMPB {
        //				level++
        //			} else if prog.code[i] == JMPP {
        //				level--
        //				if level == 0 {
        //					prog.pointer = i - 1
        //					return
        //				}
        //			}
        //		}
        //	}
        //}
    }

    public void jumpRight() {
        if (read() == 1) return;
        var level = 0;

        //		for i := prog.pointer; i < len(prog.code); i++ {
        //			if prog.code[i] == JMPP {
        //				level++
        //			} else if prog.code[i] == JMPB {
        //				level--
        //				if level == 0 {
        //					prog.pointer = i - 1
        //					return
        //				}
        //			}
        //		}
    }

    public void appendBuffer(String s) {
        buffer.append(s);
    }

    public String printBuffer() {
        return buffer.toString();
    }
}
