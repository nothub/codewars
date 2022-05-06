package next_bigger_number_with_the_same_digits

// https://www.codewars.com/kata/55983863da40caa2c900004e

import (
	"log"
	"strconv"
	"strings"
)

var perms []string

func NextBigger(n int) int {
	s := strconv.Itoa(n)
	a := strings.Split(s, "")
	Perm(a)
	log.Println(perms)
	return 9000
}

func Perm(a []string) {
	perm(a, 0)
}

func perm(a []string, i int) {
	if i > len(a) {
		perms = append(perms, strings.Join(a, ""))
		return
	}
	perm(a, i+1)
	for j := i + 1; j < len(a); j++ {
		a[i], a[j] = a[j], a[i]
		perm(a, i+1)
		a[i], a[j] = a[j], a[i]
	}
}
