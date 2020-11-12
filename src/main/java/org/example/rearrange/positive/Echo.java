package org.example.rearrange.positive;

/**
 * Represents a non-modifying, numerical-textual rule.
 */
public class Echo implements Rule {

    /**
     * Constructs a rule that translates a number into a string.
     */
    public Echo() { }

    /**
     * {@inheritDoc}
     * @return The number as a text string.
     */
    @Override
    public String say(final int i) {
        return Integer.toString(i);
    }
}
