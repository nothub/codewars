package snail

// https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1

func Snail(arr [][]int) []int {
	steps := len(arr) - 1

	x := steps
	y := 0

	var out []int
	out = append(out, arr[y]...)

	for steps > 0 {
		for i := 0; i < steps; i++ {
			y++ // down
			out = append(out, arr[y][x])
		}
		for i := 0; i < steps; i++ {
			x-- // left
			out = append(out, arr[y][x])
		}
		steps--
		for i := 0; i < steps; i++ {
			y-- // up
			out = append(out, arr[y][x])
		}
		for i := 0; i < steps; i++ {
			x++ // right
			out = append(out, arr[y][x])
		}
		steps--
	}

	return out
}
