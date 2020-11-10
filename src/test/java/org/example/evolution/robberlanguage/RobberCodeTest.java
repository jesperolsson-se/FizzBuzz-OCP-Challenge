package org.example.evolution.robberlanguage;

import org.example.rearrange.positive.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RobberCodeTest {

    /**
     * Given an origin rule that speaks nothing but vowels,
     * When the decorator is asked to say the name of the number,
     * Then the answer should be unmodified.
     */
    @Test
    public void shouldNotModifyVowels() {
        Rule rule1 = mock(Rule.class);
        when(rule1.say(1)).thenReturn("a");

        RobberCode sut = new RobberCode(rule1);
        assertEquals("a", sut.say(1));
    }

    /**
     * Given an origin rule that speaks one consonant,
     * When the decorator is asked to say the name of the number,
     * Then the answer should append that consonant with an 'o' and itself.
     */
    @Test
    public void shouldModifySingularConsonant() {
        Rule rule1 = mock(Rule.class);
        when(rule1.say(1)).thenReturn("b");

        RobberCode sut = new RobberCode(rule1);
        assertEquals("bob", sut.say(1));
    }

    /**
     * Given an origin rule that speaks several consonant,
     * When the decorator is asked to say the name of the number,
     * Then the answer should, for each consonant,
     * append that consonant with an 'o' and itself.
     */
    @Test
    public void shouldModifyMultipleConsonant() {
        Rule rule1 = mock(Rule.class);
        when(rule1.say(1)).thenReturn("bc");

        RobberCode sut = new RobberCode(rule1);
        assertEquals("bobcoc", sut.say(1));
    }
}
