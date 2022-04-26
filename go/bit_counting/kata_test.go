package bit_counting

import "testing"

func Test1(t *testing.T) {
	if CountBits(0) != 0 {
		t.Errorf("test failed")
	}
}

func Test2(t *testing.T) {
	if CountBits(4) != 1 {
		t.Errorf("test failed")
	}
}

func Test3(t *testing.T) {
	if CountBits(7) != 3 {
		t.Errorf("test failed")
	}
}

func Test4(t *testing.T) {
	if CountBits(9) != 2 {
		t.Errorf("test failed")
	}
}

func Test5(t *testing.T) {
	if CountBits(10) != 2 {
		t.Errorf("test failed")
	}
}
