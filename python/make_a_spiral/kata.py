from typing import List


def spiralize(size: int) -> List[List[int]]:
    """`codewars.com <https://www.codewars.com/kata/534e01fbbb17187c7e0000c6>`_"""

    spiral: List[List[int]] = list()
    for i in range(size):
        spiral.append(list())
        for _ in range(size):
            spiral[i].append(0)

    steps = size - 1
    x = steps
    y = 0

    for i in range(size):
        spiral[y][i] = 1

    while steps > 0:

        for _ in range(steps):
            y = y + 1  # down
            spiral[y][x] = 1

        if steps == 1:
            break

        for _ in range(steps):
            x = x - 1  # left
            spiral[y][x] = 1

        steps = steps - 2

        for _ in range(steps):
            y = y - 1  # up
            spiral[y][x] = 1

        if steps == 1:
            break

        for _ in range(steps):
            x = x + 1  # right
            spiral[y][x] = 1

        steps = steps - 2

    return spiral
