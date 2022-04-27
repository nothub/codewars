#!/usr/bin/env bash

set -euo pipefail

id=$1
lang=$2

if [ ! -d "$lang" ]; then
    echo 1>&2 "no implementation for: $lang"
    exit 1
fi

json=$(curl --request GET --location --silent https://www.codewars.com/api/v1/code-challenges/"$id")

if [[ "$(printf '%s\n' "$json" | jq --raw-output 'has("slug")')" == "false" ]]; then
    echo 1>&2 "unresolved kata id: $id"
    exit 1
fi

name=$(printf '%s\n' "$json" | jq --raw-output '.slug' | sed -e 's/[^a-z0-9]/_/g')
url=$(printf '%s\n' "$json" | jq --raw-output '.url')

cd "$2"
./init.sh "$name" "$url"
