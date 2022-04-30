package esolang_interpreters_number_4_boolfuck_interpreter

// https://www.codewars.com/kata/5861487fdb20cff3ab000030

import (
	"regexp"
	"strings"
)

// In UTF-8, characters from the U+0000..U+10FFFF range (the UTF-16 accessible range)
// are encoded using sequences of 1 to 4 octets (bytes). (see: https://www.rfc-editor.org/rfc/rfc3629#section-3)

const (
	// FLIP Flips the value of the bit under the pointer
	FLIP = "+"

	// READ Reads a bit from the input stream, storing it under the pointer.
	// The end-user types information using characters, though.
	// Bytes are read in little-endian order—the first bit read from the character a,
	// for instance, is 1, followed by 0, 0, 0, 0, 1, 1, and finally 0.
	// If the end-of-file has been reached, outputs a zero to the bit under the pointer.
	READ = ","

	// PRNT Outputs the bit under the pointer to the output stream.
	// The bits get output in little-endian order, the same order in which they would be input.
	// If the total number of bits output is not a multiple of eight at the end of the program,
	// the last character of output gets padded with zeros on the more significant end.
	PRNT = ";"

	// MOVL Moves the pointer left by 1 bit
	MOVL = "<"

	// MOVR Moves the pointer right by 1 bit
	MOVR = ">"

	// JMPP If the value under the pointer is 0 then skip to the corresponding ]
	JMPP = "["

	// JMPB Jumps back to the matching [ character, if the value under the pointer is 1
	JMPB = "]"
)

type tape struct {
	memory  []bool
	pointer int
}

func newTape() *tape {
	t := tape{memory: []bool{false}, pointer: 0}
	return &t
}

// add element to tapes left side
func (tape tape) prepend(b bool) {
	tape.memory = append([]bool{b}, tape.memory...)
	tape.pointer++
}

// add element to tapes right side
func (tape tape) append(b bool) {
	tape.memory = append(tape.memory, b)
}

func (tape tape) size() int {
	return len(tape.memory)
}

func (tape tape) read() bool {
	return tape.memory[tape.pointer]
}

func (tape tape) write(b bool) {
	tape.memory[tape.pointer] = b
}

func Boolfuck(code, input string) string {

	code = regexp.MustCompile(`[^+,;<>[\]]`).ReplaceAllString(code, "") // strip comments
	src := strings.Split(code, "")
	srcp := 0
	tape := newTape()
	var bufi []bool
	var bufo []bool

	for {
		if !pointerValid(srcp, src) {
			break
		}

		switch src[srcp] {
		case FLIP:
			if tape.read() == false {
				tape.write(true)
			} else {
				tape.write(false)
			}
		case READ:
			// reads a bit from the input stream, storing it under the pointer.
			// 'a' -> [ 1 0 0 0 0 1 1 0 ] (little-endian)

			// if the end-of-file has been reached, outputs a zero to the bit under the pointer
			if len(bufi) == 0 && len(input) == 0 {
				tape.write(false)
				break
			}

			// refill input buffer when empty
			if len(bufi) == 0 {
				head, body := beheadString(input)
				input = body
				bufi = toBits(([]byte(head))[0])
			}

			head, body := beheadBools(bufi)
			bufi = body

			tape.write(head[0])

		case PRNT:
			bufo = append(bufo, tape.read())
		case MOVL:
			if tape.pointer == 0 {
				tape.memory = append([]bool{false}, tape.memory...)
				tape.pointer++
			}
			tape.pointer--
		case MOVR:
			if tape.pointer == len(tape.memory)-1 {
				tape.memory = append(tape.memory, false)
			}
			tape.pointer++
		case JMPP:
			srcp = jmpp(src, srcp, tape)
		case JMPB:
			srcp = jmpb(src, srcp, tape)
		}
		srcp++
	}

	padded := make([]bool, paddedSize(bufo))
	for i := range bufo {
		padded[i] = bufo[i]
	}

	var out []byte
	for len(padded) > 0 {
		bits := padded[:8]
		padded = padded[8:]
		out = append(out, toByte(bits))
	}

	return string(out)
}

// If the value under the pointer is 0 then skip to the corresponding ]
func jmpp(src []string, srcp int, t *tape) int {
	if t.read() == false {
		level := 0
		for i := srcp; i < len(src); i++ {
			if src[i] == JMPP {
				level++
			} else if src[i] == JMPB {
				level--
				if level == 0 {
					return i - 1
				}
			}
		}
	}
	return srcp
}

// Jumps back to the matching [ character, if the value under the pointer is 1
func jmpb(src []string, srcp int, t *tape) int {
	if t.read() == true {
		level := 0
		for i := srcp; i >= 0; i-- {
			if src[i] == JMPB {
				level++
			} else if src[i] == JMPP {
				level--
				if level == 0 {
					return i - 1
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
	diff := size % (fullBytes * 8)
	if diff == 0 {
		return size
	}
	return size + (8 - diff)
}

func toBits(b byte) []bool {
	bits := make([]bool, 8)
	for i := 0; i < 8; i++ {
		bits[i] = (b>>byte(i))&1 > 0
	}
	return bits
}

func toByte(bools []bool) byte {
	var b byte
	for i := 0; i < 8; i++ {
		if bools[i] {
			b = b | (1 << byte(i))
		}
	}
	return b
}

func beheadBools(bits []bool) ([]bool, []bool) {
	if len(bits) == 0 {
		return []bool{}, []bool{}
	}
	if len(bits) == 1 {
		return bits[:1], []bool{}
	}
	return bits[:1], bits[1:]
}

func beheadString(str string) (string, string) {
	if len(str) == 0 {
		return "", ""
	}
	if len(str) == 1 {
		return str[:1], ""
	}
	return str[:1], str[1:]
}

//func behead[T any](arr []T) ([]T, []T) {
//    if len(arr) == 0 {
//        return []T{}, []T{}
//    }
//    if len(arr) == 1 {
//        return arr[:1], []T{}
//    }
//    return arr[:1], arr[1:]
//}
//
//func beheadString(s string) (string, string) {
//    head, body := behead(strings.Split(s, ""))
//    return strings.Join(head, ""), strings.Join(body, "")
//}
