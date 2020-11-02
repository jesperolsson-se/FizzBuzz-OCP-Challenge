package org.example.evolution.tazz;

import org.example.rearrange.positive.Rule;

/**
 * Represents the Tazz rule.
 */
public class Tazz implements Rule {

    /**
     * {@inheritDoc}
     * @return Tazz, if 7 divides the number.
     *         The empty string, otherwise.
     */
    @Override
    public String say(int i) {
        return i % 7 == 0 ? "Tazz" : "";
    }
}
