package highest_scoring_word

// https://www.codewars.com/kata/57eb8fcdf670e99d9b000272

import (
	"strings"
)

func High(words string) string {
	highestScore := 0
	highestWord := ""
	for _, word := range strings.Split(words, " ") {
		score := 0
		for _, r := range []rune(word) {
			score = score + int(r-97+1)
		}
		if score > highestScore {
			highestScore = score
			highestWord = word
		}
	}
	return highestWord
}
