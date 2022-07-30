#!/usr/bin/env bash

init_kata() {
    kata="$1"
    url="$2"

    if [[ -d ${kata} ]]; then
        panic "Kata ${kata} is already present!"
    fi
    mkdir -p "${kata}"

    cat <<EOF >"${kata}/kata.sh"
#!/usr/bin/env bash
# ${url}

set -o errexit
set -o nounset
set -o pipefail

echo 0
EOF

    chmod +x "${kata}/kata.sh"
}
