package org.example.evolution.tazz;

import org.example.rearrange.positive.*;

public class App {

    public static void main( String[] args ) {

        // Caters to the user segment that wants a FizzBuzzTazz game ("FizzBuzzTazz").
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

        for (int i = 1; i <= 200; i++) {
            System.out.println(fizzBuzzTazz.say(i));
        }
    }
}
