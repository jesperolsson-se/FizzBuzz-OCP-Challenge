package org.example.rearrange.positive;

/**
 * Represents the Fizz rule.
 */
public class Fizz implements Rule {

    /**
     * {@inheritDoc}
     * @return Fizz, if 3 divides the number.
     *         The empty string, otherwise.
     */
    @Override
    public String say(int i) {
        return i % 3 == 0 ? "Fizz" : "";
    }
}
