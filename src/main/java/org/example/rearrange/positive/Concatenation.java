package org.example.rearrange.positive;

/**
 * Auxiliary decorator for composing two rules.
 */
public class Concatenation implements Rule {

    private final Rule first;
    private final Rule second;

    public Concatenation(Rule first, Rule second) {

        this.first = first;
        this.second = second;
    }

    /**
     * {@inheritDoc}
     * @return The first and second rules' answers.
     */
    @Override
    public String say(int i) {
        return first.say(i) + second.say(i);
    }
}