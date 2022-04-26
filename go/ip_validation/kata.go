package ip_validation

// https://www.codewars.com/kata/515decfd9dcfc23bb6000006

import "net"

func Is_valid_ip(ip string) bool {
	if net.ParseIP(ip) != nil {
		return true
	}
	return false
}
