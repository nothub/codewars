#!/usr/bin/env bash

set -euo pipefail

json=$(curl --request GET --location --silent https://www.codewars.com/api/v1/code-challenges/"$1")

if [[ "$(printf '%s\n' "$json" | jq --raw-output 'has("slug")')" == "false" ]]; then
    echo 1>&2 "invalid challenge data!"
    if [[ "$(printf '%s\n' "$json" | jq --raw-output 'has("reason")')" == "true" ]]; then
        reason=$(printf '%s\n' "$json" | jq --raw-output '.reason')
        echo 1>&2 "$reason"
    fi
    exit 1
fi

name=$(printf '%s\n' "$json" | jq --raw-output '.slug' | sed -e 's/[^a-z0-9]/_/g')
url=$(printf '%s\n' "$json" | jq --raw-output '.url')

#cd go
#cd java
cd python
./init.sh "$name" "$url"
