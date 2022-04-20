ROT_DISTANCE = 13
AMOUNT_LETTERS = 26


def rot13(message):
    """`codewars.com <https://www.codewars.com/kata/52223df9e8f98c7aa7000062>`_"""
    out = ''
    for c in message:
        if 'A' <= c <= 'Z':
            out = out + shift(c, ord('A'))
        elif 'a' <= c <= 'z':
            out = out + shift(c, ord('a'))
        else:
            out = out + c
    return out


def shift(char, index):
    return chr((ord(char) - index + ROT_DISTANCE) % AMOUNT_LETTERS + index)
