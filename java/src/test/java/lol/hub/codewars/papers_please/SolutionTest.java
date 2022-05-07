package lol.hub.codewars.papers_please;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void test1() {
        Inspector inspector = new Inspector();
        inspector.receiveBulletin("Entrants require passport\nAllow citizens of Arstotzka, Obristan");

        Map<String, String> josef = new HashMap<>();
        josef.put("passport", "ID#: GC07D-FU8AR\nNATION: Arstotzka\nNAME: Costanza, Josef\nDOB: 1933.11.28\nSEX: M\nISS: East Grestin\nEXP: 1983.03.15");

        assertEquals("Glory to Arstotzka.", inspector.inspect(josef));
    }

    @Test
    public void test2() {
        Inspector inspector = new Inspector();
        inspector.receiveBulletin("Entrants require passport\nAllow citizens of Arstotzka, Obristan");

        Map<String, String> guyovich = new HashMap<>();
        guyovich.put("access_permit", "NAME: Guyovich, Russian\nNATION: Obristan\nID#: TE8M1-V3N7R\nPURPOSE: TRANSIT\nDURATION: 14 DAYS\nHEIGHT: 159cm\nWEIGHT: 60kg\nEXP: 1983.07.13");

        assertEquals("Entry denied: missing required passport.", inspector.inspect(guyovich));
    }

    @Test
    public void test3() {
        Inspector inspector = new Inspector();
        inspector.receiveBulletin("Entrants require passport\nAllow citizens of Arstotzka, Obristan");

        Map<String, String> roman = new HashMap<>();
        roman.put("passport", "ID#: WK9XA-LKM0Q\nNATION: United Federation\nNAME: Dolanski, Roman\nDOB: 1933.01.01\nSEX: M\nISS: Shingleton\nEXP: 1983.05.12");
        roman.put("grant_of_asylum", "NAME: Dolanski, Roman\nNATION: United Federation\nID#: Y3MNC-TPWQ2\nDOB: 1933.01.01\nHEIGHT: 176cm\nWEIGHT: 71kg\nEXP: 1983.09.20");

        assertEquals("Detainment: ID number mismatch.", inspector.inspect(roman));
    }

}
