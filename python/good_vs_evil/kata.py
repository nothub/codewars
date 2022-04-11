def good_vs_evil(good: str, evil: str):
    """`codewars.com <https://www.codewars.com/kata/52761ee4cffbc69732000738>`_"""

    race_worth_good = [1, 2, 3, 3, 4, 10]
    race_worth_evil = [1, 2, 2, 2, 3, 5, 10]

    worth_good = 0
    worth_evil = 0

    good_counts = list(map(int, good.split()))
    for i in range(len(good_counts)):
        worth_good += race_worth_good[i] * int(good_counts[i])

    evil_counts = list(map(int, evil.split()))
    for i in range(len(evil_counts)):
        worth_evil += race_worth_evil[i] * int(evil_counts[i])

    if worth_good > worth_evil:
        return "Battle Result: Good triumphs over Evil"
    if worth_evil > worth_good:
        return "Battle Result: Evil eradicates all trace of Good"
    else:
        return "Battle Result: No victor on this battle field"
