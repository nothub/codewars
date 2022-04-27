#!/usr/bin/env bash

set -euo pipefail

package="$1"
kata_url="$2"

if [ -d "$package" ]; then
    echo 1>&2 "$package is already present!"
    exit 1
fi

mkdir -p "$package"
cd "$package"

cat <<EOF >kata.go
package $package

// $kata_url

import "log"

func solve(word string) string {
	word = word + "!"
	log.Println(word)
	return word
}
EOF

cat <<EOF >kata_test.go
package $package

// $kata_url

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
