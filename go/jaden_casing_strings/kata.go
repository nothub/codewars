package jaden_casing_strings

// https://www.codewars.com/kata/5390bac347d09b7da40006f6

import (
	"strings"
)

func ToJadenCase(s string) string {
	var buf []string
	for _, w := range strings.Split(s, " ") {
		buf = append(buf, strings.ToUpper(string(w[0]))+w[1:])
	}
	return strings.Join(buf, " ")
}
