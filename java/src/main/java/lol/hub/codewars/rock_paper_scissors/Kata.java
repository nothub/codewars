package lol.hub.codewars.rock_paper_scissors;

import java.util.Map;

/**
 * @see <a href="https://www.codewars.com/kata/5672a98bdbdd995fad00000f">codewars.com</a>
 */
public class Kata {
    private static final Map<String, String> weapons = Map.of(
        "rock", "scissors",
        "scissors", "paper",
        "paper", "rock"
    );

    public static String rps(String p1, String p2) {
        if (p1.equals(p2)) return "Draw!";
        if (weapons.get(p1).equals(p2)) return "Player 1 won!";
        else return "Player 2 won!";
    }
}
