def better_than_average(class_points: list, your_points: int):
    """`codewars.com <https://www.codewars.com/kata/5601409514fc93442500010b>`_"""
    class_points.append(your_points)
    return your_points > sum(class_points) / len(class_points)
