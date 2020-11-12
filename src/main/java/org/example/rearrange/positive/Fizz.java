package org.example.rearrange.positive;

/**
 * Represents the Fizz rule.
 */
public class Fizz implements Rule {

    /**
     * The number that should divide the input, in order to trigger the rule.
     */
    private final int divisor = 3;

    /**
     * {@inheritDoc}
     * @return Fizz, if 3 divides the number.
     *         The empty string, otherwise.
     */
    @Override
    public String say(final int i) {
        return i % divisor == 0 ? "Fizz" : "";
    }
}
