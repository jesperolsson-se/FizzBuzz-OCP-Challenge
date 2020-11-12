package org.example.rearrange.positive;

/**
 * Represents the Buzz rule.
 */
public class Buzz implements Rule {

    /**
     * The number that should divide the input, in order to trigger the rule.
     */
    private final int divisor = 5;

    /**
     * {@inheritDoc}
     * @return Buzz, if 5 divides the number.
     *         The empty string, otherwise.
     */
    @Override
    public String say(final int i) {
        return i % divisor == 0 ? "Buzz" : "";
    }
}
