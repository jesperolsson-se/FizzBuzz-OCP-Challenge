package org.example.rearrange.positive;

/**
 * Auxiliary decorator for ranking rules.
 */
public class Priority implements Rule {

    private final Rule president;
    private final Rule deputy;

    public Priority(Rule president, Rule deputy) {
        this.president = president;
        this.deputy = deputy;
    }

    /**
     * {@inheritDoc}
     * @return The president's answer, if available.
     *         The deputy's answer, otherwise.
     */
    @Override
    public String say(int i) {
        String authorityStatement = president.say(i);
        return authorityStatement.isEmpty() ? deputy.say(i) : authorityStatement;
    }
}
