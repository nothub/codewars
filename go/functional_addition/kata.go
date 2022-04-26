package functional_addition

// https://www.codewars.com/kata/538835ae443aae6e03000547

func Add(i int) func(int) int {
	return func(j int) int {
		return i + j
	}
}
