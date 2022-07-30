#!/usr/bin/env bash

init_kata() {
    kata="$1"
    url="$2"

    if [[ -d ${kata} ]]; then
        panic "Kata ${kata} is already present!"
    fi
    mkdir -p "${kata}"

    touch "${kata}/__init__.py"

    cat <<EOF >"${kata}/kata.py"
def solve(b: bool) -> bool:
    """\`codewars.com <$url>\`_"""
    return not b
EOF
}
