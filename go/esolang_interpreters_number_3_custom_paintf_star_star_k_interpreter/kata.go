package esolang_interpreters_number_3_custom_smallfuck_interpreter

// https://www.codewars.com/kata/58678d29dbca9a68d80000d7

import (
	"log"
	"strconv"
	"strings"
)

const (
	MOVN = "n"
	MOVE = "e"
	MOVS = "s"
	MOVW = "w"
	FLIP = "*"
	JMPP = "["
	JMPB = "]"

	separator = "\r\n"
)

func Interpreter(code string, iterations, width, height int) string {
	src := strings.Split(code, "")
	srcp := 0

	data := make([][]int, height)
	for i := range data {
		data[i] = make([]int, width)
	}

	iters := 0

	posX := 0
	posY := 0

	for {
		if iters >= iterations {
			log.Printf("exit: done after %v iterations\n", iters)
			break
		}
		if srcp < 0 || srcp >= len(src) {
			log.Printf("exit: code pointer %v out of range\n", srcp)
			break
		}
		if posX < 0 || posY < 0 || posX >= width || posY >= height {
			log.Printf("exit: data pointer %v %v out of range\n", posX, posY)
			break
		}
		printState(src, srcp)

		switch src[srcp] {
		case MOVN:
			posY--
		case MOVE:
			posX++
		case MOVS:
			posY++
		case MOVW:
			posX--
		case FLIP:
			// Flip the bit at the current cell
			if data[posY][posX] == 1 {
				data[posY][posX] = 0
			} else {
				data[posY][posX] = 1
			}
		case JMPP:
			// Jump past matching ] if value at current cell is 0
			if data[posY][posX] == 0 {
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
			// Jump back to matching [ (if value at current cell is nonzero)
			if data[posY][posX] == 1 {
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
		default:
			iters--
		}
		iters++
		srcp++
	}

	log.Println("final state:")
	printState(src, srcp)

	var lines []string
	for _, line := range data {
		var l string
		for _, i := range line {
			l = l + strconv.Itoa(i)
		}
		lines = append(lines, l)
	}
	return strings.Join(lines, separator)
}

func printState(src []string, srcp int) {
	log.Printf("src=%v\n", strings.Join(src, ""))
	pointer := "    "
	for i := 0; i < srcp; i++ {
		pointer = pointer + " "
	}
	log.Println(pointer + "^")
	log.Println("----")
}
