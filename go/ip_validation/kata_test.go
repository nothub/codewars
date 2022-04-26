package ip_validation

import "testing"

func Test0(t *testing.T) {
	if Is_valid_ip("") != false {
		t.Errorf("test failed")
	}
}

func Test1(t *testing.T) {
	if Is_valid_ip("12.255.56.1") != true {
		t.Errorf("test failed")
	}
}

func Test2(t *testing.T) {
	if Is_valid_ip("abc.def.ghi.jkl") != false {
		t.Errorf("test failed")
	}
}

func Test3(t *testing.T) {
	if Is_valid_ip("123.456.789.0") != false {
		t.Errorf("test failed")
	}
}

func Test4(t *testing.T) {
	if Is_valid_ip("12.34.56") != false {
		t.Errorf("test failed")
	}
}

func Test5(t *testing.T) {
	if Is_valid_ip("12.34.56 .1") != false {
		t.Errorf("test failed")
	}
}

func Test6(t *testing.T) {
	if Is_valid_ip("12.34.56.-1") != false {
		t.Errorf("test failed")
	}
}

func Test7(t *testing.T) {
	if Is_valid_ip("123.045.067.089") != false {
		t.Errorf("test failed")
	}
}

func Test8(t *testing.T) {
	if Is_valid_ip("127.1.1.0") != true {
		t.Errorf("test failed")
	}
}

func Test9(t *testing.T) {
	if Is_valid_ip("0.0.0.0") != true {
		t.Errorf("test failed")
	}
}

func Test10(t *testing.T) {
	if Is_valid_ip("0.34.82.53") != true {
		t.Errorf("test failed")
	}
}

func Test11(t *testing.T) {
	if Is_valid_ip("192.168.1.300") != false {
		t.Errorf("test failed")
	}
}
