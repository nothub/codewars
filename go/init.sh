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

import (
    "log"
)

func solve(input bool) bool {
    log.Println("hi!")
    return !input
}
EOF

cat <<EOF >kata_test.go
package $package

import "testing"

func Test(t *testing.T) {
    if solve(false) != true {
        t.Errorf("test failed")
    }
}
EOF
