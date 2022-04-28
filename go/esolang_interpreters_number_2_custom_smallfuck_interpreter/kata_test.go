package esolang_interpreters_number_2_custom_smallfuck_interpreter

// https://www.codewars.com/kata/58678d29dbca9a68d80000d7

import "testing"

func test(t *testing.T, code string, tape string, expected string) {
	actual := Interpreter(code, tape)
	if actual != expected {
		t.Errorf("FAIL\ncode:     %s\ntape:     %s\nactual:   %s\nexpected: %s", code, tape, actual, expected)
	}
}

func Test1(t *testing.T) {
	// Flips the leftmost cell of the tape
	code := "*"
	tape := "00101100"
	expected := "10101100"
	test(t, code, tape, expected)
}

func Test2(t *testing.T) {
	// Flips the second and third cell of the tape
	code := ">*>*"
	tape := "00101100"
	expected := "01001100"
	test(t, code, tape, expected)
}

func Test3(t *testing.T) {
	// Flips all the bits in the tape
	code := "*>*>*>*>*>*>*>*"
	tape := "00101100"
	expected := "11010011"
	test(t, code, tape, expected)
}

func Test4(t *testing.T) {
	// Flips all the bits that are initialized to 0
	code := "*>*>>*>>>*>*"
	tape := "00101100"
	expected := "11111111"
	test(t, code, tape, expected)
}

func Test5(t *testing.T) {
	// Goes somewhere to the right of the tape and then flips all bits that are initialized to 1, progressing leftwards through the tape
	code := ">>>>>*<*<<*"
	tape := "00101100"
	expected := "00000000"
	test(t, code, tape, expected)
}
