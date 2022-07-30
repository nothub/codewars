#!/usr/bin/env bash

set -o errexit
set -o nounset
set -o pipefail

log() {
    echo >&2 "$*"
}

panic() {
    log "Panic: $*"
    exit 1
}

print_usage() {
    set +o xtrace
    script_name="$(basename "${BASH_SOURCE[0]}")"
    log "Usage: ${script_name} [-v] [-h] <kataid> <language>
Options:
  -v, --verbose    Enable verbose output
  -h, --help       Print this help and exit
Example:
  ${script_name} -v 50654ddff44f800200000004 go"
}

check_dependency() {
    if ! command -v "$1" >/dev/null 2>&1; then
        log "Error: Missing dependency: $1"
        exit 1
    fi
}

check_dependency curl
check_dependency jq

while [[ $# -gt 0 ]]; do
    case $1 in
    "-v" | "--verbose")
        shift
        set -o xtrace
        ;;
    "-h" | "--help")
        print_usage
        exit 0
        ;;
    *) break ;;
    esac
done

kata_id=$1
language=$2
if [[ -z ${kata_id} || -z ${language} ]]; then
    print_usage
    exit 64
fi

json=$(curl --location --silent "https://www.codewars.com/api/v1/code-challenges/${kata_id}")
if [[ "$(printf '%s\n' "$json" | jq --raw-output 'has("slug")')" == "false" ]]; then
    panic "Unable to resolve kata id: ${kata_id}"
fi
name=$(printf '%s\n' "$json" | jq --raw-output '.slug' | sed -e 's/[^a-z0-9]/_/g')
url=$(printf '%s\n' "$json" | jq --raw-output '.url')

if [[ -d ${language} ]]; then
    cd "${language}"
else
    panic "No module for language: ${language}"
fi

source init.sh
if type init_kata >/dev/null 2>&1; then
    init_kata "${name}" "${url}"
else
    panic "No initializer for language: ${language}"
fi
