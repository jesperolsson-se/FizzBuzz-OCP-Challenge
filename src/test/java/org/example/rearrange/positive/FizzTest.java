package org.example.rearrange.positive;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzTest
{
    /**
     * Given some integer that is divisible by 3,
     * When asked to say the number,
     * Then the answer should be "Fizz".
     */
    @Test
    public void shouldSayFizzWhenDivisibleByThree()
    {
        Fizz sut = new Fizz();
        assertEquals("Fizz", sut.say(3));
    }

    /**
     * Given some integer that 3 does not divide,
     * When asked to say the number,
     * Then the answer should be the empty string.
     */
    @Test
    public void shouldBeSilentOnRemainder()
    {
        Fizz sut = new Fizz();
        assertEquals("", sut.say(1));
    }
}
