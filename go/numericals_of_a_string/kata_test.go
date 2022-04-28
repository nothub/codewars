package numericals_of_a_string

// https://www.codewars.com/kata/5b4070144d7d8bbfe7000001

import "testing"

func test(t *testing.T, input string, expected string) {
	actual := Numericals(input)
	if actual != expected {
		t.Errorf("FAIL\ninput:    %s\nactual:   %s\nexpected: %s", input, actual, expected)
	}
}

func Test1(t *testing.T) {
	input := "Hello, World!"
	expected := "1112111121311"
	test(t, input, expected)
}

func Test2(t *testing.T) {
	input := "Inconceivable!"
	expected := "11112211111121"
	test(t, input, expected)
}

func Test3(t *testing.T) {
	input := "hello hello"
	expected := "11121122342"
	test(t, input, expected)
}

func Test4(t *testing.T) {
	input := "Hello"
	expected := "11121"
	test(t, input, expected)
}

func Test5(t *testing.T) {
	input := "aaaaaaaaaaaa"
	expected := "123456789101112"
	test(t, input, expected)
}
