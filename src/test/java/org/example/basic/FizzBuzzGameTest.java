package org.example.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class FizzBuzzGameTest
{
    private int number;
    private String expected;

    public FizzBuzzGameTest(int number, String expected) {
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
                {15, "FizzBuzz"},
                {16, "16"},
        });
    }

    /**
     * Given some integer,
     * When the game is asked to say the name of the number,
     * Then the answer should be in accordance with the rules for FizzBuzz.
     */
    @Test
    public void shouldPlayCorrectly()
    {
        FizzBuzzGame sut = new FizzBuzzGame();
        assertEquals(expected, sut.say(number));
    }
}
