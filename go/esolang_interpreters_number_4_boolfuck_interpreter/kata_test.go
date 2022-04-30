package esolang_interpreters_number_4_boolfuck_interpreter

// https://www.codewars.com/kata/5861487fdb20cff3ab000030

import "testing"

func assertSame(a []bool, b []bool) bool {
	if a == nil && b == nil {
		return true
	}
	if a == nil || b == nil {
		return false
	}
	if len(a) != len(b) {
		return false
	}
	for i := 0; i < len(a); i++ {
		if a[i] != b[i] {
			return false
		}
	}
	return true
}

func test(t *testing.T, code string, args string, expected string) {
	actual := Boolfuck(code, args)
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
	testPadSize(t, 0, 0)
	testPadSize(t, 1, 8)
	testPadSize(t, 2, 8)
	testPadSize(t, 7, 8)
	testPadSize(t, 8, 8)
	testPadSize(t, 9, 16)
	testPadSize(t, 10, 16)
	testPadSize(t, 15, 16)
	testPadSize(t, 16, 16)
	testPadSize(t, 17, 24)
	testPadSize(t, 18, 24)
}

func TestBytesToBits(t *testing.T) {
	// 'a' -> [ 1, 0, 0, 0, 0, 1, 1, 0 ] (little-endian order)
	actual := toBits(byte('a'))
	expected := []bool{true, false, false, false, false, true, true, false}
	if !assertSame(actual, expected) {
		t.Errorf("FAIL\nactual:   %v\nexpected: %v", actual, expected)
	}
}

func TestBitsToByte(t *testing.T) {
	// 'a' -> [ 1, 0, 0, 0, 0, 1, 1, 0 ] (little-endian order)
	actual := toByte([]bool{true, false, false, false, false, true, true, false})
	expected := byte('a')
	if actual != expected {
		t.Errorf("FAIL\nactual:   %v\nexpected: %v", actual, expected)
	}
}

func testPadSize(t *testing.T, input int, expected int) {
	actual := paddedSize(make([]bool, input))
	if actual != expected {
		t.Errorf("FAIL\ninput:    %v\nactual:   %v\nexpected: %v", input, actual, expected)
	}
}

func TestTrimFrontRune(t *testing.T) {
	r, s := behead("asdf")
	if r != "a" {
		t.Errorf("FAIL\n")
	}
	if s != "sdf" {
		t.Errorf("FAIL\n")
	}

	r, s = behead("a")
	if r != "a" {
		t.Errorf("FAIL\n")
	}
	if s != "" {
		t.Errorf("FAIL\n")
	}

	r, s = behead("")
	if r != "" {
		t.Errorf("FAIL\n")
	}
	if s != "" {
		t.Errorf("FAIL\n")
	}
}

func TestDebug(t *testing.T) {
	input := ",,,,,,,, ,,,,,,,, ,,,,,,,, ,,,,,,,,"
	args := "axy"
	expected := ""
	test(t, input, args, expected)
}
