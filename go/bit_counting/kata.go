package bit_counting

// https://www.codewars.com/kata/526571aae218b8ee490006f4

import (
	"strconv"
	"strings"
)

func CountBits(i uint) int {
	return len(strings.ReplaceAll(strconv.FormatInt(int64(i), 2), "0", ""))
}
