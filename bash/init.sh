#!/usr/bin/env bash

set -euo pipefail

slug="$1"
url="$2"

if [ -d "$slug" ]; then
    echo 1>&2 "$slug is already present!"
    exit 1
fi

mkdir -p "$slug"
cd "$slug"

cat <<EOF >kata.sh
#!/usr/bin/env bash
# $url
set -e
echo 0
EOF

chmod +x kata.sh
