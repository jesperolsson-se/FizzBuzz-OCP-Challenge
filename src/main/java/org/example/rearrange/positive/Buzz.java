package org.example.rearrange.positive;

/**
 * Represents the Buzz rule.
 */
public class Buzz implements Rule {

    /**
     * {@inheritDoc}
     * @return Buzz, if 5 divides the number.
     *         The empty string, otherwise.
     */
    @Override
    public String say(int i) {
        return i % 5 == 0 ? "Buzz" : "";
    }
}
