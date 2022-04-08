package lol.hub.codewars.valid_parentheses;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test1() {
        assertTrue(Solution.validParentheses("()"));
    }

    @Test
    public void test2() {
        assertFalse(Solution.validParentheses("())"));
    }

    @Test
    public void test3() {
        assertTrue(Solution.validParentheses("32423(sgsdg)"));
    }

    @Test
    public void test4() {
        assertFalse(Solution.validParentheses("(dsgdsg))2432"));
    }

    @Test
    public void test5() {
        assertTrue(Solution.validParentheses("adasdasfa"));
    }

    @Test
    public void test6() {
        assertFalse(Solution.validParentheses(")))(B(Nk((2)(/y))+(())(k"));
    }

    @Test
    public void test7() {
        assertFalse(Solution.validParentheses("())("));
    }

    @Test
    public void test8() {
        assertFalse(Solution.validParentheses("()()("));
    }
}
