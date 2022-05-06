package next_bigger_number_with_the_same_digits

// https://www.codewars.com/kata/55983863da40caa2c900004e

import (
	"log"
	"strconv"
	"strings"
)

func NextBigger(n int) int {
	s := strconv.Itoa(n)
	a := strings.Split(s, "")
	var perms []string
	Perm(a, &perms)
	log.Println(perms)
	return 9000
}

func Perm(arr []string, out *[]string) {
	perm(arr, 0, out)
}

func perm(arr []string, i int, out *[]string) {
	if i > len(arr) {
		*out = append(*out, strings.Join(arr, ""))
		return
	}
	perm(arr, i+1, out)
	for j := i + 1; j < len(arr); j++ {
		arr[i], arr[j] = arr[j], arr[i]
		perm(arr, i+1, out)
		arr[i], arr[j] = arr[j], arr[i]
	}
}
