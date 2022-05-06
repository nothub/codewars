package snail

// https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1

func Snail(arr [][]int) []int {
	var out []int

	steps := len(arr) - 1

	x := steps
	y := 0
	out = append(out, arr[y]...)

	for steps > 0 {

		// y++
		// x--
		// steps--
		// y--
		// x++
		// steps--
		// ...

	}

	return out
}
