package org.example.rearrange.positive;

/**
 * Represents a non-modifying, numerical-textual rule.
 */
public class Echo implements Rule {

    public Echo() { }

    /**
     * {@inheritDoc}
     * @return The number as a text string.
     */
    @Override
    public String say(int i) {
        return Integer.toString(i);
    }
}
