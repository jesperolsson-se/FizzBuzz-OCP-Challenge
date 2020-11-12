package org.example.rearrange.positive;

/**
 * Auxiliary decorator for composing two rules.
 */
public class Concatenation implements Rule {

    /**
     * The rule that should be invoked first.
     */
    private final Rule first;

    /**
     * The rule that should be invoked second.
     */
    private final Rule second;

    /**
     * Constructs a decorator that appends one rule to another.
     * @param first The rule to append to.
     * @param second The rule to append.
     */
    public Concatenation(final Rule first, final Rule second) {
        this.first = first;
        this.second = second;
    }

    /**
     * {@inheritDoc}
     * @return The first and second rules' answers.
     */
    @Override
    public String say(final int i) {
        return first.say(i) + second.say(i);
    }
}
