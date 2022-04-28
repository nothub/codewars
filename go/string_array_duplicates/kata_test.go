package string_array_duplicates

// https://www.codewars.com/kata/59f08f89a5e129c543000069

import (
	"testing"
)

func assertSame[T string | int](a []T, b []T) bool {
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

func test(t *testing.T, input []string, expected []string) {
	actual := Dup(input)
	if !assertSame(actual, expected) {
		t.Errorf("FAIL\ninput:    %s\nactual:   %s\nexpected: %s", input, actual, expected)
	}
}

func Test1(t *testing.T) {
	input := []string{"ccooddddddewwwaaaaarrrrsssss", "piccaninny", "hubbubbubboo"}
	expected := []string{"codewars", "picaniny", "hubububo"}
	test(t, input, expected)
}

func Test2(t *testing.T) {
	input := []string{"abracadabra", "allottee", "assessee"}
	expected := []string{"abracadabra", "alote", "asese"}
	test(t, input, expected)
}

func Test3(t *testing.T) {
	input := []string{"kelless", "keenness"}
	expected := []string{"keles", "kenes"}
	test(t, input, expected)
}
