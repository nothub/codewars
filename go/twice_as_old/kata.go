package twice_as_old

// https://www.codewars.com/kata/5601409514fc93442500010b

import "math"

func TwiceAsOld(dadYearsOld, sonYearsOld int) int {
	return int(math.Abs(float64(dadYearsOld - (sonYearsOld * 2))))
}
