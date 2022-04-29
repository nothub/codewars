package esolang_interpreters_number_4_boolfuck_interpreter

// https://www.codewars.com/kata/5861487fdb20cff3ab000030

import "testing"

func test(t *testing.T, code string, args string, expected string) {
	actual := Boolfuck(code, "")
	if actual != expected {
		t.Errorf("FAIL\ncode:     %s\nargs:     %s\nactual:   %s\nexpected: %s", code, args, actual, expected)
	}
}

func TestHelloWorld(t *testing.T) {
	// Your interpreter did not work with the code example provided on the official website
	input := ";;;+;+;;+;+;\n+;+;+;+;;+;;+;\n;;+;;+;+;;+;\n;;+;;+;+;;+;\n+;;;;+;+;;+;\n;;+;;+;+;+;;\n;;;;;+;+;;\n+;;;+;+;;;+;\n+;;;;+;+;;+;\n;+;+;;+;;;+;\n;;+;;+;+;;+;\n;;+;+;;+;;+;\n+;+;;;;+;+;;\n;+;+;+;"
	args := ""
	expected := "Hello, world!\n"
	test(t, input, args, expected)
}

func TestCatFF(t *testing.T) {
	// should echo until byte(255) encountered
	input := ">,>,>,>,>,>,>,>,<<<<<<<[>]+<[+<]>>>>>>>>>[+]+<<<<<<<<+[>+]<[<]>>>>>>>>>[+<<<<<<<<[>]+<[+<]>>>>>>>>>+<<<<<<<<+[>+]<[<]>>>>>>>>>[+]<<<<<<<<;>;>;>;>;>;>;>;<<<<<<<,>,>,>,>,>,>,>,<<<<<<<[>]+<[+<]>>>>>>>>>[+]+<<<<<<<<+[>+]<[<]>>>>>>>>>]<[+<]"
	args := "Codewars\xff"
	expected := "Codewars"
	test(t, input, args, expected)
}

func TestCat00(t *testing.T) {
	// should echo until byte(0) encountered
	input := ">,>,>,>,>,>,>,>,>+<<<<<<<<+[>+]<[<]>>>>>>>>>[+<<<<<<<<[>]+<[+<]>;>;>;>;>;>;>;>;>+<<<<<<<<+[>+]<[<]>>>>>>>>>[+<<<<<<<<[>]+<[+<]>>>>>>>>>+<<<<<<<<+[>+]<[<]>>>>>>>>>[+]+<<<<<<<<+[>+]<[<]>>>>>>>>>]<[+<]>,>,>,>,>,>,>,>,>+<<<<<<<<+[>+]<[<]>>>>>>>>>]<[+<]"
	args := "Codewars\x00"
	expected := "Codewars"
	test(t, input, args, expected)
}

func TestMultiply(t *testing.T) {
	// should multiply two numbers. byte(8)*byte(9)=byte(72)
	input := ">,>,>,>,>,>,>,>,>>,>,>,>,>,>,>,>,<<<<<<<<+<<<<<<<<+[>+]<[<]>>>>>>>>>[+<<<<<<<<[>]+<[+<]>>>>>>>>>>>>>>>>>>+<<<<<<<<+[>+]<[<]>>>>>>>>>[+<<<<<<<<[>]+<[+<]>>>>>>>>>+<<<<<<<<+[>+]<[<]>>>>>>>>>[+]>[>]+<[+<]>>>>>>>>>[+]>[>]+<[+<]>>>>>>>>>[+]<<<<<<<<<<<<<<<<<<+<<<<<<<<+[>+]<[<]>>>>>>>>>]<[+<]>>>>>>>>>>>>>>>>>>>>>>>>>>>+<<<<<<<<+[>+]<[<]>>>>>>>>>[+<<<<<<<<[>]+<[+<]>>>>>>>>>+<<<<<<<<+[>+]<[<]>>>>>>>>>[+]<<<<<<<<<<<<<<<<<<<<<<<<<<[>]+<[+<]>>>>>>>>>[+]>>>>>>>>>>>>>>>>>>+<<<<<<<<+[>+]<[<]>>>>>>>>>]<[+<]<<<<<<<<<<<<<<<<<<+<<<<<<<<+[>+]<[<]>>>>>>>>>[+]+<<<<<<<<+[>+]<[<]>>>>>>>>>]<[+<]>>>>>>>>>>>>>>>>>>>;>;>;>;>;>;>;>;<<<<<<<<"
	args := "\x08\x09"
	expected := "\x48"
	test(t, input, args, expected)
}

func TestPadding(t *testing.T) {
	testPadding(t, 0, 0)
	testPadding(t, 1, 8)
	testPadding(t, 2, 8)
	testPadding(t, 7, 8)
	testPadding(t, 8, 8)
	testPadding(t, 9, 16)
	testPadding(t, 10, 16)
	testPadding(t, 15, 16)
	testPadding(t, 16, 16)
	testPadding(t, 17, 24)
	testPadding(t, 18, 24)
}

func testPadding(t *testing.T, input int, expected int) {
	actual := paddedSize(make([]bool, input))
	if actual != expected {
		t.Errorf("FAIL\ninput:    %v\nactual:   %v\nexpected: %v", input, actual, expected)
	}
}
