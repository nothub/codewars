package esolang_interpreters_number_1_introduction_to_esolangs_and_my_first_interpreter_ministringfuck

// https://www.codewars.com/kata/586dd26a69b6fd46dd0000c0
// https://esolangs.org/wiki/MiniStringFuck

import (
	"strings"
)

func Interpreter(code string) string {
	out := ""
	mem := 0
	for _, r := range strings.Split(code, "") {
		switch r {
		case "+":
			mem++
			mem = mem % 256
		case ".":
			out = out + string(rune(mem))
		default:
			panic("unknown opcode: " + r)
		}
	}
	return out
}
