package org.example.evolution.tazz;

import org.example.rearrange.positive.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * System test for validating that a FizzBuzzTazz game can be played.
 */
@RunWith(value = Parameterized.class)
public class FizzBuzzTazzTest {

    private int number;
    private String expected;

    public FizzBuzzTazzTest(int number, String expected) {
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
                {3, "Fizz"},
                {5, "Buzz"},
                {7, "Tazz"},
                {15, "FizzBuzz"},
                {21, "FizzTazz"},
                {35, "BuzzTazz"},
                {105, "FizzBuzzTazz"},
        });
    }

    /**
     * Given some integer,
     * When the game is asked to say the name of the number,
     * Then the answer should be in accordance with the rules for FizzBuzzTazz.
     */
    @Test
    public void shouldPlayCorrectly()
    {
        Rule sut = new Priority(
                new Concatenation(
                        new Concatenation(
                                new Fizz(),
                                new Buzz()
                        ),
                        new Tazz()
                ),
                new Echo()
        );
        assertEquals(expected, sut.say(number));
    }
}
