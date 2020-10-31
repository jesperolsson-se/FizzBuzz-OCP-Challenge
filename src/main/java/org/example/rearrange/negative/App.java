package org.example.rearrange.negative;

public class App
{
    public static void main( String[] args )
    {
        FizzBuzzGame game = new FizzBuzzGame();
        for (int i = 1; i <= 100; i++) {
            System.out.println(game.say(i, false));
        }

        for (int i = 1; i <= 100; i++) {
            System.out.println(game.say(i, true));
        }
    }
}
