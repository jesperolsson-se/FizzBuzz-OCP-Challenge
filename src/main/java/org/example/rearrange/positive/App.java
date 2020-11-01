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
    }
}
