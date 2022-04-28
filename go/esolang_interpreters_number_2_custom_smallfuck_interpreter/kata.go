package esolang_interpreters_number_2_custom_smallfuck_interpreter

// https://www.codewars.com/kata/58678d29dbca9a68d80000d7

import (
	"strings"
)

const (
	MOVR int32 = '>' // Move pointer to the right (by 1 cell)
	MOVL int32 = '<' // Move pointer to the left (by 1 cell)
	FLIP int32 = '*' // Flip the bit at the current cell
	JMPP int32 = '[' // Jump past matching ] if value at current cell is 0
	JMPB int32 = ']' // Jump back to matching [ (if value at current cell is nonzero)
)

func Interpreter(code string, tape string) string {
	mem := strings.Split(tape, "")
	pnt := 0
	for _, ins := range code {
		switch ins {
		case MOVR:
			pnt++
		case MOVL:
			pnt--
		case FLIP:
			if mem[pnt] == "1" {
				mem[pnt] = "0"
			} else {
				mem[pnt] = "1"
			}
		case JMPP:
			if mem[pnt] == "0" {
				for j := pnt; j < len(mem); j++ {
					if mem[j] == "]" {
						pnt = j
						break
					}
				}
			}
		case JMPB:
			if mem[pnt] != "0" {
				for j := len(mem) - 1; j >= pnt; j-- {
					if mem[j] == "[" {
						pnt = j
						break
					}
				}
			}
		}
		if pnt < 0 || pnt >= len(mem) {
			break
		}
	}
	return strings.Join(mem, "")
}
