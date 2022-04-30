package esolang_interpreters_number_4_boolfuck_interpreter

// https://www.codewars.com/kata/5861487fdb20cff3ab000030

import (
	"log"
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
	src := strings.Split(code, "")
	srcp := 0
	tape := newTape()

	//btoi := map[bool]int{true: 1}
	//fmt.Printf("%v%v\n", btoi[true], btoi[false])

	var bufi []bool
	var bufo []bool

	for {
		if !pointerValid(srcp, src) {
			log.Println("exit: code pointer out of range")
			break
		}
		switch src[srcp] {
		case FLIP:
			flip(tape)
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
				head, body := behead(input)
				input = body

				headBytes := []byte(head) // TODO: inline after testing
				if len(headBytes) != 1 {
					log.Fatalln("!!!", "HEAD BYTES LEN WAS:", len(head), "!!!")
				}
				bufi = toBits(headBytes[0])
			}

			head, body := beheadBools(bufi)
			bufi = body

			tape.write(head[0])

		case PRNT:
			// Outputs the bit under the pointer to the output stream.
			// The bits get output in little-endian order, the same order in which they would be input.
			bufo = append(bufo, tape.read())
		case MOVL:
			movl(tape)
		case MOVR:
			movr(tape)
		case JMPP:
			srcp = jmpp(src, srcp, tape)
		case JMPB:
			srcp = jmpb(src, srcp, tape)
		}
		srcp++
	}

	// TODO: Your interpreter should return the output as actual characters (not bits!) as a string.
	// If the total number of bits output is not a multiple of eight at the end of the program,
	// the last character of output gets padded with zeros on the more significant end.

	padded := make([]bool, paddedSize(bufo))
	for i := range bufo {
		padded[i] = bufo[i]
	}

	var out []byte
	for i := 0; i < len(padded); i = i + 8 {
		bits := padded[:8]
		padded = padded[8:]
		out = append(out, toByte(bits))
	}

	return string(out)
}

// Flips the value of the bit under the pointer
func flip(t *tape) {
	if t.read() == true {
		t.write(false)
	} else {
		t.write(true)
	}
}

// Moves the pointer left by 1 bit
func movl(t *tape) {
	if t.pointer == 0 {
		t.memory = append([]bool{false}, t.memory...)
		t.pointer++
	}
	t.pointer--
}

// Moves the pointer right by 1 bit
func movr(t *tape) {
	if t.pointer == len(t.memory)-1 {
		t.memory = append(t.memory, false)
	}
	t.pointer++
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
					srcp = i
					break
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
	diff := size % (fullBytes * 8)
	if diff == 0 {
		return size
	}
	return size + (8 - diff)
}

func toBits(b byte) []bool {
	bits := make([]bool, 8)
	for i := 0; i < 8; i++ {
		bits[i] = (b>>i)&1 > 0
	}
	return bits
}

func toByte(bools []bool) byte {
	var b byte
	for i := 0; i < 8; i++ {
		if bools[i] {
			b = b | (1 << i)
		}
	}
	return b
}

func flipBits(bits []bool) []bool {
	// flip by swapping
	i := 0
	j := len(bits) - 1
	for i < j {
		swap := bits[i]
		bits[i] = bits[j]
		bits[j] = swap
		i++
		j--
	}
	return bits
}

func behead(s string) (string, string) {
	if len(s) == 0 {
		return "", ""
	}
	if len(s) == 1 {
		return s[:1], ""
	}
	return s[:1], s[1:]
}

func beheadBools(bools []bool) ([]bool, []bool) {
	if len(bools) == 0 {
		return []bool{}, []bool{}
	}
	if len(bools) == 1 {
		return bools[:1], []bool{}
	}
	return bools[:1], bools[1:]
}
