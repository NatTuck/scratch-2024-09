
# CS2381 Lab 02: Rocket Lander

**Assignment Overview**

For this assignment you will be completing a simple game about landing a rocket.

The rocket should:
 
 - Start at the top of the screen
 - Fall under the influence of gravity
 - When the user presses space, burn a unit of fuel to accelerate upwards
 - Be able to land on the ground safely (at a velocity under 30) if the
   user times their burns well
 - Explode if it lands when moving too fast

The game is almost complete.


**Pair Programming**

For this assignment (and most labs in this course), you will work with
a partner doing pair programming.

In pair programming, both partners should sit in front of one computer
with one person at the keyboard. The person at the keyboard is the
"pilot", the other parter is the "co-pilot".

The pilot types stuff while the co-pilot observes, offers suggestions,
and points out mistakes.

After each step of the lab, the pilot and co-pilot should switch
roles.


**New Concept: records in Java**

In Java, you can define a new data type by creating a class. Classes
have fields to store the data associated with an object of the new
type, and methods which contain logic associated with the new type
including logic to access and manipulate the fields of instance objects.

For new types that are specifically intended to represent data values,
Java provides a special kind of class called a record. Records are
like regular classes except:

 - You specify the fields in parens after the record name.
 - The constructor is automatically generated.
 - Some other common methods are automatically generated.
 - You access the fields with auto-generated accessor methods. (i.e.
   if you have a record object "rec" with a field "foo" you access
   that field by saying "rec.foo()")
 - The value of the fields of a record object can't be changed after
   the object is constructed. If you want an object with a different
   logical value, you need to create a new object.

The data type representing the instantaneous state of our rocket is a
record. State changes are handled by creating new Rocket objects with
different values in its fields.


**What to do, specifically.**

First, complete the provided program:

 - Unpack the tar archive (```tar xzvf labXX-starter.tar.gz```).
 - Rename the directory to "yourname-labXX".
 - Open it in VSCode.
 - There are three tests in RocketShould.java
 - Modify the method bodies in Rocket.java so that all three tests pass.
 - Don't modify the test code.
 - Don't modify code in the worldx namespace. That's the "game engine"
   code that the application code is using.

Once the tests pass, submit to Inkfish:

 - Run "mvn clean".
 - Run "perl test.pl" locally to confirm that the tests will pass on the
   server.
 - Pack up your solution archive with (```tar czvf yourname-labXX.tar.gz yourname-labXX```).
 - Upload to Inkfish
 - Watch the tests run and see your script score to make sure there are no unexpected issues.

