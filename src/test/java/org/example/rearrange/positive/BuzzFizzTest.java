package org.example.rearrange.positive;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * System test for validating that a FizzBuzz game can be played.
 */
@RunWith(value = Parameterized.class)
public class BuzzFizzTest {

    private int number;
    private String expected;

    public BuzzFizzTest(int number, String expected) {
        this.number = number;
        this.expected = expected;
    }

    /**
     * This method represents the correct answers to the first sixteen integers.
     */
    @Parameterized.Parameters(name = "play({0}) = {1}")
    public static Collection<Object[]> sixteenFirstAnswers() {
        return Arrays.asList(new Object[][]{
                {1, "1"},
                {2, "2"},
                {3, "Fizz"},
                {4, "4"},
                {5, "Buzz"},
                {6, "Fizz"},
                {7, "7"},
                {8, "8"},
                {9, "Fizz"},
                {10, "Buzz"},
                {11, "11"},
                {12, "Fizz"},
                {13, "13"},
                {14, "14"},
                {15, "BuzzFizz"},
                {16, "16"},
        });
    }

    /**
     * Given some integer,
     * When the game is asked to say the name of the number,
     * Then the answer should be in accordance with the rules for BuzzFizz.
     */
    @Test
    public void shouldPlayCorrectly()
    {
        Rule sut = new Priority(
                new Concatenation(
                        new Buzz(),
                        new Fizz()
                ),
                new Echo()
        );
        assertEquals(expected, sut.say(number));
    }
}
