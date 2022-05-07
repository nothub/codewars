import sys
from typing import List

from kata import spiralize


def test(actual: List[List[int]], expected: List[List[int]]):
    if actual != expected:
        print("expected: " + str(expected), file=sys.stderr)
        print("actual:   " + str(actual), file=sys.stderr)
        raise AssertionError()


if __name__ == '__main__':
    test(spiralize(5), [
        [1, 1, 1, 1, 1],
        [0, 0, 0, 0, 1],
        [1, 1, 1, 0, 1],
        [1, 0, 0, 0, 1],
        [1, 1, 1, 1, 1]])

    test(spiralize(8), [
        [1, 1, 1, 1, 1, 1, 1, 1],
        [0, 0, 0, 0, 0, 0, 0, 1],
        [1, 1, 1, 1, 1, 1, 0, 1],
        [1, 0, 0, 0, 0, 1, 0, 1],
        [1, 0, 1, 0, 0, 1, 0, 1],
        [1, 0, 1, 1, 1, 1, 0, 1],
        [1, 0, 0, 0, 0, 0, 0, 1],
        [1, 1, 1, 1, 1, 1, 1, 1]])
