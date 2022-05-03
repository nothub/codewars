package lol.hub.codewars.codewars_style_ranking_system;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void test0() {
        assertEquals(0, new User().progress);
        assertEquals(-8, new User().rank);
    }

    @Test
    public void test1() {
        User user = new User();
        user.incProgress(-7);
        assertEquals(10, user.progress);
        user.incProgress(-5);
        assertEquals(0, user.progress);
        assertEquals(-7, user.rank);
    }

    @Test
    public void test2() {
        //If a user ranked -8 completes an activity ranked -7 they will receive 10 progress
        User user = new User();
        user.incProgress(-7);
        assertEquals(10, user.progress);
        assertEquals(-8, user.rank);
    }

    @Test
    public void test3() {
        //If a user ranked -8 completes an activity ranked -6 they will receive 40 progress
        User user = new User();
        user.incProgress(-6);
        assertEquals(40, user.progress);
        assertEquals(-8, user.rank);
    }

    @Test
    public void test4() {
        //If a user ranked -8 completes an activity ranked -5 they will receive 90 progress
        User user = new User();
        user.incProgress(-5);
        assertEquals(90, user.progress);
        assertEquals(-8, user.rank);
    }

    @Test
    public void test5() {
        //If a user ranked -8 completes an activity ranked -4 they will receive 160 progress, resulting in the user being upgraded to rank -7 and having earned 60 progress towards their next rank
        User user = new User();
        user.incProgress(-4);
        assertEquals(60, user.progress);
        assertEquals(-7, user.rank);
    }

    @Test
    public void test6() {
        //If a user ranked -1 completes an activity ranked 1 they will receive 10 progress (remember, zero rank is ignored)
        User user = new User();
        user.rank = -1;
        user.incProgress(1);
        assertEquals(10, user.progress);
        assertEquals(-1, user.rank);
    }

    @Test
    public void test7() {
        User user = new User();

        // rank:  -8
        // prog:   0
        // kata:  -8 -> +3 -> 3
        user.incProgress(-8);
        assertEquals(-8, user.rank);
        assertEquals(3, user.progress);

        // rank:  -8
        // prog:   3
        // kata:  -7 -> +10 -> 13
        user.incProgress(-7);
        assertEquals(-8, user.rank);
        assertEquals(13, user.progress);

        // rank:  -8
        // prog:  13
        // kata:  -6 -> +40 -> 53
        user.incProgress(-6);
        assertEquals(-8, user.rank);
        assertEquals(53, user.progress);

        // rank:  -8
        // prog:  53
        // kata:  -5 -> +90 -> 143
        user.incProgress(-5);
        assertEquals(-7, user.rank);
        assertEquals(43, user.progress);

        // rank:  -7
        // prog:  43
        // kata:  -4 -> +90 -> 133
        user.incProgress(-4);
        assertEquals(-6, user.rank);
        assertEquals(33, user.progress);

        // rank:  -6
        // prog:  33
        // kata:  -8 -> +0 -> 33
        user.incProgress(-8);
        assertEquals(-6, user.rank);
        assertEquals(33, user.progress);

        // rank:  -6
        // prog:  33
        // kata:   1 -> +360 -> 393
        user.incProgress(1);
        assertEquals(-3, user.rank);
        assertEquals(93, user.progress);

        // rank:  -3
        // prog:  93
        // kata:   1 -> +90 -> 183
        user.incProgress(1);
        assertEquals(-2, user.rank);
        assertEquals(83, user.progress);

        // rank:  -2
        // prog:  83
        // kata:   1 -> +40 -> 123
        user.incProgress(1);
        assertEquals(-1, user.rank);
        assertEquals(23, user.progress);

        // rank:  -1
        // prog:  23
        // kata:   1 -> +10 -> 33
        user.incProgress(1);
        assertEquals(-1, user.rank);
        assertEquals(33, user.progress);

        // rank:  -1
        // prog:  33
        // kata:   1 -> +10 -> 43
        user.incProgress(1);
        assertEquals(-1, user.rank);
        assertEquals(43, user.progress);

        // rank:  -1
        // prog:  43
        // kata:   2 -> +40 -> 83
        user.incProgress(2);
        assertEquals(-1, user.rank);
        assertEquals(83, user.progress);

        // rank:  -1
        // prog:  83
        // kata:   2 -> +40 -> 123
        user.incProgress(2);
        assertEquals(1, user.rank);
        assertEquals(23, user.progress);

        // rank:   1
        // prog:  23
        // kata:  -1 -> +1 -> 24
        user.incProgress(-1);
        assertEquals(24, user.progress);
    }

    @Test
    public void test8() {
        User user = new User();

        user.rank = -1;
        user.progress = 80;

        user.incProgress(2);

        assertEquals(1, user.rank);
        assertEquals(20, user.progress);

        user.incProgress(-1);
        assertEquals(21, user.progress);
    }

}
