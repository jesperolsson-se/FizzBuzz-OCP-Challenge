package org.example.rearrange.positive;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PriorityTest {

    /**
     * Given a president, a deputy and some number,
     * When asked to say the number,
     * When the president has something to say,
     * Then the answer should be the president's answer.
     */
    @Test
    public void shouldIgnoreDeputyWhenThePresidentSpeaks()
    {
        Rule president = mock(Rule.class);
        when(president.say(1)).thenReturn("Foo");

        Rule deputy = mock(Rule.class);
        when(deputy.say(1)).thenReturn("Bar");

        Priority sut = new Priority(president, deputy);
        assertEquals("Foo", sut.say(1));
    }

    /**
     * Given a president, a deputy and some number,
     * When asked to say the number,
     * When the president is non-committal,
     * Then the answer should be the deputy's answer.
     */
    @Test
    public void shouldListenToTheDeputyWhenThePresidentIsSilent()
    {
        Rule president = mock(Rule.class);
        when(president.say(1)).thenReturn("");

        Rule deputy = mock(Rule.class);
        when(deputy.say(1)).thenReturn("Bar");

        Priority sut = new Priority(president, deputy);
        assertEquals("Bar", sut.say(1));
    }
}
