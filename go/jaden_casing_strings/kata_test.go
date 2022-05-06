package jaden_casing_strings

// https://www.codewars.com/kata/5390bac347d09b7da40006f6

import "testing"

func test(t *testing.T, input string, expected string) {
	actual := ToJadenCase(input)
	if actual != expected {
		t.Errorf("FAIL\ninput:    %s\nactual:   %s\nexpected: %s", input, actual, expected)
	}
}

func TestHelloWorld(t *testing.T) {
	input := "All the rules in this world were made by someone no smarter than you. So make your own."
	expected := "All The Rules In This World Were Made By Someone No Smarter Than You. So Make Your Own."
	test(t, input, expected)
}
