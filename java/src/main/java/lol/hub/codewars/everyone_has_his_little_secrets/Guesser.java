package lol.hub.codewars.everyone_has_his_little_secrets;

import java.lang.reflect.Field;

/**
 * @see <a href="https://www.codewars.com/kata/546d1328bed2e1e07a000f89">codewars.com</a>
 */
// 😈
public class Guesser {
    public void guess() {
        for (Field field : LittleClass.class.getDeclaredFields()) {
            System.out.println(field.toGenericString());
            field.setAccessible(true);
            try {
                LittleClass.isMySecret((String) field.get(null));
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
