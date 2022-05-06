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
		for i := 0; i < steps; i++ {
			y++
			out = append(out, arr[y][x])
		}

		// x--
		for i := 0; i < steps; i++ {
			x--
			out = append(out, arr[y][x])
		}
		steps--

		// y--
		for i := 0; i < steps; i++ {
			y--
			out = append(out, arr[y][x])
		}

		// x++
		for i := 0; i < steps; i++ {
			x++
			out = append(out, arr[y][x])
		}

		steps--

	}

	return out
}
