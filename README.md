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
program said "BuzzFizz" when 15 divides the number (instead of the standard
"FizzBuzz"). Take a moment and ask yourself how you would solve that problem.
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
refactor our code base, to leave room for growth in unknown directions?

The typical solution will leverage subclassing in one way or another. After all,
isn't that what OCP is all about? Well, no, not really. Implementation
inheritence is one way to satisfy the principle, to be sure, but hardly the only
way. As a matter of fact, it's a solution that often turns out to be too rigid
to meet future needs. Hold on to that thought, and I'll demonstrate in the next
section.

An alternative implementation is available in the [rearrange positive](https://github.com/jesperolsson-se/FizzBuzz/tree/main/src/main/java/org/example/rearrange/positive) package.
As you'll notice, we've satisifed our users' needs through object composition.
The rules for "Fizz" and "Buzz" are completely decoupled from each other, but
can be wired together to create "FizzBuzz" or "BuzzFizz" when we build our
object graph.

Already, we can get a sense for why this approach is more flexible: just by
proposing a new wiring, we could satisfy needs such as "FizzFizzBuzz" (everytime
3 divides the number, say "Fizz" twice) or "Buzz>Fizz" (even when both rules are
satisfied, just say "Buzz").

True, those needs don't exist (yet), but that doesn't invalidate the point. The
design *could* satisfy them, simply by the virtue of flexibility. No extra
effort is spent on allowing such usage.

Another way to think about it is, by viewing existing requirements as nothing
more than examples of the system behaviour, we can work to avoid tunnel vision
and target fixation. We can choose a design that meets them in an almost
accidental manner, thus putting us in a prime position for responding to change.
Again, we'll explore this further in the next section.
