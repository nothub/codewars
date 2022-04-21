package lol.hub.codewars.sort_binary_tree_by_levels;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.codewars.com/kata/52bef5e3588c56132c0003bc">codewars.com</a>
 */
class Kata {
    public static List<Integer> treeByLevels(Node node) {
        if (node == null) return Collections.emptyList();
        Map<Integer, List<Node>> map = new HashMap<>();
        walk(node, map);
        return map.keySet().stream()
            .sorted()
            .map(map::get)
            .flatMap(Collection::stream)
            .map(n -> n.value)
            .collect(Collectors.toUnmodifiableList());
    }

    static void walk(Node node, Map<Integer, List<Node>> map) {
        map.computeIfAbsent(0, list -> new ArrayList<>()).add(node);
        walk(node, map, 1);
    }

    static void walk(Node node, Map<Integer, List<Node>> map, int level) {
        if (node.left != null) map.computeIfAbsent(level, list -> new ArrayList<>()).add(node.left);
        if (node.right != null) map.computeIfAbsent(level, list -> new ArrayList<>()).add(node.right);
        if (node.left != null) walk(node.left, map, level + 1);
        if (node.right != null) walk(node.right, map, level + 1);
    }
}
