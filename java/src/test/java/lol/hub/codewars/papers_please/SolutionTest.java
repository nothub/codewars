package lol.hub.codewars.papers_please;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
/* Test Example

String bulletin = "Entrants require passport\n" +
    "Allow citizens of Arstotzka, Obristan";

Inspector inspector = new Inspector();
inspector.receiveBulletin(bulletin);

Map<String, String> entrant1 = new HashMap<>();
entrant1.put("passport", "ID#: GC07D-FU8AR\n" +
    "NATION: Arstotzka\n" +
    "NAME: Guyovich, Russian\n" +
    "DOB: 1933.11.28\n" +
    "SEX: M\n" +
    "ISS: East Grestin\n" +
    "EXP: 1983.07.10\n"
);

inspector.inspect(entrant1); // "Glory to Arstotzka." */

    @Test
    public void preliminaryTraining() {
        Inspector inspector = new Inspector();
        inspector.receiveBulletin("Entrants require passport\nAllow citizens of Arstotzka, Obristan");

        Map<String, String> josef = new HashMap<>();
        josef.put("passport", "ID#: GC07D-FU8AR\nNATION: Arstotzka\nNAME: Costanza, Josef\nDOB: 1933.11.28\nSEX: M\nISS: East Grestin\nEXP: 1983.03.15");

        Map<String, String> guyovich = new HashMap<>();
        guyovich.put("access_permit", "NAME: Guyovich, Russian\nNATION: Obristan\nID#: TE8M1-V3N7R\nPURPOSE: TRANSIT\nDURATION: 14 DAYS\nHEIGHT: 159cm\nWEIGHT: 60kg\nEXP: 1983.07.13");

        Map<String, String> roman = new HashMap<>();
        roman.put("passport", "ID#: WK9XA-LKM0Q\nNATION: United Federation\nNAME: Dolanski, Roman\nDOB: 1933.01.01\nSEX: M\nISS: Shingleton\nEXP: 1983.05.12");
        roman.put("grant_of_asylum", "NAME: Dolanski, Roman\nNATION: United Federation\nID#: Y3MNC-TPWQ2\nDOB: 1933.01.01\nHEIGHT: 176cm\nWEIGHT: 71kg\nEXP: 1983.09.20");

        assertEquals("Glory to Arstotzka.", inspector.inspect(josef));
        assertEquals("Entry denied: missing required passport.", inspector.inspect(guyovich));
        assertEquals("Detainment: ID number mismatch.", inspector.inspect(roman));
    }
}
