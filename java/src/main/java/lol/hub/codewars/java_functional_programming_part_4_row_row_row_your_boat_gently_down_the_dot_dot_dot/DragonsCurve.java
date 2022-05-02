package lol.hub.codewars.java_functional_programming_part_4_row_row_row_your_boat_gently_down_the_dot_dot_dot;

import java.util.function.IntFunction;
import java.util.function.IntPredicate;

/**
 * @see <a href="https://www.codewars.com/kata/54ac045d35adf4e6e2000e43">codewars.com</a>
 */
public class DragonsCurve {

/*

We're going to be calculating the Dragon's Curve (and a few metrics about it) using Java streams.
(Pre-existing kata: http://www.codewars.com/kata/dragons-curve).

The Dragon's Curve is a fractal, the path of which can be easily determined programmatically.
    Start with the string "Fa"
    Replace all "a" with "aRbFR" and all "b" with "LFaLb"

That is (spaces added for clarity):
    Iteration 0: Fa
    Iteration 1: Fa -> F aRbFR
    Iteration 2: FaRbFR -> F aRbFR R LFaLb FR

You will do this "n" times. Then, remove all "a" and "b".
The remaining string will contain only FRL (the commands go Forward, turn Right, and turn Left).
On a grid, tracing the series of commands results in the Dragon's Curve.

You will create a series of streams that create the Dragon's Curve, then analyze the Dragon's Curve.

First, you'll want to create a mapping IntFunction to turn 'a' and 'b' into "aRbFR" and "LFaLb".
The tests count how many times the mapFunction is used during createCurve,
so make sure to actually use your mapFunction and don't just implement a different solution
(that's why mapFunction is public; don't make it private).

You'll also want to create a filterFactory method to generate IntPredicate functions.
The factory will accept a char (to filter) and a boolean (whether we are keeping that char or excluding that char)
and return an IntPredicate that filters appropriately.

Finally, you need a howMany function that takes a char and a Dragon's Curve String and returns how many
instances of char are in the curve (hint: use the filterFactory you just made).
IntFunction/IntPredicate? I'm working with Strings and Characters!

Funny thing about Java: all Strings are CharSequences (close cousin to char[]).
And all chars are ints (don't believe me? 'a' == 97. Try it out.) So, when Oracle was deciding what
special functions to include by default in Java 8, instead of adding char-specific functions
--like they did for the other primitives-- they assume you'll be using the int-specific functions.

What you do is use the String function chars() (e.g., "Fa".chars()) to generate an IntStream.
You can then use this IntStream like you would any other, and map, filter, and collect to your heart's content.
But, since you're playing with ints, you do need to make sure you're converting your
ints back to chars when needed ('a' == 97 might be true, but "" + 97 is still "97" and not "a").

*/

    public IntFunction<String> mapFunction = c -> "" + c; //Make the function; map the chars to Strings
    //a -> aRbFR, b -> LFaLb, otherwise -> itself

    /**
     * Make the curve; stream the chars repeatedly (starting with Fa) through the mapFunction n times
     * Then remove the a and b (createFilter function is useful for that)
     */
    public String createCurve(int n) {
        "Fa".chars(); //That's an IntStream with 'F' and 'a' ready to be acted upon
        return "Fa";
    }

    /**
     * How many of the specified char are in the given curve?
     * Hint: createFilter could be useful for this
     */
    public long howMany(char c, String curve) {
        return 4L; //Determined by die roll; guaranteed to be random
    }

    /**
     * Create a predicate to filter the specified char; keep or remove based on keep variable
     */
    public IntPredicate createFilter(char filterWhat, boolean keep) {
        return null; //Dat predicate
    }
}
