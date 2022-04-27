#!/usr/bin/env bash

set -euo pipefail

dir_src_root="$(dirname "$(readlink -f "$0")")"

package="lol.hub.codewars.$1"
dir_src="src/main/java/lol/hub/codewars/$1"
dir_test="src/test/java/lol/hub/codewars/$1"
kata_url="$2"

if [ -d "$dir_src" ] || [ -d "$dir_test" ]; then
    echo 1>&2 "$1 is already present!"
    exit 1
fi

mkdir -p "$dir_src"
cd "$dir_src"

cat <<EOF >Kata.java
package $package;

/**
 * @see <a href="$kata_url">codewars.com</a>
 */
public class Kata {
    public static boolean solve(boolean b) {
        return !b;
    }
}
EOF

cd "$dir_src_root"
mkdir -p "$dir_test"
cd "$dir_test"

cat <<EOF >KataTest.java
package $package;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KataTest {
    @Test
    public void test() {
        assertEquals(true, Kata.solve(false));
    }
}
EOF
