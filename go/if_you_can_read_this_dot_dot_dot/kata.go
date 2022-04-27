package if_you_can_read_this_dot_dot_dot

// https://www.codewars.com/kata/586538146b56991861000293

import (
	"strings"
)

func ToNato(words string) string {
	m := make(map[string]string)
	m["a"] = "Alfa"
	m["b"] = "Bravo"
	m["c"] = "Charlie"
	m["d"] = "Delta"
	m["e"] = "Echo"
	m["f"] = "Foxtrot"
	m["g"] = "Golf"
	m["h"] = "Hotel"
	m["i"] = "India"
	m["j"] = "Juliett"
	m["k"] = "Kilo"
	m["l"] = "Lima"
	m["m"] = "Mike"
	m["n"] = "November"
	m["o"] = "Oscar"
	m["p"] = "Papa"
	m["q"] = "Quebec"
	m["r"] = "Romeo"
	m["s"] = "Sierra"
	m["t"] = "Tango"
	m["u"] = "Uniform"
	m["v"] = "Victor"
	m["w"] = "Whiskey"
	m["x"] = "X-ray"
	m["y"] = "Yankee"
	m["z"] = "Zulu"
	m[","] = ","
	m["."] = "."
	m["!"] = "!"
	m["?"] = "?"
	words = strings.ToLower(words)
	words = strings.ReplaceAll(words, " ", "")
	var out []string
	for _, r := range strings.Split(words, "") {
		out = append(out, m[r])
	}
	return strings.Join(out, " ")
}
