package org.example.rearrange.positive;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConcatenationTest {

    /**
     * Given two rules and a some number,
     * When asked to say the number,
     * Then the answer should be the first rule's answer
     * immediately followed by the second's.
     */
    @Test
    public void shouldConcatenateInOrder()
    {
        Rule rule1 = mock(Rule.class);
        when(rule1.say(1)).thenReturn("Foo");

        Rule rule2 = mock(Rule.class);
        when(rule2.say(1)).thenReturn("Bar");

        Concatenation composite = new Concatenation(rule1, rule2);
        assertEquals("FooBar", composite.say(1));
    }

}
