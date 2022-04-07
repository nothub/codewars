package lol.hub.codewars.count_ip_addresses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountIPAddressesTest {
    @Test
    public void test1() {
        assertEquals(50, CountIPAddresses.ipsBetween("10.0.0.0", "10.0.0.50"));
    }

    @Test
    public void test2() {
        assertEquals(246, CountIPAddresses.ipsBetween("20.0.0.10", "20.0.1.0"));
    }

    @Test
    public void test3() {
        assertEquals((1L << 32L) - 1L, CountIPAddresses.ipsBetween("0.0.0.0", "255.255.255.255"));
    }
}
