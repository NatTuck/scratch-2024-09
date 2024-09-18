

# Functional Programming

Phoenix Framework:

 - Server side: Elixir
 - Browser side: JavaScript

Elixir:

 - Elixir is built on the Erlang Virtual Machine (the BEAM)
 - Elixir has the same semantics and runtime behavior as Erlang,
   but with modern syntax and a modern standard library.
 - The main design goal of Erlang was reliability.
   - Erlang is a Functional programming language
   - Erlang has a design focus on distribution and concurrency

Elixir is a functional language:

Functional languages have three key properties:

 - First class functions, but most modern languages do that
 - Immutable data 
 - Pure functions
   - No side effects
   - All a pure function can do is compute and return a value
   - That value will always be the same as long as the inputs to the function are the same.
   - Function is deterministic

```js
function addFive(x) {
    // imagine this is very computationally expensive
    return x + 5;
}
```

```js
var n = 10;

function addNextN(x) {
    n += 1;
    return x + 1;
}
```

Drawbacks of functional programming:

 - If you're used to procedural or OO programming, it's werid.
 - Progams need side effects to be useful, so whatever mechanisms
   a functional language uses to do stuff can be weird.
 

Benefits of functional programming:

 - Easier to reason about pure functions. 
   - Functions are deterministic.
   - Functions act like mathematical functions, so mathematical reasoning
     applies.
   - Functions are easy to test - all you need to test is that expected outputs
     match given expected inputs.
 - Easier to reason about immutable data.
   - It never changes out from under you.
   - That's true even in, e.g., multithreaded code where immutable data
     eliminates the problem of data races.


```
// OO is anti-functional 
class Dog {
   int ageInYears;
   
   void getOlder() {
      this.age += 1; 
   }
}
```


```
var now = new Date();

var pet = new Pet({birthdate: now})
// Pet is now born today

subtractOneDay(now);

// Now we have a variable named "now" containing a date from yesterday.
// Also, the pet is now born yesterday unless it copied the date object.
```


# How does this work for our apps?

Initially, a web app sounds like a pure function:

 - Argument: An HTTP request.
 - Return Value: An HTTP response.

As things get more complicated, the model needs to be a bit more compliated.

 - Step 1:
   - A pure function transforms (HTTP Request) => (SQL Queries)
 - Step 2:
   - Our framework runs those SQL queries.
 - Step 3:
   - A pure function transforms (HTTP Reqest, SQL results) => (HTTP Response)



