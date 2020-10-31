# FizzBuzz
Toy project for demonstrating one aspect of the Open-Closed Principle, using the
popular programming excercise [FizzBuzz](https://en.wikipedia.org/wiki/Fizz_buzz).

## The basic problem
Simply put, FizzBuzz is a game about division. Taking turns, the players count
the integers. When 3 divides the number, the active player says "Fizz" or
is elimiated. Similarly, numbers divisible by 5 and 15 are, respectively, "Buzz"
and "FizzBuzz". The table below presents the breakdown of the sixteen first
turns of a correctly played FizzBuzz game.

Number | Word
--- | ---
1 | 1
2 | 2
3 | Fizz
4 | 4
5 | Buzz
6 | Fizz
7 | 7
8 | 8
9 | Fizz
10 | Buzz
11 | 11
12 | Fizz
13 | 13
14 | 14
15 | FizzBuzz
16 | 16

Perhaps unsurprisingly, FizzBuzz has grown to become a popular programming
exercise. It's a small, well-defined problem that also hides a couple of caveats
that aren't obvious to everyone at first glance. In fact, FizzBuzz is so popular
that it shows up in recruitment processes every now and then.

An example implementation of FizzBuzz is located in package [basic](https://github.com/jesperolsson-se/FizzBuzz/tree/main/src/main/java/org/example/basic)

## A first evolution

So far, the FizzBuzz program looks decent. Sure, there are numerous alternative
solutions, each of which make slightly different trade-offs. Some might prefer
to extract the no remainder check. Others might want to separate the Fizzing and
Buzzing from the formatting. All of that, however, is besides the main point. As
we'll see, moving forward, such preferences are small details compared to other
design decisions.

Still, preferences are an interesting consideration. Suppose a portion of our
users really like the idea behind FizzBuzz, but think it would be cute if the
program said "BuzzFizz" when the number divides 15 (instead of the standard
"FizzBuzz"). Take a moment and ask yourself, how would you solve that problem?
To clarify, our FizzBuzz module (the same binary) needs to cater to two
different user segments at the same time.

When you have an answer, please consider the example implementation in the
[rearrange negative](https://github.com/jesperolsson-se/FizzBuzz/tree/main/src/main/java/org/example/rearrange/negative) package.
I'd say that's a pretty typical solution, but I'd also call it a bad solution
because it's inflexible and doesn't leave much room for growth.

Further, we can see that the previous iteration violated OCP, as we could not
evolve our software without modifying it. That's unfortunate, but perhaps
acceptable: there was no indication that new requirements would be added. At the
same time, this should be expected to be the norm. After all, as Ivar Jacobson
said: "All systems change during their life cycles. This must be borne in mind
when developing systems expected to last longer than the first version."

Still, what's done, is done. We can't change the fact that the previous version
violated OCP. What we can do, is determine how we want to approach the uncertain
future. Are we willing to put down our chips on the current version being the
final one? Do we (honestly) believe that a quick-and-dirty solution will yield
sufficient return on investment to compensate for the technical debt? I don't.
And for the sake of argument, let's assume you don't, either. So, how would you
refactor our code base, to leave room of growth in unknown directions?
