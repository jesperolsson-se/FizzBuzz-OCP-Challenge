# FizzBuzz
The Open-Closed Principle (OCP) is one of the SOLID design principles.
Consequently, it's part of what many software architects considers the
fundamentals of their craft. In spite of this, few discussions of OCP go beyond
classes and inheritance. Surprisingly often, the principle is stripped down to
implementation inheritance (and criticised by the composion-over-inheritance
movement).

In this repo, I'll challenge those ideas. To me, OCP is a much broader design
principle that encourages us to leave our software room to grow. To evolve. 

My stance is that OCP is not constrained to a select few programming language
features. The principle is more about writing modules that, to paraphrase the
Brundtland Report, *meets the needs of the present without compromising the
ability of future increments to meet their own needs*.

In this repo, we'll start off with the popular programming excercise
[FizzBuzz](https://en.wikipedia.org/wiki/Fizz_buzz). From there, I'll ask you to
think about the software design and propose my own solutions. Through this lens,
I aim to present a broader perspective of the principle.

I'll demonstrate that OCP implies that no tests should ever need to be altered. 
That OCP accelerates the product-market fit and endorses innovation. That OCP
enhances agility.

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
inheritance is one way to satisfy the principle, to be sure, but hardly the only
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

## Further evolution

Suppose that, again, a new need arises. A user segement requires that our
software can play FizzBuzzTazz (say "Tazz", when 7 divides the number). With
our OCP design, this is simple (as demonstrated in the
[evolution tazz](https://github.com/jesperolsson-se/FizzBuzz/tree/main/src/main/java/org/example/evolution/tazz) package). Please note how no existing code was 
modified. No method signatures; no method bodies. No classes and, perhaps most
importantly, no unit tests.

This is the power of the OCP and object composition. We added a new rule (one
class; a singular statement), and nothing else, and that was all we needed to
wire together a solution for an unknowable need. But that's not all, in doing so
, we enabled many more new combinations.

The additional number of combinations happens to be infinite, but for the sake
of clarity, let's constrain ourselves so that we can use no more than one
`Concatenation` and no `Priority`. Before adding Tazz, we had the following
basic building blocks: `Echo`, `Fizz`, `Buzz`. Under our constraints, our wiring
can contain zero, one, or two blocks, and we may reuse blocks. This equates to
the following thirteen arrangements (when choosing one or zero blocks, order
doesn't matter).

First | Second
--- | ---
&nbsp; | &nbsp;
Echo | &nbsp;
Fizz | &nbsp;
Buzz | &nbsp;
Echo | Echo
Echo | Fizz
Echo | Buzz
Fizz | Echo
Fizz | Fizz
Fizz | Buzz
Buzz | Echo
Buzz | Fizz
Buzz | Buzz

When we add Tazz (again, just one additional building block), we can make eight
new arrangements. The full 21 arrangements are listed in the following table.

First | Second
--- | ---
&nbsp; | &nbsp;
Echo | &nbsp;
Fizz | &nbsp;
Buzz | &nbsp;
Tazz | &nbsp;
Echo | Echo
Echo | Fizz
Echo | Buzz
Echo | Tazz
Fizz | Echo
Fizz | Fizz
Fizz | Buzz
Fizz | Tazz
Buzz | Echo
Buzz | Fizz
Buzz | Buzz
Buzz | Tazz
Tazz | Echo
Tazz | Fizz
Tazz | Buzz
Tazz | Tazz

By now, the [network effect](https://en.wikipedia.org/wiki/Network_effect) of
our design should be evident. As we implement a linear number of composable
objects, we enable a superlinear number of arrangements. Granted, not all of the
arrangements correspond to a user need. In fact, very few of them do. However,
in my opinion, that's not a problem; it's an opportunity. An opportunity for
innovation and upselling.

According to Boden (2009), combinatorial creativity—producing unfamiliar
combinations of familiar ideas—is one of the three forms of creativity. This can
be translated to our object graph: the nodes and example wirings (known
requirements) are the familiar ideas, while new wirings are unfamiliar
combinations. Hence, we can hypothesise that this kind of design lends itself
to more innovation points and, consequently, a higher expected value from
upselling.
