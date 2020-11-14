package org.example.evolution.tazz;

import org.example.rearrange.positive.Buzz;
import org.example.rearrange.positive.Concatenation;
import org.example.rearrange.positive.Echo;
import org.example.rearrange.positive.Fizz;
import org.example.rearrange.positive.Priority;
import org.example.rearrange.positive.Rule;

public final class App {

    private App() { }

    /**
     * An example program that plays a game of FizzBuzzTazz.
     * @param args Not applicable.
     */
    public static void main(final String[] args) {

        // Caters to the user segment that wants a FizzBuzzTazz game.
        Rule fizzBuzzTazz = new Priority(
                new Concatenation(
                        new Concatenation(
                                new Fizz(),
                                new Buzz()
                        ),
                        new Tazz()
                ),
                new Echo()
        );

        final int rounds = 200;
        for (int i = 1; i <= rounds; i++) {
            System.out.println(fizzBuzzTazz.say(i));
        }
    }
}
