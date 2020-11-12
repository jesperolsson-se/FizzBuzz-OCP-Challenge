package org.example.rearrange.positive;

/**
 * Represents a rule for how to phrase a number, in words.
 */
public interface Rule {

    /**
     * Answers what a number is called, according to the encapsulated rule.
     * @param i The number to name.
     * @return A textual representation of how what to call the number.
     */
    String say(int i);
}
