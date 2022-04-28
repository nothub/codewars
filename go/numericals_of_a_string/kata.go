package numericals_of_a_string

// https://www.codewars.com/kata/5b4070144d7d8bbfe7000001

import (
	"log"
	"strconv"
)

// TODO: needs to handle non utf8

func Numericals(input string) string {
	var result string
	for i := 0; i < len(input); i++ {
		seen := make(map[rune]int)
		for j, r := range input {
			if j > i {
				break
			}
			seen[r] = seen[r] + 1
		}
		log.Println(seen)
		result = result + strconv.Itoa(seen[rune(input[i])])
	}
	return result
}
