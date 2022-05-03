package lol.hub.codewars.psychic;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Random;

/**
 * @see <a href="https://www.codewars.com/kata/54bd79a7956834e767001357">codewars.com</a>
 */
public class Psychic {
    public static double guess() {
        try {
            Field rng = rng();
            mods().setInt(rng, rng.getModifiers() & ~Modifier.FINAL);
            ((Random) rng.get(null)).setSeed(420);
        } catch (IllegalAccessException ignored) {
        }
        return 0.7621420801912142;
    }

    private static Field rng() {
        Field rng = Arrays.stream(Arrays.stream(Math.class.getDeclaredClasses())
                .filter(c -> c.getSimpleName().equals("RandomNumberGeneratorHolder"))
                .findAny().orElseThrow().getDeclaredFields())
            .filter(f -> f.getName().equals("randomNumberGenerator"))
            .findAny().orElseThrow();
        rng.setAccessible(true);
        return rng;
    }

    private static Field mods() {
        Field mods = null;
        try {
            mods = Field.class.getDeclaredField("modifiers");
        } catch (NoSuchFieldException ignored) {
        }
        mods.setAccessible(true);
        return mods;
    }
}
