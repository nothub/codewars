package esolang_interpreters_number_4_boolfuck_interpreter

// https://www.codewars.com/kata/5861487fdb20cff3ab000030

import (
	"log"
	"strings"
)

const (
	FLIP = "+" // Flips the value of the bit under the pointer
	READ = "," // Reads a bit from the input stream, storing it under the pointer. The end-user types information using characters, though. Bytes are read in little-endian order—the first bit read from the character a, for instance, is 1, followed by 0, 0, 0, 0, 1, 1, and finally 0. If the end-of-file has been reached, outputs a zero to the bit under the pointer.
	PRNT = ";" // Outputs the bit under the pointer to the output stream. The bits get output in little-endian order, the same order in which they would be input. If the total number of bits output is not a multiple of eight at the end of the program, the last character of output gets padded with zeros on the more significant end.
	MOVL = "<" // Moves the pointer left by 1 bit
	MOVR = ">" // Moves the pointer right by 1 bit
	JMPP = "[" // If the value under the pointer is 0 then skip to the corresponding ]
	JMPB = "]" // Jumps back to the matching [ character, if the value under the pointer is 1
)

func Boolfuck(code, input string) string {
	// program
	src := strings.Split(code, "")
	srcp := 0
	// tape
	mem := []bool{false}
	memp := 0
	// append on tapes right side
	mem = append(mem, true)
	// prepend on tapes left side
	mem = append([]bool{true}, mem...)
	memp++

	for {
		if !pointerValid(srcp, src) {
			log.Println("exit: code pointer out of range")
			break
		}

		switch src[srcp] {
		case FLIP:
			// Flips the value of the bit under the pointer
			if mem[memp] == true {
				mem[memp] = false
			} else {
				mem[memp] = true
			}
		case READ:
			// Reads a bit from the input stream, storing it under the pointer.
			// The end-user types information using characters, though.
			// Bytes are read in little-endian order—the first bit read from the character a,
			// for instance, is 1, followed by 0, 0, 0, 0, 1, 1, and finally 0.
			// If the end-of-file has been reached, outputs a zero to the bit under the pointer.

		case PRNT:
			// Outputs the bit under the pointer to the output stream.
			// The bits get output in little-endian order, the same order in which they would be input.
			// If the total number of bits output is not a multiple of eight at the end of the program,
			// the last character of output gets padded with zeros on the more significant end.

		case MOVL:
			// Moves the pointer left by 1 bit
			if memp == 0 {
				mem = append([]bool{false}, mem...)
				memp++
			}
			memp--
		case MOVR:
			// Moves the pointer right by 1 bit
			if memp == len(mem)-1 {
				mem = append(mem, false)
			}
			memp++
		case JMPP:
			// If the value under the pointer is 0 then skip to the corresponding ]
			if mem[memp] == false {
				level := 0
				for i := srcp; i < len(src); i++ {
					if src[i] == JMPP {
						level++
					} else if src[i] == JMPB {
						level--
						if level == 0 {
							srcp = i
							break
						}
					}
				}
			}
		case JMPB:
			// Jumps back to the matching [ character, if the value under the pointer is 1
			if mem[memp] == true {
				level := 0
				for i := len(src) - 1; i >= 0; i-- {
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

	//  Your interpreter should return the output as actual characters (not bits!) as a string.
	return ""
}

func pointerValid(p int, a []string) bool {
	return p >= 0 && p < len(a)
}
