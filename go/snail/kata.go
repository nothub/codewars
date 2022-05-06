package snail

// https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1

/*
S7777777
66666667
64444457
64222357
64211357
64333357
65555557
77777777
*/

func Snail(arr [][]int) []int {
	steps := len(arr) - 1

	x := steps
	y := 0

	//kata spec says an empty slice represents an empty matrix, a nil initialized slice does not pass tests
	//goland:noinspection GoPreferNilSlice
	out := []int{}
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
