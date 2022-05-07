package lol.hub.codewars.papers_please;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @see <a href="https://www.codewars.com/kata/59d582cafbdd0b7ef90000a0">codewars.com</a>
 */
public class Inspector {

    // rule strings -> regex pattern factory -> predicate factory

    // a document is considered expired if the expiration date is November 22, 1982 or earlier

    private static final Set<String> defaultDocsAll = Set.of("passport");
    private static final Set<String> defaultDocsCitizens = Set.of("ID_card");
    private static final Set<String> defaultDocsForeigners = Set.of("access_permit", "work_pass", "grant_of_asylum", "diplomatic_authorization");

    private static final Set<String> countries = Set.of("Arstotzka", "Antegria", "Impor", "Kolechia", "Obristan", "Republia", "United Federation");

    /* People Type Tokens */
    // Entrants
    // Workers
    // Foreigners
    // Citizens of <country>

    /* Structure Tokens */
    // Allow
    // Deny
    // no longer
    // require
    // vaccination
    // Wanted by the State:

    private static final Pattern criminalsPattern = Pattern.compile("Wanted by the State: (.+)");
    private static final Pattern patternWhitelist = Pattern.compile("Allow citizens of (.+)");
    private static final Pattern patternBlacklist = Pattern.compile("Deny citizens of (.+)");
    //private static final Pattern vaccinationsPattern = Pattern.compile("(.+) require (.+) vaccination");
    //private static final Pattern documentsPattern = Pattern.compile("(.+) require (.+)");

    private final Set<String> whitelist = new HashSet<>();
    private final Set<String> blacklist = new HashSet<>();
    private final Map<String, Set<String>> vaccinations = new HashMap<>();
    private final Map<String, Set<String>> documents = new HashMap<>();
    private final Set<String> criminals = new HashSet<>();

    private static List<String> split(String s) {
        return new ArrayList<>(List.of(s.split(", ")));
    }

    public void receiveBulletin(String bulletin) {
        System.out.println("------------bulletin------------");
        System.out.println(bulletin);
        System.out.println("--------------------------------");
        for (String line : bulletin.split("\n")) {

            boolean removal = line.contains("no longer ");
            if (removal) line = line.replaceAll("no longer ", "");

            // example: Wanted by the State: Hubert Popovic
            var wanteds = match(criminalsPattern, line);
            if (wanteds.size() > 0) {
                List<String> criminals = List.of(wanteds.get(0).split(", "));
                System.out.println("adding criminals: " + criminals);
                this.criminals.addAll(criminals);
            }

            // example: Allow citizens of Obristan
            // example: Allow citizens of Arstotzka, Obristan
            var wlist = match(patternWhitelist, line);
            if (wlist.size() > 0) {
                System.out.println("adding whitelist: " + wlist);
                this.whitelist.addAll(List.of(wlist.get(0).split(", ")));
            }
            // example: Deny citizens of Kolechia, Republia
            var blist = match(patternBlacklist, line);
            if (blist.size() > 0) {
                System.out.println("removing whitelist: " + blist);
                this.whitelist.removeAll(List.of(blist.get(0).split(", ")));
            }

            // TODO: vaccinations
            // example: Citizens of Antegria, Republia, Obristan require polio vaccination
            // example: Entrants no longer require tetanus vaccination
//            List<String> vacs = match(vaccinationsPattern, line);
//            for (int i = 0; i < vacs.size(); i = i + 2) {
//                String group = vacs.get(i);
//                String illnes = vacs.get(i + 1);
//                Set<String> set = vaccinations.getOrDefault(group, new HashSet<>());
//
//                if (removal) {
//                    List.of(vacs.get(1).split(", ")).forEach(set::remove);
//                } else {
//                    set.addAll(List.of(illnes.split(", ")));
//                }
//                vaccinations.put(group, set);
//
//            }

            // TODO: documents
            // example: Foreigners require access permit
            // example: Citizens of Arstotzka require ID card
            // example: Workers require work pass
            // example: Entrants require passport
            //List<String> documents = match(documentsPattern, line);

        }
    }

