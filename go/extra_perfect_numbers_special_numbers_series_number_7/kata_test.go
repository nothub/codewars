package extra_perfect_numbers_special_numbers_series_number_7

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

func Test3(t *testing.T) {
	if !assertSame(ExtraPerfect(3), []int{1, 3}) {
		t.Errorf("test failed")
	}
}

func Test5(t *testing.T) {
	if !assertSame(ExtraPerfect(5), []int{1, 3, 5}) {
		t.Errorf("test failed")
	}
}

func Test7(t *testing.T) {
	if !assertSame(ExtraPerfect(7), []int{1, 3, 5, 7}) {
		t.Errorf("test failed")
	}
}

func Test28(t *testing.T) {
	if !assertSame(ExtraPerfect(28), []int{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27}) {
		t.Errorf("test failed")
	}
}

func Test39(t *testing.T) {
	if !assertSame(ExtraPerfect(39), []int{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39}) {
		t.Errorf("test failed")
	}
}
