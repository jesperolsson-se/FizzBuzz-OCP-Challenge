package org.example.rearrange.positive;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuzzTest
{
    /**
     * Given some integer that is divisible by 5,
     * When asked to say the number,
     * Then the answer should be "Buzz".
     */
    @Test
    public void shouldSayBuzzWhenDivisibleByFive()
    {
        Buzz sut = new Buzz();
        assertEquals("Buzz", sut.say(5));
    }

    /**
     * Given some integer that 5 does not divide,
     * When asked to say the number,
     * Then the answer should be the empty string.
     */
    @Test
    public void shouldBeSilentOnRemainder()
    {
        Buzz sut = new Buzz();
        assertEquals("", sut.say(1));
    }
}
