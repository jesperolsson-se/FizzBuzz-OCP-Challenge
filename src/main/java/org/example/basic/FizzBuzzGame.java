package org.example.basic;

/**
 * Represents a game of FizzBuzz. When objects of this class are asked to say
 * a number, their answer will follow the game's rules.
 */
public class FizzBuzzGame {

    /**
     * Answers what a number is called, according to the rules of FizzBuzz.
     * @param i The number to name.
     * @return Fizz, if 3 divides the number. Buzz, if 5 divides the number.
     *         FizzBuzz, if 3 and 5 both (i.e., 15) divides the number.
     *         Otherwise, the response is the number itself.
     */
    public String say(int i) {
        String result = "";

        if (i % 3 == 0) {
            result += "Fizz";
        }

        if (i % 5 == 0) {
            result += "Buzz";
        }

        if (result.isEmpty()) {
            result = Integer.toString(i);
        }

        return result;
    }
}