    private List<String> match(Pattern p, String s) {
        List<String> groups = new ArrayList<>();
        var matcher = p.matcher(s);
        if (matcher.matches()) {
            for (int g = 1; g < matcher.groupCount(); g++) {
                groups.add(matcher.group(g));
            }
        }
        return groups;
    }

    /**
     * Each day, a number of entrants line up outside the checkpoint inspection booth to gain passage into Arstotzka.
     * The inspect method will receive an object representing each entrant's set of identifying documents.
     * This object will contain zero or more properties which represent separate documents.
     * Each property will be a string value. These properties may include the following:
     */
    public String inspect(Map<String, String> person) {
        System.out.println("-------------person-------------");
        System.out.println(person);
        System.out.println("--------------------------------");

        // Conditions for passing inspection
        // - All required documents are present
        for (String doc : defaultDocsAll) {
            if (!person.containsKey(doc)) {
                return "Entry denied: missing required " + doc + ".";
            }
        }

        // - There is no conflicting information across the provided documents
        for (String doc1 : person.keySet()) {
            for (String doc2 : person.keySet()) {
                if (doc1.equals(doc2)) continue;

                Map<String, String> entries1 = readDoc(person.get(doc1));
                Map<String, String> entries2 = readDoc(person.get(doc2));

                for (Map.Entry<String, String> e1 : entries1.entrySet()) {
                    for (Map.Entry<String, String> e2 : entries2.entrySet()) {
                        if (e1 == null || e2 == null) continue;
                        if (!e1.getKey().equals(e2.getKey())) continue;

                        if (!e1.getValue().equals(e2.getValue())) {
                            return "Detainment: " + e1.getKey().replaceAll("#", " number") + " mismatch.";
                        }
                    }
                }
            }
        }

        // - All documents are current (ie. none have expired) -- a document is considered expired if the expiration date is November 22, 1982 or earlier
        // - The entrant is not a wanted criminal
        // - If a certificate_of_vaccination is required and provided, it must list the required vaccination
        // - A "worker" is a foreigner entrant who has WORK listed as their purpose on their access permit
        // - If entrant is a foreigner, a grant_of_asylum or diplomatic_authorization are acceptable in lieu of an access_permit.
        //   In the case where a diplomatic_authorization is used, it must include Arstotzka as one of the list of nations that can be accessed.

        // If the entrant passes inspection, the method should return one of the following string values:
        // - If the entrant is a citizen of Arstotzka: Glory to Arstotzka.
        // - If the entrant is a foreigner: Cause no trouble.
        // - If the entrant fails the inspection due to expired or missing documents,
        //   or their certificate_of_vaccination does not include the necessary vaccinations,
        //   return Entry denied: with the reason for denial appended.
        //   Example 1: Entry denied: passport expired.
        //   Example 2: Entry denied: missing required vaccination.
        //   Example 3: Entry denied: missing required access permit.
        // - If the entrant fails the inspection due to mismatching information between documents
        //   (causing suspicion of forgery) or if they're a wanted criminal,
        //   return Detainment: with the reason for detainment appended.
        // - If due to information mismatch, include the mismatched item. e.g.Detainment: ID number mismatch.

        // - If the entrant is a wanted criminal: Detainment: Entrant is a wanted criminal.
        // NOTE: One wanted criminal will be specified in each daily bulletin, and must be detained when received for that day only.
        //   For example, if an entrant on Day 20 has the same name as a criminal declared on Day 10, they are not to be detained for being a criminal.
        //   Also, if any of an entrant's identifying documents include the name of that day's wanted criminal
        //   (in case of mismatched names across multiple documents), they are assumed to be the wanted criminal.
        // In the case where the entrant has mismatching information and is a wanted criminal, detain for being a wanted criminal.

        // In some cases, there may be multiple reasons for denying or detaining an entrant. For this exercise, you will only need to provide one reason.

        // If the entrant meets the criteria for both entry denial and detainment, priority goes to detaining.

        String reason = "";
        // Detainment: Entrant is a wanted criminal.
        return "Glory to Arstotzka.";
    }

    private Map<String, String> readDoc(String doc) {
        Map<String, String> data = new HashMap<>();
        for (String line : doc.split("\n")) {
            var entry = line.split(": ");
            data.put(entry[0], entry[1]);
        }
        return data;
    }
}
