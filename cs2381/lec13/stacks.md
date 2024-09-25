
# New Abstract Data Structure: Stack

Previously, one abstract data structure:

 - List
   - ArrayList
   - ConsList
 - Stack
   - ArrayList
     - push - The back of the ArrayList is the top of the stack (so use add)
     - pop - Get last item, reduce size by one
     - isEmpty - Is the list size 0?
   - ConsList
     - push - The front of the consList is the top of the stack (so use cons)
     - pop - Get first item with first(), set our list to be the rest()
     - isEmpty - We use isEmpty on our list


A Stack is:

 - A sequence of items.
 - Restricted set of operations:
   - push - Adds an item to the top
   - pop - Gets the top item, removing it from the stack
   - isEmpty - Checks if the stack is empty
 - Sometimes a couple of bonus operations
   - peek - Look at top item without removing it
   - size - Get the # of items on the stack
