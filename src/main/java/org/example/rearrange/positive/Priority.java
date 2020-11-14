package org.example.rearrange.positive;

/**
 * Auxiliary decorator for ranking rules.
 */
public class Priority implements Rule {

    /**
     * The rule that has higher authority.
     */
    private final Rule president;

    /**
     * The rule that has less authority.
     */
    private final Rule deputy;

    /**
     * Constructs a decorator that determines which rule to apply.
     * @param president The rule that takes precedence.
     * @param deputy The rule to use as backup.
     */
    public Priority(final Rule president, final Rule deputy) {
        this.president = president;
        this.deputy = deputy;
    }

    /**
     * {@inheritDoc}
     * @return The president's answer, if available.
     *         The deputy's answer, otherwise.
     */
    @Override
    public String say(final int i) {
        String authorityStatement = president.say(i);
        return authorityStatement.isEmpty()
                ? deputy.say(i)
                : authorityStatement;
    }
}
