package simple_assembler_interpreter

// https://www.codewars.com/kata/58e24788e24ddee28e000053

import "testing"

func assertSame(a map[string]int, b map[string]int) bool {
	if a == nil && b == nil {
		return true
	}
	if a == nil || b == nil {
		return false
	}
	if len(a) != len(b) {
		return false
	}
	for k := range a {
		if a[k] != b[k] {
			return false
		}
	}
	return true
}

func test(t *testing.T, input []string, expected map[string]int) {
	actual := SimpleAssembler(input)
	if !assertSame(actual, expected) {
		t.Errorf("FAIL\ninput:    %v\nactual:   %v\nexpected: %v", input, actual, expected)
	}
}

func Test1(t *testing.T) {
	input := []string{"mov a 5", "inc a", "dec a", "dec a", "jnz a -1", "inc a"}
	expected := map[string]int{"a": 1}
	test(t, input, expected)
}

func Test2(t *testing.T) {
	input := []string{"mov a -10", "mov b a", "inc a", "dec b", "jnz a -2"}
	expected := map[string]int{"a": 0, "b": -20}
	test(t, input, expected)
}
