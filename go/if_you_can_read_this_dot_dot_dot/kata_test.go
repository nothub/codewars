package if_you_can_read_this_dot_dot_dot

import "testing"

func test(t *testing.T, input string, expected string) {
	actual := ToNato(input)
	if actual != expected {
		t.Errorf("FAIL\ninput:    %s\nactual:   %s\nexpected: %s", input, actual, expected)
	}
}

func Test1(t *testing.T) {
	input := "If you can read"
	expected := "India Foxtrot Yankee Oscar Uniform Charlie Alfa November Romeo Echo Alfa Delta"
	test(t, input, expected)
}

func Test2(t *testing.T) {
	input := "Did not see that coming"
	expected := "Delta India Delta November Oscar Tango Sierra Echo Echo Tango Hotel Alfa Tango Charlie Oscar Mike India November Golf"
	test(t, input, expected)
}

func Test3(t *testing.T) {
	input := "go for it!"
	expected := "Golf Oscar Foxtrot Oscar Romeo India Tango !"
	test(t, input, expected)
}
