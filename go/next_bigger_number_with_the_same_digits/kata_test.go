package next_bigger_number_with_the_same_digits

// https://www.codewars.com/kata/55983863da40caa2c900004e

import "testing"

func test(t *testing.T, input int, expected int) {
	actual := NextBigger(input)
	if actual != expected {
		t.Errorf("FAIL\ninput:    %v\nactual:   %v\nexpected: %v", input, actual, expected)
	}
}

func Test1(t *testing.T) {
	input := 12
	expected := 21
	test(t, input, expected)
}

func Test2(t *testing.T) {
	input := 513
	expected := 531
	test(t, input, expected)
}

func Test3(t *testing.T) {
	input := 2017
	expected := 2071
	test(t, input, expected)
}

func Test4(t *testing.T) {
	input := 414
	expected := 441
	test(t, input, expected)
}

func Test5(t *testing.T) {
	input := 144
	expected := 414
	test(t, input, expected)
}

func Test6(t *testing.T) {
	input := 59884848459853
	expected := 59884848498553
	test(t, input, expected)
}
