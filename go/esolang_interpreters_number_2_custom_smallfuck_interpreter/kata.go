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
	for {
		if !pointerValid(srcp, src) {
			log.Println("exit: code pointer out of range")
			break
		}
		if !pointerValid(memp, mem) {
			log.Println("exit: tape pointer out of range")
			break
		}
		printState(src, srcp, mem, memp)
		switch src[srcp] {
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
					} else if src[i] == JMPB {
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
					} else if src[i] == JMPP {
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
	log.Println("final state:")
	printState(src, srcp, mem, memp)
	return strings.Join(mem, "")
}

func printState(src []string, srcp int, mem []string, memp int) {
	log.Printf("pnt=%v\n", srcp)
	log.Printf("src=%v\n", strings.Join(src, ""))
	pointer := "    "
	for i := 0; i < srcp; i++ {
		pointer = pointer + " "
	}
	log.Println(pointer + "^")
	log.Printf("pnt=%v\n", memp)
	log.Printf("mem=%v\n", strings.Join(mem, ""))
	pointer = "    "
	for i := 0; i < memp; i++ {
		pointer = pointer + " "
	}
	log.Println(pointer + "^")
	log.Println("----")
}

func pointerValid(p int, a []string) bool {
	return p >= 0 && p < len(a)
}
