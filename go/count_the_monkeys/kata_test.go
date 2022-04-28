package count_the_monkeys

import "testing"

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

func Test1(t *testing.T) {
	if !assertSame(monkeyCount(1), []int{1}) {
		t.Errorf("test failed")
	}
}

func Test2(t *testing.T) {
	if !assertSame(monkeyCount(2), []int{1, 2}) {
		t.Errorf("test failed")
	}
}
func Test3(t *testing.T) {
	if !assertSame(monkeyCount(3), []int{1, 2, 3}) {
		t.Errorf("test failed")
	}
}
func Test4(t *testing.T) {
	if !assertSame(monkeyCount(4), []int{1, 2, 3, 4}) {
		t.Errorf("test failed")
	}
}
func Test5(t *testing.T) {
	if !assertSame(monkeyCount(5), []int{1, 2, 3, 4, 5}) {
		t.Errorf("test failed")
	}
}
func Test6(t *testing.T) {
	if !assertSame(monkeyCount(6), []int{1, 2, 3, 4, 5, 6}) {
		t.Errorf("test failed")
	}
}
func Test7(t *testing.T) {
	if !assertSame(monkeyCount(7), []int{1, 2, 3, 4, 5, 6, 7}) {
		t.Errorf("test failed")
	}
}
func Test8(t *testing.T) {
	if !assertSame(monkeyCount(8), []int{1, 2, 3, 4, 5, 6, 7, 8}) {
		t.Errorf("test failed")
	}
}
func Test9(t *testing.T) {
	if !assertSame(monkeyCount(9), []int{1, 2, 3, 4, 5, 6, 7, 8, 9}) {
		t.Errorf("test failed")
	}
}
func Test10(t *testing.T) {
	if !assertSame(monkeyCount(10), []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}) {
		t.Errorf("test failed")
	}
}
