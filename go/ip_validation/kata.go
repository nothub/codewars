package ip_validation

// https://www.codewars.com/kata/515decfd9dcfc23bb6000006

import (
	"log"
	"regexp"
	"strconv"
	"strings"
)

func Is_valid_ip(ip string) bool {
	matches, err := regexp.MatchString("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}", ip)
	if err != nil {
		log.Fatalln(err)
	}
	if !matches {
		return false
	}
	for _, oct := range strings.Split(ip, ".") {
		if len(oct) > 1 && oct[0:1] == "0" {
			return false
		}
		num, err := strconv.Atoi(oct)
		if err != nil {
			log.Fatalln(err)
		}
		if num > 255 {
			return false
		}
	}
	return true
}
