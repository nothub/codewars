package extra_perfect_numbers_special_numbers_series_number_7

// https://www.codewars.com/kata/5a662a02e626c54e87000123

func ExtraPerfect(n int) []int {
	var r []int
	for i := 0; i <= n; i++ {
		if i%2 != 0 {
			r = append(r, i)
		}
	}
	return r
}
