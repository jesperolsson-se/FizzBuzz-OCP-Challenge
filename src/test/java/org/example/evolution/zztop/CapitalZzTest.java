package org.example.evolution.zztop;

import org.example.rearrange.positive.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(value = Parameterized.class)
public class CapitalZzTest {

    private String original;
    private String expected;

    public CapitalZzTest(String original, String expected) {
        this.original = original;
        this.expected = expected;
    }

    /**
     * This method represents a series of number names that contain 'z' is
     * various cardinalities and permutations.
     */
    @Parameterized.Parameters(name = "Capitalized({0}) = {1}")
    public static Collection<Object[]> numberNames() {
        return Arrays.asList(new Object[][]{
                {"Fi", "Fi"},
                {"Fiz", "Fiz"},
                {"Fizz", "FiZZ"},
                {"Fizzz", "FiZZz"},
                {"Fizzzz", "FiZZZZ"},
                {"FiZz", "FiZz"},
                {"FizZ", "FizZ"},
                {"Fziz", "Fziz"},
        });
    }

    /**
     * Given some origin rule,
     * When the decorator is asked to say the name of a number,
     * Then the answer should be that of the origin, but all subsequent pairs
     * of 'z' should be capitalized.
     */
    @Test
    public void shouldCapitalizeCorrectly() {
        Rule rule1 = mock(Rule.class);
        when(rule1.say(1)).thenReturn(original);

        CapitalZz sut = new CapitalZz(rule1);
        assertEquals(expected, sut.say(1));
    }
}
