package where_my_anagrams_at

// https://www.codewars.com/kata/523a86aa4230ebb5420001e1

import (
	"log"
	"sort"
	"strings"
)

func Anagrams(word string, words []string) []string {
	log.Println("hi!")
	var results []string
	s := sortString(word)
	for _, w := range words {
		if len(w) != len(s) {
			continue
		}
		if sortString(w) == s {
			results = append(results, w)
		}
	}
	return results
}

func sortString(word string) string {
	split := strings.Split(word, "")
	sort.Strings(split)
	return strings.Join(split, "")
}
