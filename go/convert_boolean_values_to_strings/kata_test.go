package convert_boolean_values_to_strings

import "testing"

func assert(t *testing.T, expected string, actual string) {
	if actual != expected {
		t.Errorf("\n"+"actual:   \"%v\""+"\n"+"expected: \"%v\"", expected, actual)
	}
}

func TestYes(t *testing.T) {
	var expected = "Yes"
	var actual = BoolToWord(true)
	assert(t, actual, expected)
}

func TestNo(t *testing.T) {
	var expected = "No"
	var actual = BoolToWord(false)
	assert(t, actual, expected)
}
