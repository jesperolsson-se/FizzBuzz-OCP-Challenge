package org.example.rearrange.negative;

/**
 * Represents a game of FizzBuzz. When objects of this class are asked to say
 * a number, their answer will follow the game's rules.
 */
public class FizzBuzzGame {

    /**
     * Answers what a number is called, according to the rules of FizzBuzz.
     * @param i The number to name.
     * @param rearrange Controls whether the rules for "FizzBuzz" or "BuzzFizz"
     *                  should be used.
     * @return Fizz, if 3 divides the number. Buzz, if 5 divides the number.
     *         FizzBuzz, if 3 and 5 both (i.e., 15) divides the number.
     *         Otherwise, the response is the number itself.
     *         If asked for a rearranged answer, BuzzFizz will be returned
     *         instead of FizzBuzz.
     */
    public String say(final int i, final boolean rearrange) {
        String result = "";

        final int fizzDivisor = 3;
        final int buzzDivisor = 5;

        if (!rearrange) { // Normal FizzBuzz game. "FizzBuzz"

            if (i % fizzDivisor == 0) {
                result += "Fizz";
            }

            if (i % buzzDivisor == 0) {
                result += "Buzz";
            }

        } else { // Rearranged FizzBuzz game. "BuzzFizz"

            if (i % buzzDivisor == 0) {
                result += "Buzz";
            }

            if (i % fizzDivisor == 0) {
                result += "Fizz";
            }
        }

        if (result.isEmpty()) {
            result = Integer.toString(i);
        }

        return result;
    }
}
