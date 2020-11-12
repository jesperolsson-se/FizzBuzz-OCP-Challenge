package org.example.evolution.robberlanguage;

import org.example.rearrange.positive.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Decorator for encoding a rule with robber code.
 */
public class RobberCode implements Rule {

    /**
     * The rule to decorate.
     */
    private final Rule origin;

    /**
     * Constructs a decorator that encodes a rule, so that every consonant is
     * doubled and an 'o' is inserted in-between.
     * @param origin The rule to encode.
     */
    public RobberCode(final Rule origin) {
        this.origin = origin;
    }

    /**
     * {@inheritDoc}
     * @return The origin's answer, but every consonant is doubled and an 'o' is
     *         inserted in-between.
     */
    @Override
    public String say(final int i) {
        String decoded = origin.say(i);
        Pattern consonants = Pattern.compile("([b-df-hj-np-tv-z])");
        Matcher matcher = consonants.matcher(decoded);
        return matcher.find()
                ? matcher.replaceAll("$1o$1")
                : decoded;
    }
}
