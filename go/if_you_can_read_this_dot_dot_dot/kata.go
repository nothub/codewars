package if_you_can_read_this_dot_dot_dot

// https://www.codewars.com/kata/586538146b56991861000293

import (
	"strings"
)

func ToNato(words string) string {
	m := map[string]string{
		"a": "Alfa",
		"b": "Bravo",
		"c": "Charlie",
		"d": "Delta",
		"e": "Echo",
		"f": "Foxtrot",
		"g": "Golf",
		"h": "Hotel",
		"i": "India",
		"j": "Juliett",
		"k": "Kilo",
		"l": "Lima",
		"m": "Mike",
		"n": "November",
		"o": "Oscar",
		"p": "Papa",
		"q": "Quebec",
		"r": "Romeo",
		"s": "Sierra",
		"t": "Tango",
		"u": "Uniform",
		"v": "Victor",
		"w": "Whiskey",
		"x": "X-ray",
		"y": "Yankee",
		"z": "Zulu",
		",": ",",
		".": ".",
		"!": "!",
		"?": "?",
	}
	words = strings.ToLower(words)
	words = strings.ReplaceAll(words, " ", "")
	var nato []string
	for _, r := range strings.Split(words, "") {
		nato = append(nato, m[r])
	}
	return strings.Join(nato, " ")
}
