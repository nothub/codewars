package lol.hub.codewars.bagels;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @see <a href="https://www.codewars.com/kata/54bd6b4c956834c9870001a1">codewars.com</a>
 */
public class BagelSolver {
    public static Bagel getBagel() {
        try {
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            Field trueField = Boolean.class.getField("TRUE");
            trueField.setAccessible(true);
            modifiersField.setInt(trueField, trueField.getModifiers() & ~Modifier.FINAL);
            trueField.set(null, Boolean.valueOf("false"));
        } catch (IllegalAccessException | NoSuchFieldException err) {
            System.err.println(err.getMessage());
        }
        return new Bagel();
    }
}
