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
        int index = 0;
        int lastCount = -1;
        do {
            Set<String> food = relations.getOrDefault(animals.get(index), Collections.emptySet());
            // check left
            if (index > 0 && food.contains(animals.get(index - 1))) {
                results.add(animals.get(index) + " eats " + animals.get(index - 1));
                animals.remove(index - 1);
                index = 0;
                continue;
            }
            // check right
            if (index < animals.size() - 1 && food.contains(animals.get(index + 1))) {
                results.add(animals.get(index) + " eats " + animals.get(index + 1));
                animals.remove(index + 1);
                index = 0;
                continue;
            }
            index++;
            // check if anything changed
            if (index >= animals.size()) {
                if (lastCount == animals.size()) break;
                lastCount = animals.size();
                index = 0;
            }
        } while (animals.size() > 1);
        results.add(String.join(",", animals));
        return results.toArray(new String[0]);
    }
}
