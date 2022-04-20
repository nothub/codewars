import re


def valid_ISBN10(isbn):
    """`codewars.com <https://www.codewars.com/kata/51fc12de24a9d8cb0e000001>`_"""
    if len(isbn) != 10:
        return False

    if not re.fullmatch(re.compile(r"[0-9]{9}[0-9X]"), isbn):
        return False

    checksum = 0
    for i in range(1, 10 + 1):
        char = isbn[i - 1]
        checksum = checksum + i * (10 if char == 'X' else int(char))

    return checksum % 11 == 0
