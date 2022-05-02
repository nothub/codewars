package lol.hub.codewars.java_functional_programming_part_1_the_beginning;

import java.util.function.Function;

/**
 * @see <a href="https://www.codewars.com/kata/54a6b43e478d8ee14c000a5d">codewars.com</a>
 */
public class FunctionalProgramming {
    public static Function<Student, Boolean> f = s -> s.getFullName().equals("John Smith") && s.studentNumber.equals("js123");
}
