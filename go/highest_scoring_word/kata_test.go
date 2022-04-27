package highest_scoring_word

import "testing"

func test(t *testing.T, input string, expected string) {
	actual := High(input)
	if actual != expected {
		t.Errorf("FAIL\ninput:    %s\nactual:   %s\nexpected: %s", input, actual, expected)
	}
}

func Test1(t *testing.T) {
	input := "man i need a taxi up to ubud"
	expected := "taxi"
	test(t, input, expected)
}

func Test2(t *testing.T) {
	input := "what time are we climbing up the volcano"
	expected := "volcano"
	test(t, input, expected)
}

func Test3(t *testing.T) {
	input := "take me to semynak"
	expected := "semynak"
	test(t, input, expected)
}

func Test4(t *testing.T) {
	input := "aa b"
	expected := "aa"
	test(t, input, expected)
}

func Test5(t *testing.T) {
	input := "b aa"
	expected := "b"
	test(t, input, expected)
}

func Test6(t *testing.T) {
	input := "bb d"
	expected := "bb"
	test(t, input, expected)
}

func Test7(t *testing.T) {
	input := "d bb"
	expected := "d"
	test(t, input, expected)
}

func Test8(t *testing.T) {
	input := "aaa b"
	expected := "aaa"
	test(t, input, expected)
}
