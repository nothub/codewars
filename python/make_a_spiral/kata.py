from typing import List


def spiralize(size: int) -> List[List[int]]:
    """`codewars.com <https://www.codewars.com/kata/534e01fbbb17187c7e0000c6>`_"""

    spiral: List[List[int]] = list()
    for i in range(size):
        spiral.append(list())
        for _ in range(size):
            spiral[i].append(0)

    return spiral


"""snail algo:
    steps := size - 1

    x := steps
    y := 0

    out := []int{}
    out = append(out, arr[y]...)

    for steps > 0 {
        for i := 0; i < steps; i++ {
            y++ // down
            out = append(out, arr[y][x])
        }
        if steps == 1 { break; }
        for i := 0; i < steps; i++ {
            x-- // left
            out = append(out, arr[y][x])
        }
        steps--
        steps--
        for i := 0; i < steps; i++ {
            y-- // up
            out = append(out, arr[y][x])
        }
        if steps == 1 { break; }
        for i := 0; i < steps; i++ {
            x++ // right
            out = append(out, arr[y][x])
        }
        steps--
        steps--
    }

    return out
    """
