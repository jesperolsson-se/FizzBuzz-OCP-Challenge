package org.example.rearrange.negative;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Enclosed.class)
public class FizzBuzzGameTest
{
    /**
     * This class represents tests for a normal FizzBuzz game i.e., FizzBuzz.
     */
    @RunWith(Parameterized.class)
    public static class NormalGameTest {

        private int number;
        private String expected;

        public NormalGameTest(int number, String expected) {
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
        public void shouldPlayCorrectly() {
            FizzBuzzGame sut = new FizzBuzzGame();
            assertEquals(expected, sut.say(number, false));
        }
    }

    /**
     * This class represents tests for a rearranged FizzBuzz game i.e., BuzzFizz.
     */
    @RunWith(Parameterized.class)
    public static class RearrangedGameTest {

        private int number;
        private String expected;

        public RearrangedGameTest(int number, String expected) {
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
        public void shouldPlayCorrectly() {
            FizzBuzzGame sut = new FizzBuzzGame();
            assertEquals(expected, sut.say(number, true));
        }
    }
}