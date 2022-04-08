def create_phone_number(n):
    """`codewars.com <https://www.codewars.com/kata/525f50e3b73515a6db000b83>`_"""
    s = ""
    for x in n:
        s = s + str(x)
    return "(" + s[0:3] + ") " + s[3:6] + "-" + s[6:]
