package where_my_anagrams_at

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
	if !assertSame(Anagrams("abba", []string{"aabb", "abcd", "bbaa", "dada"}), []string{"aabb", "bbaa"}) {
		t.Errorf("test failed")
	}
}

func Test2(t *testing.T) {
	if !assertSame(Anagrams("laser", []string{"lazing", "lazy", "lacer"}), nil) {
		t.Errorf("test failed")
	}
}
