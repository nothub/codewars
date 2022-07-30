#!/usr/bin/env bash

init_kata() {
    kata="$1"
    url="$2"

    if [[ -d ${kata} ]]; then
        panic "Kata ${kata} is already present!"
    fi
    mkdir -p "${kata}"

    cat <<EOF >"${kata}/kata.go"
package ${kata}

// ${url}

import "log"

func solve(word string) string {
	word = word + "!"
	log.Println(word)
	return word
}
EOF

    cat <<EOF >"${kata}/kata_test.go"
package ${kata}

// ${url}

import "testing"

func test(t *testing.T, input string, expected string) {
	actual := solve(input)
	if actual != expected {
		t.Errorf("FAIL\ninput:    %s\nactual:   %s\nexpected: %s", input, actual, expected)
	}
}

func TestHelloWorld(t *testing.T) {
	input := "Hello, World"
	expected := "Hello, World!"
	test(t, input, expected)
}
EOF
}
