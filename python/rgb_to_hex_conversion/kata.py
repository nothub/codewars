def rgb(r, g, b):
    """`codewars.com <https://www.codewars.com/kata/513e08acc600c94f01000001>`_"""
    return ''.join([f'{i:02x}'.upper() for i in map(clamp, [r, g, b])])


def clamp(number, smallest=0, largest=255):
    return max(smallest, min(number, largest))
