package twice_as_old

import "testing"

func assert(t *testing.T, expected int, actual int) {
	if actual != expected {
		t.Errorf("actual: %v expected: %v", actual, expected)
	}
}

func Test1(t *testing.T) {
	assert(t, 22, TwiceAsOld(36, 7))
}

func Test2(t *testing.T) {
	assert(t, 5, TwiceAsOld(55, 30))
}

func Test3(t *testing.T) {
	assert(t, 0, TwiceAsOld(42, 21))
}

func Test4(t *testing.T) {
	assert(t, 20, TwiceAsOld(22, 1))
}

func Test5(t *testing.T) {
	assert(t, 29, TwiceAsOld(29, 0))
}
