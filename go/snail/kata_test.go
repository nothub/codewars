package snail

// https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1

import "testing"

func assertSame[T string | int](a []T, b []T) bool {
	if a == nil && b == nil {
		return true
	}
	if a == nil || b == nil {
		return false
	}
	if len(a) != len(b) {
		return false
	}
	for i := 0; i < len(a); i++ {
		if a[i] != b[i] {
			return false
		}
	}
	return true
}

func test(t *testing.T, input [][]int, expected []int) {
	actual := Snail(input)
	if !assertSame(actual, expected) {
		t.Errorf("FAIL\ninput:    %02v\nactual:   %02v\nexpected: %02v", input, actual, expected)
	}
}

func Test0(t *testing.T) {
	//test(t, [][]int{}, []int{})
	//test(t, [][]int{{}}, []int{})
}

func Test1(t *testing.T) {
	input := [][]int{
		{1, 2, 3},
		{4, 5, 6},
		{7, 8, 9}}
	expected := []int{
		1, 2, 3,
		6, 9,
		8, 7,
		4,
		5}
	test(t, input, expected)
}

func Test2(t *testing.T) {
	input := [][]int{
		{01, 02, 03, 04},
		{11, 12, 13, 14},
		{21, 22, 23, 24},
		{31, 32, 33, 34}}
	expected := []int{
		01, 02, 03, 04,
		14, 24, 34,
		33, 32, 31,
		21, 11,
		12, 13,
		23,
		22}
	test(t, input, expected)
}

func Test3(t *testing.T) {
	input := [][]int{
		{00, 01, 02, 03, 04, 05, 06, 07},
		{10, 11, 12, 13, 14, 15, 16, 17},
		{20, 21, 22, 23, 24, 25, 26, 27},
		{30, 31, 32, 33, 34, 35, 36, 37},
		{40, 41, 42, 43, 44, 45, 46, 47},
		{50, 51, 52, 53, 54, 55, 56, 57},
		{60, 61, 62, 63, 64, 65, 66, 67},
		{70, 71, 72, 73, 74, 75, 76, 77},
	}
	expected := []int{
		00, 01, 02, 03, 04, 05, 06, 07,
		17, 27, 37, 47, 57, 67, 77,
		76, 75, 74, 73, 72, 71, 70,
		60, 50, 40, 30, 20, 10,
		11, 12, 13, 14, 15, 16,
		26, 36, 46, 56, 66,
		65, 64, 63, 62, 61,
		51, 41, 31, 21,
		22, 23, 24, 25,
		35, 45, 55,
		54, 53, 52,
		42, 32,
		33, 34,
		44,
		43}
	test(t, input, expected)
}
