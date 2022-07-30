#!/usr/bin/env bash

init_kata() {
    kata="$1"
    url="$2"

    package="lol.hub.codewars.${kata}"
    subpath=$(echo "${package}" | sed "s/\./\//g")
    dir_src="src/main/java/${subpath}"
    dir_test="src/test/java/${subpath}"

    if [ -d "${dir_src}" ] || [ -d "${dir_test}" ]; then
        panic "Kata ${kata} is already present!"
    fi

    mkdir -p "${dir_src}"
    cat <<EOF >"${dir_src}/Kata.java"
package ${package};

/**
 * @see <a href="${url}">codewars.com</a>
 */
public class Kata {
    public static boolean solve(boolean b) {
        return !b;
    }
}
EOF

    mkdir -p "${dir_test}"
    cat <<EOF >"${dir_test}/KataTest.java"
package ${package};

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="${url}">codewars.com</a>
 */
public class KataTest {
    @Test
    public void test() {
        assertEquals(true, Kata.solve(false));
    }
}
EOF
}
