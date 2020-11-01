package org.example.evolution.tazz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TazzTest
{
    /**
     * Given some integer that is divisible by 7,
     * When asked to say the number,
     * Then the answer should be "Tazz".
     */
    @Test
    public void shouldSayTazzWhenDivisibleBySeven()
    {
        Tazz sut = new Tazz();
        assertEquals("Tazz", sut.say(7));
    }

    /**
     * Given some integer that 7 does not divide,
     * When asked to say the number,
     * Then the answer should be the empty string.
     */
    @Test
    public void shouldBeSilentOnRemainder()
    {
        Tazz sut = new Tazz();
        assertEquals("", sut.say(1));
    }
}
