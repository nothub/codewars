#!/usr/bin/env bash

set -euo pipefail

module="$1"
url="$2"

if [ -d "$module" ]; then
    echo 1>&2 "$module is already present!"
    exit 1
fi

mkdir -p "$module"
cd "$module"

go mod init "$module"

cat <<EOF >kata.go
package $module

// $url

func Solve(input bool) bool {
  return input
}
EOF

cat <<EOF >kata_test.go
package $module

import "testing"

func Test(t *testing.T) {
  if Solve(true) != true {
    t.Errorf("test failed")
  }
}
EOF
