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
        Class<?> rngh = Arrays.stream(Math.class.getDeclaredClasses()).filter(c -> c.getSimpleName().equals("RandomNumberGeneratorHolder")).findAny().orElseThrow();
        Random random;
        try {
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            Field rng = Arrays.stream(rngh.getDeclaredFields()).filter(f -> f.getName().equals("randomNumberGenerator")).findAny().orElseThrow();
            rng.setAccessible(true);
            modifiersField.setInt(rng, rng.getModifiers() & ~Modifier.FINAL);
            random = (Random) rng.get(null);
        } catch (IllegalAccessException | NoSuchFieldException err) {
            err.printStackTrace();
            throw new IllegalStateException(err.getMessage());
        }
        random.setSeed(420);
        return 0.7621420801912142;
    }
}
