def move_zeros(array):
    """`codewars.com <https://www.codewars.com/kata/52597aa56021e91c93000cb0>`_"""
    out = []
    for e in array:
        if e is not 0:
            out.append(e)
    while len(out) < len(array):
        out.append(0)
    return out
