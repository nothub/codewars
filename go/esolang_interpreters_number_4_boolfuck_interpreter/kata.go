package esolang_interpreters_number_4_boolfuck_interpreter

// https://www.codewars.com/kata/5861487fdb20cff3ab000030

import (
	"fmt"
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
	mem := []byte{0}
	memp := 0
	// append on tapes right side
	mem = append(mem, 1)
	// prepend on tapes left side
	mem = append([]byte{1}, mem...)
	memp++

	for {
		if !pointerValid(srcp, src) {
			log.Println("exit: code pointer out of range")
			break
		}

		switch src[srcp] {
		case FLIP:
			flip(mem, memp)
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
			memp, mem = movl(mem, memp)
		case MOVR:
			memp, mem = movr(mem, memp)
		case JMPP:
			srcp = jmpp(mem, memp, src, srcp)
		case JMPB:
			srcp = jmpb(mem, memp, src, srcp)
		}
		srcp++
	}

	var out string
	for _, bit := range mem {
		out = out + fmt.Sprintf("%s%b", out, bit)
	}

	//  Your interpreter should return the output as actual characters (not bits!) as a string.
	return ""
}

// Flips the value of the bit under the pointer
func flip(mem []byte, memp int) {
	if mem[memp] == 1 {
		mem[memp] = 0
	} else {
		mem[memp] = 1
	}
}

// Moves the pointer left by 1 bit
func movl(mem []byte, memp int) (int, []byte) {
	if memp == 0 {
		mem = append([]byte{0}, mem...)
		memp++
	}
	memp--
	return memp, mem
}

// Moves the pointer right by 1 bit
func movr(mem []byte, memp int) (int, []byte) {
	if memp == len(mem)-1 {
		mem = append(mem, 0)
	}
	memp++
	return memp, mem
}

// If the value under the pointer is 0 then skip to the corresponding ]
func jmpp(mem []byte, memp int, src []string, srcp int) int {
	if mem[memp] == 0 {
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
	return srcp
}

// Jumps back to the matching [ character, if the value under the pointer is 1
func jmpb(mem []byte, memp int, src []string, srcp int) int {
	if mem[memp] == 1 {
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
	return srcp
}

func pointerValid(p int, a []string) bool {
	return p >= 0 && p < len(a)
}

func paddedSize(bits []bool) int {
	size := len(bits)
	if size == 0 {
		return 0
	}
	fullBytes := size / 8
	if fullBytes < 1 {
		return 8
	}
	offset := size % (fullBytes * 8)
	if offset == 0 {
		return size
	}
	return size + (8 - offset)
}
