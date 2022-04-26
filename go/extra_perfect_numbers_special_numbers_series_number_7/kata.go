package extra_perfect_numbers_special_numbers_series_number_7

// https://www.codewars.com/kata/5a662a02e626c54e87000123

import (
	"strconv"
)

func ExtraPerfect(n int) []int {
	var r []int
	for i := 0; i <= n; i++ {
		s := strconv.FormatInt(int64(i), 2)
		if s[0:1] == "1" && s[len(s)-1:] == "1" {
			r = append(r, i)
		}
	}
	return r
}
