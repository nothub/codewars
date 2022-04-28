package esolang_interpreters_number_2_custom_smallfuck_interpreter

// https://www.codewars.com/kata/58678d29dbca9a68d80000d7

import (
	"log"
	"strings"
)

const (
	MOVR = ">"
	MOVL = "<"
	FLIP = "*"
	JMPP = "["
	JMPB = "]"

	ONE  = "1"
	ZERO = "0"
)

func Interpreter(code string, tape string) string {
	src := strings.Split(code, "")
	srcp := 0
	mem := strings.Split(tape, "")
	memp := 0

	log.Printf("src=%v\n", strings.Join(src, ""))
	log.Printf("mem=%v\n", strings.Join(mem, ""))

	for {
		if !pointerValid(srcp, src) {
			log.Println("exit: code pointer out of range")
			break
		}
		if !pointerValid(memp, mem) {
			log.Println("exit: tape pointer out of range")
			break
		}
		inst := src[srcp]
		log.Printf("memp=%v srcp=%v inst=%s\n", memp, srcp, inst)
		switch inst {
		case MOVR:
			// Move pointer to the right (by 1 cell)
			memp++
		case MOVL:
			// Move pointer to the left (by 1 cell)
			memp--
		case FLIP:
			// Flip the bit at the current cell
			if mem[memp] == ONE {
				mem[memp] = ZERO
			} else {
				mem[memp] = ONE
			}
		case JMPP:
			// Jump past matching ] if value at current cell is 0
			if mem[memp] == ZERO {
				level := 0
				for i := srcp; i < len(src); i++ {
					if src[i] == JMPP {
						level++
					}
					if src[i] == JMPB {
						level--
						if level == 0 {
							srcp = i + 1
							break
						}
					}
				}
			}
		case JMPB:
			// Jump back to matching [ (if value at current cell is nonzero)
			if mem[memp] == ONE {
				level := 0
				for i := len(src) - 1; i >= srcp; i-- {
					if src[i] == JMPB {
						level++
					}
					if src[i] == JMPP {
						level--
						if level == 0 {
							srcp = i
							break
						}
					}
				}
			}
		}
		srcp++
	}

	return strings.Join(mem, "")
}

func pointerValid(p int, a []string) bool {
	return p >= 0 && p < len(a)
}
