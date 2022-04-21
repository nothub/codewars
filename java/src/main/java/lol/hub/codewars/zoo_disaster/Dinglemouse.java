package lol.hub.codewars.zoo_disaster;

import java.util.*;

import static java.util.Map.entry;

/**
 * @see <a href="https://www.codewars.com/kata/5902bc7aba39542b4a00003d">codewars.com</a>
 */
public class Dinglemouse {

    private static final Map<String, Set<String>> relations = Map.ofEntries(
        entry("antelope", Set.of("grass")),
        entry("bear", Set.of("big-fish", "bug", "chicken", "cow", "leaves", "sheep")),
        entry("big-fish", Set.of("little-fish")),
        entry("bug", Set.of("leaves")),
        entry("chicken", Set.of("bug")),
        entry("cow", Set.of("grass")),
        entry("fox", Set.of("chicken", "sheep")),
        entry("giraffe", Set.of("leaves")),
        entry("lion", Set.of("antelope", "cow")),
        entry("panda", Set.of("leaves")),
        entry("sheep", Set.of("grass"))
    );

    public static String[] whoEatsWho(final String zoo) {
        List<String> results = new ArrayList<>();
        results.add(zoo);
        List<String> animals = new ArrayList<>(List.of(zoo.split(",")));
        int i = 0;
        while (animals.size() > 1) {
            Set<String> food = relations.getOrDefault(animals.get(i), Collections.emptySet());
            if (i > 0 && food.contains(animals.get(i - 1))) {
                results.add(animals.get(i) + " eats " + animals.get(i - 1));
                animals.remove(i - 1);
                i = 0;
            } else if (i < animals.size() - 1 && food.contains(animals.get(i + 1))) {
                results.add(animals.get(i) + " eats " + animals.get(i + 1));
                animals.remove(i + 1);
                i = 0;
            } else {
                i++;
                if (i >= animals.size()) i = 0;
            }
        }
        results.add(animals.get(0));
        return results.toArray(new String[0]);
    }
}
