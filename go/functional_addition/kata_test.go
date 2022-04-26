package functional_addition

import "testing"

func Test(t *testing.T) {
	if Add(1)(3) != 4 {
		t.Errorf("test failed")
	}
}
