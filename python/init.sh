#!/usr/bin/env bash

set -euo pipefail

package="$1"
url="$2"

if [ -d "$package" ]; then
    echo 1>&2 "$package is already present!"
    exit 1
fi

mkdir -p "$package"
cd "$package"

touch __init__.py

cat <<EOF >kata.py
def solve(b: bool) -> bool:
    """\`codewars.com <$url>\`_"""
    return not b
EOF
