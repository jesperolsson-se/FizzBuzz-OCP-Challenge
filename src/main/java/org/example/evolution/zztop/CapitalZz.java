package org.example.evolution.zztop;

import org.example.rearrange.positive.Rule;

/**
 * Decorator for capitalizing a statement's pairs of z's.
 */
public class CapitalZz implements Rule {

    /**
     * The rule to decorate.
     */
    private final Rule origin;

    /**
     * Constructor.
     * @param origin The rule to decorate.
     */
    public CapitalZz(final Rule origin) {
        this.origin = origin;
    }

    /**
     * {@inheritDoc}
     * @return The origin's answer, but pairs of lowercase z's are capitalized.
     */
    @Override
    public String say(final int i) {
        return origin.say(i).replace("zz", "ZZ");
    }
}
