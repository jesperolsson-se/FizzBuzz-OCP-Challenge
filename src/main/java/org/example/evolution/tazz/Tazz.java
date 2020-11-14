package org.example.evolution.tazz;

import org.example.rearrange.positive.Rule;

/**
 * Represents the Tazz rule.
 */
public class Tazz implements Rule {

    /**
     * The number that should divide the input, in order to trigger the rule.
     */
    private final int divisor = 7;

    /**
     * {@inheritDoc}
     * @return Tazz, if 7 divides the number.
     *         The empty string, otherwise.
     */
    @Override
    public String say(final int i) {
        return i % divisor == 0 ? "Tazz" : "";
    }
}
