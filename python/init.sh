#!/usr/bin/env bash

set -euo pipefail

kata_name="$1"
kata_url="$2"

if [ -d "$kata_name" ]; then
    echo 1>&2 "$kata_name is already present!"
    exit 1
fi

mkdir -p "$kata_name"
cd "$kata_name"

cat <<EOF >kata.py
def solve(b: bool) -> bool:
    """\`codewars.com <$kata_url>\`_"""
    return not b
EOF
