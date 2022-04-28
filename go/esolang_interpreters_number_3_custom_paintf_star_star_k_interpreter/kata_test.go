package esolang_interpreters_number_3_custom_paintf_star_star_k_interpreter

// https://www.codewars.com/kata/5868a68ba44cfc763e00008d

import "testing"

func test(t *testing.T, code string, iterations, width, height int, expected string) {
	actual := Interpreter(code, iterations, width, height)
	if actual != expected {
		t.Errorf("\ncode:       %s\niterations: %v\nwidth:      %v\nheight:     %v\nactual:\n%s\nexpected:\n%s", code, iterations, width, height, actual, expected)
	}
}

func Test1(t *testing.T) {
	// Your interpreter should initialize all cells in the datagrid to 0
	code := "*e*e*e*es*es*ws*ws*w*w*w*n*n*n*ssss*s*s*s*"
	iterations := 0
	width := 6
	height := 9
	expected := "000000\r\n000000\r\n000000\r\n000000\r\n000000\r\n000000\r\n000000\r\n000000\r\n000000"
	test(t, code, iterations, width, height, expected)
}

func Test2(t *testing.T) {
	// Your interpreter should adhere to the number of iterations specified
	code := "*e*e*e*es*es*ws*ws*w*w*w*n*n*n*ssss*s*s*s*"
	iterations := 7
	width := 6
	height := 9
	expected := "111100\r\n000000\r\n000000\r\n000000\r\n000000\r\n000000\r\n000000\r\n000000\r\n000000"
	test(t, code, iterations, width, height, expected)
}

func Test3(t *testing.T) {
	// Your interpreter should traverse the 2D datagrid correctly
	code := "*e*e*e*es*es*ws*ws*w*w*w*n*n*n*ssss*s*s*s*"
	iterations := 19
	width := 6
	height := 9
	expected := "111100\r\n000010\r\n000001\r\n000010\r\n000100\r\n000000\r\n000000\r\n000000\r\n000000"
	test(t, code, iterations, width, height, expected)
}

func Test4(t *testing.T) {
	// Your interpreter should traverse the 2D datagrid correctly for all of the \"n\", \"e\", \"s\" and \"w\" commands
	code := "*e*e*e*es*es*ws*ws*w*w*w*n*n*n*ssss*s*s*s*"
	iterations := 42
	width := 6
	height := 9
	expected := "111100\r\n100010\r\n100001\r\n100010\r\n111100\r\n100000\r\n100000\r\n100000\r\n100000"
	test(t, code, iterations, width, height, expected)
}

func Test5(t *testing.T) {
	// Your interpreter should terminate normally and return a representation of the final state of the 2D datagrid when all commands have been considered from left to right even if the number of iterations specified have not been fully performed
	code := "*e*e*e*es*es*ws*ws*w*w*w*n*n*n*ssss*s*s*s*"
	iterations := 100
	width := 6
	height := 9
	expected := "111100\r\n100010\r\n100001\r\n100010\r\n111100\r\n100000\r\n100000\r\n100000\r\n100000"
	test(t, code, iterations, width, height, expected)
}

func Test6(t *testing.T) {
	// Your interpreter should exit the loop at the correct conditions
	code := "*[es*]"
	iterations := 1000
	width := 5
	height := 6
	expected := "01111\r\n11111\r\n11111\r\n11111\r\n11111\r\n11111"
	test(t, code, iterations, width, height, expected)
}

func Test7(t *testing.T) {
	// Your interpreter should should exhibit toroidal behaviour ;)
	code := "*[es*]"
	iterations := 37
	width := 5
	height := 6
	expected := "11000\r\n01100\r\n00110\r\n00011\r\n00001\r\n10000"
	test(t, code, iterations, width, height, expected)
}

func Test8(t *testing.T) {
	// Your interpreter should also work with nested loops
	code := "*[s[e]*]"
	iterations := 23
	width := 5
	height := 5
	expected := "11000\r\n10000\r\n10000\r\n10000\r\n10000"
	test(t, code, iterations, width, height, expected)
}

func Test9(t *testing.T) {
	// Your data grid should exhibit toroidal (wrapping) behaviour
	code := "eee*s*s*s*w*w*w*w*w*w*w*n*n*n*n*n*n*n*n*n*e*e*e*e*e*e*e*s*s*s*s*s*"
	iterations := 1000
	width := 8
	height := 10
	expected := "00011000\r\n00011000\r\n00011000\r\n11111111\r\n11111111\r\n00011000\r\n00011000\r\n00011000\r\n00011000\r\n00011000"
	test(t, code, iterations, width, height, expected)
}
