package org.example.rearrange.negative;

public final class App {

    private App() { }

    /**
     * An example program that plays a game of FizzBuzz and a game of BuzzFizz.
     * @param args Not applicable.
     */
    public static void main(final String[] args) {
        FizzBuzzGame game = new FizzBuzzGame();

        final int rounds = 100;

        for (int i = 1; i <= rounds; i++) {
            System.out.println(game.say(i, false));
        }

        for (int i = 1; i <= rounds; i++) {
            System.out.println(game.say(i, true));
        }
    }
}
