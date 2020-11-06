package org.example.evolution.zztop;

import org.example.rearrange.positive.Rule;

/**
 * Decorator for capitalizing a statement's pairs of z's.
 */
public class CapitalZz implements Rule {

    private final Rule origin;

    public CapitalZz(Rule origin) {
        this.origin = origin;
    }

    /**
     * {@inheritDoc}
     * @return The origin's answer, but pairs of lowercase z's are capitalized.
     */
    @Override
    public String say(int i) {
        return origin.say(i).replace("zz", "ZZ");
    }
}
