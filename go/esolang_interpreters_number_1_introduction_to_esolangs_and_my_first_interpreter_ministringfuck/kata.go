package esolang_interpreters_number_1_introduction_to_esolangs_and_my_first_interpreter_ministringfuck

// https://www.codewars.com/kata/586dd26a69b6fd46dd0000c0

import (
	"fmt"
	"strings"
	"unicode"
)

func Interpreter(code string) string {
	var buf []rune
	mem := 0
	for _, r := range strings.Split(code, "") {
		switch r {
		case "+":
			mem++
			mem = mem % 256
		case ".":
			buf = append(buf, rune(mem))
		}
	}
	var out string
	for _, c := range buf {
		if c < unicode.MaxASCII {
			out = out + string(c)
		} else {
			out = out + `\x` + fmt.Sprintf("%x", c)
		}
	}
	return strings.ReplaceAll(out, `\\`, `\`)
}
