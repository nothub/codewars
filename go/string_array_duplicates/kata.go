package string_array_duplicates

// https://www.codewars.com/kata/59f08f89a5e129c543000069

func Dup(arr []string) []string {
	var results []string
	for _, word := range arr {
		var result, last string
		for _, char := range word {
			this := string(char)
			if this != last {
				result = result + this
			}
			last = this
		}
		results = append(results, result)
	}
	return results
}
