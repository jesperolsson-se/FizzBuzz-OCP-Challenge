package org.example.evolution.robberlanguage;

import org.example.rearrange.positive.Rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Decorator for encoding a statement with robber code.
 */
public class RobberCode implements Rule {

    private final Rule origin;

    public RobberCode(Rule origin) {
        this.origin = origin;
    }

    /**
     * {@inheritDoc}
     * @return The origin's answer, but every consonant is doubled and an 'o' is
     *         inserted in-between.
     */
    @Override
    public String say(int i) {
        String decoded = origin.say(i);
        Pattern consonants = Pattern.compile("([b-df-hj-np-tv-z])");
        Matcher matcher = consonants.matcher(decoded);
        return matcher.find() ?
                matcher.replaceAll("$1o$1")
                : decoded;
    }
}
