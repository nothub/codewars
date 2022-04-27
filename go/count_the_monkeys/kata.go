package count_the_monkeys

// https://www.codewars.com/kata/56f69d9f9400f508fb000ba7

func monkeyCount(n int) []int {
	results := make([]int, n)
	for i := range results {
		results[i] = i + 1
	}
	return results
}
