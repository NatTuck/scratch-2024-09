
# Lab 09: Maps and Balanced Trees

In this lab, you will complete two map implementations.

Feel free to put whatever you want in App#main for experimentation.

## Problems

**Problem 1. Scapegoat Tree**

Modify the code in TreeMap.java to keep the tree balanced using the
Scapegoat Tree strategy.

**Part 1.1: Write TreeMap#fromList**

Given a list of entries, this static method should produce a balanced
subtree using the following procedure:

 - Take the middle node as the root.
 - Use TreeMap#fromList on the right half to produce the right subtree.
 - Use TreeMap#fromList on the left half to produce the left subtree.
 - Think: What tree should you get from an empty list?
 
**Part 1.2: Implement the Scapegoat Tree logic for insert**

ref: https://homework.quest/classes/2024-01/cs2381/notes/17-balancing-bst/

 - When we insert, we keep track of how deep the new node is, and if
   it’s deeper than 2*log(size) we say it’s too deep and fix it.
 - Traveling from the new leaf to the root, we check each subtree to
   see if the size of its modified child subtree is is at least 70% of
   the modified subtree (e.g. if we inserted on the left, is our left
   subtree's size at least 70% of left.size() + right.size() + 1).
   The first node that is that unbalanced is the scapegoat.
 - We rebalance by making the subtree rooted at the scapegoat
   perfectly balanced by converting it to a list and then converting
   the list of entries back to a balanced tree.
 
**Part 1.3: Implement the Scapegoat Tree logic for delete**

 - After deleting, if the current size is less than 70% of max size,
   then we rebalance at the root.
