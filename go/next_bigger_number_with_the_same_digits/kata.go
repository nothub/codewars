package next_bigger_number_with_the_same_digits

// https://www.codewars.com/kata/55983863da40caa2c900004e

import (
	"log"
	"strconv"
	"strings"
)

func NextBigger(n int) int {
	log.Println("input", n)
	perms := perm(n)
	log.Println("perms", perms)
	return 9000
}

func perm(n int) []int {
	arr := strings.Split(strconv.Itoa(n), "")
	var out []int
	permRec(arr, 0, &out)
	return out
}

func permRec(arr []string, i int, out *[]int) {
	if i > len(arr) {
		if arr[0] == "0" {
			return
		}
		n, _ := strconv.Atoi(strings.Join(arr, ""))
		*out = append(*out, n)
		return
	}
	permRec(arr, i+1, out)
	for j := i + 1; j < len(arr); j++ {
		arr[i], arr[j] = arr[j], arr[i]
		permRec(arr, i+1, out)
		arr[i], arr[j] = arr[j], arr[i]
	}
}
