package esolang_interpreters_number_4_boolfuck_interpreter

// https://www.codewars.com/kata/5861487fdb20cff3ab000030

import (
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

	ONE  = "1"
	ZERO = "0"
)

func Boolfuck(code, input string) string {
	var tape []string
	//tape = prepend(tape, "left")
	//tape = append(tape, "right")

	//  Your interpreter should return the output as actual characters (not bits!) as a string.
	return strings.Join(tape, "")
}

func prepend(a []string, s string) []string {
	return append([]string{s}, a...)
}
