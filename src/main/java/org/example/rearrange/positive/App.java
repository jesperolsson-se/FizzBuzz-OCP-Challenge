package org.example.rearrange.positive;

public class App
{
    public static void main( String[] args )
    {
        // Caters to the user segment that wants a normal FizzBuzz game ("FizzBuzz").
        Rule fizzBuzz = new Priority(
                new Concatenation(
                        new Fizz(),
                        new Buzz()
                ),
                new Echo()
        );

        for (int i = 1; i <= 100; i++) {
            System.out.println(fizzBuzz.say(i));
        }

        // Caters to the user segment that wants a rearranged FizzBuzz game ("BuzzFizz").
        Rule buzzFizz = new Priority(
                new Concatenation(
                        new Buzz(),
                        new Fizz()
                ),
                new Echo()
        );

        for (int i = 1; i <= 100; i++) {
            System.out.println(buzzFizz.say(i));
        }
    }
}
