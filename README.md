# CVM count algorithm

This is the implementation of a [Count Distinct Problem](https://en.wikipedia.org/wiki/Count-distinct_problem)
in particular the [CVM algorithm](https://en.wikipedia.org/wiki/Count-distinct_problem#CVM_Algorithm)

# Run the program

## Using the scala interpreter

`scala Test <m> <n> <window size>`

where:
* m -> is the length of the random sequence
* n -> is the max number of symbols
* window size -> the window size

```bash
Bash %> scala Test.scala 30000 4000 100
Result: exact(3996), estimation(3968.0)
```

## Compile and run the bytecode

To compile the program:

`scalac *.scala`

Run the bytecode:

```bash
Bash %> scala Test 30000 4000 100
Result: exact(4000), estimation(3776.0)
```
