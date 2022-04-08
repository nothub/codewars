package lol.hub.codewars.convert_string_to_camel_case;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testSomeUnderscoreLowerStart() {
        assertEquals("theStealthWarrior", Solution.toCamelCase("the_Stealth_Warrior"));
    }

    @Test
    public void testSomeDashLowerStart() {
        assertEquals("theStealthWarrior", Solution.toCamelCase("the-Stealth-Warrior"));
    }

    @Test
    public void test1() {
        assertEquals("YouHaveChosenToTranslateThisKataForYourConvenienceWeHaveProvidedTheExistingTestCasesUsedForTheLanguageThatYouHaveAlreadyCompletedAsWellAsAllOfTheOtherRelatedFields", Solution.toCamelCase("You_have_chosen_to_translate_this_kata_For_your_convenience_we_have_provided_the_existing_test_cases_used_for_the_language_that_you_have_already_completed_as_well_as_all_of_the_other_related_fields"));
    }

    @Test
    public void test2() {
        assertEquals("YellowDesertNorthSamuraiUpNorth", Solution.toCamelCase("Yellow_desert_north_Samurai_up_north"));
    }

    @Test
    public void test3() {
        assertEquals("YellowDesertNorthSamuraiUpNorth", Solution.toCamelCase("Yellow_desert_north_Samurai_up_north-"));
    }
}
