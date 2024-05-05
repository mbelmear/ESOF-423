package org.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BozemanTest extends TestCase {
    @Test
    void testIsItGrowing(){
        assertTrue(Bozeman.IsItGrowing());

        Bozeman b = new Bozeman();
        Bozeman b2 = new Bozeman();

        assertNotEquals(b, b2);
    }

    @Test
    void testWeatherAdviceException(){
        assertThrows(IllegalArgumentException.class, () -> Bozeman.weatherAdvisory(-5, 0));
    }

    @Test
    void testWeatherAdviceDangerous(){
        assertEquals("CANCEL", Bozeman.weatherAdvisory(80, 30));
        assertEquals("CANCEL", Bozeman.weatherAdvisory(60, 50));
        assertEquals("CANCEL", Bozeman.weatherAdvisory(50, 15));
    }

    @Test
    void testWeatherAdvisoryConcerning(){
        assertEquals("WARN", Bozeman.weatherAdvisory(50, 10));
        assertEquals("WARN", Bozeman.weatherAdvisory(30, 20));
    }

    @Test
    void testWeatherAdvisoryClear(){
        assertEquals("ALL CLEAR", Bozeman.weatherAdvisory(30, 6));
    }
}