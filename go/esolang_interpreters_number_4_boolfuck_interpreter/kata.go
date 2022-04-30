package esolang_interpreters_number_4_boolfuck_interpreter

// https://www.codewars.com/kata/5861487fdb20cff3ab000030

import (
	"regexp"
	"strings"
)

const (
	FLIP = "+"
	READ = ","
	PRNT = ";"
	MOVL = "<"
	MOVR = ">"
	JMPP = "["
	JMPB = "]"
)

type prog struct {
	code    []string
	pointer int
}

func newProg(code string) *prog {
	code = regexp.MustCompile(`[^+,;<>[\]]`).ReplaceAllString(code, "") // strip comments
	return &prog{code: strings.Split(code, ""), pointer: 0}
}

func (prog prog) read() string {
	return prog.code[prog.pointer]
}

func (prog prog) pointerValid() bool {
	return prog.pointer >= 0 && prog.pointer < len(prog.code)
}

type tape struct {
	memory  []bool
	pointer int
}

func newTape() *tape {
	return &tape{memory: []bool{false}, pointer: 0}
}

func (tape tape) read() bool {
	return tape.memory[tape.pointer]
}

func (tape tape) write(b bool) {
	tape.memory[tape.pointer] = b
}

func Boolfuck(code, input string) string {
	prog := newProg(code)
	tape := newTape()
	var bufI []bool
	var bufO []bool

	for {
		if !prog.pointerValid() {
			break
		}

		switch prog.read() {
		case FLIP:
			if tape.read() == false {
				tape.write(true)
			} else {
				tape.write(false)
			}
		case READ:
			// reads a bit from the input stream, storing it under the pointer.
			// 'a' -> [ 1 0 0 0 0 1 1 0 ] (little-endian)
			if len(bufI) == 0 && len(input) == 0 {
				// reached end-of-file
				tape.write(false)
				break
			}
			if len(bufI) == 0 && len(input) > 0 {
				// refill input buffer
				head := input[:1]
				input = input[1:]
				bufI = toBits(head[0])
			}
			head, body := behead(bufI)
			bufI = body
			tape.write(head[0])
		case PRNT:
			bufO = append(bufO, tape.read())
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
			jmpp(prog, tape)
		case JMPB:
			jmpb(prog, tape)
		}
		prog.pointer++
	}

	padded := make([]bool, paddedSize(bufO))
	for i := range bufO {
		padded[i] = bufO[i]
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
func jmpp(prog *prog, t *tape) {
	if t.read() == false {
		level := 0
		for i := prog.pointer; i < len(prog.code); i++ {
			if prog.code[i] == JMPP {
				level++
			} else if prog.code[i] == JMPB {
				level--
				if level == 0 {
					prog.pointer = i - 1
					return
				}
			}
		}
	}
}

// Jumps back to the matching [ character, if the value under the pointer is 1
func jmpb(prog *prog, t *tape) {
	if t.read() == true {
		level := 0
		for i := prog.pointer; i >= 0; i-- {
			if prog.code[i] == JMPB {
				level++
			} else if prog.code[i] == JMPP {
				level--
				if level == 0 {
					prog.pointer = i - 1
					return
				}
			}
		}
	}
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

func behead(bits []bool) ([]bool, []bool) {
	if len(bits) == 0 {
		return []bool{}, []bool{}
	}
	if len(bits) == 1 {
		return bits[:1], []bool{}
	}
	return bits[:1], bits[1:]
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
