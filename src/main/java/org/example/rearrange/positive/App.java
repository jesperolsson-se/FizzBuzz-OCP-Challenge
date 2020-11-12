package org.example.rearrange.positive;

public final class App {

    private App() { }

    /**
     * An example program that plays a game of FizzBuzz and a game of BuzzFizz.
     * @param args Not applicable.
     */
    public static void main(final String[] args) {
        // Caters to the user segment that wants a normal FizzBuzz game.
        Rule fizzBuzz = new Priority(
                new Concatenation(
                        new Fizz(),
                        new Buzz()
                ),
                new Echo()
        );

        final int rounds = 100;
        for (int i = 1; i <= rounds; i++) {
            System.out.println(fizzBuzz.say(i));
        }

        // Caters to the user segment that wants a rearranged FizzBuzz game.
        Rule buzzFizz = new Priority(
                new Concatenation(
                        new Buzz(),
                        new Fizz()
                ),
                new Echo()
        );

        for (int i = 1; i <= rounds; i++) {
            System.out.println(buzzFizz.say(i));
        }
    }
}
