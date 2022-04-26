package twice_as_old

// https://www.codewars.com/kata/5b853229cfde412a470000d0

import "math"

func TwiceAsOld(dadYearsOld, sonYearsOld int) int {
	return int(math.Abs(float64(dadYearsOld - (sonYearsOld * 2))))
}
