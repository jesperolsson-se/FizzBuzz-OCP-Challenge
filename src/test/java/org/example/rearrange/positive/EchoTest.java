package org.example.rearrange.positive;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EchoTest {

    /**
     * Given some integer,
     * When asked to say the number,
     * Then the answer be the number.
     */
    @Test
    public void shouldRepeatTheNumber()
    {
        final int number = 1;
        Echo sut = new Echo();
        assertEquals(Integer.toString(number), sut.say(number));
    }
}
