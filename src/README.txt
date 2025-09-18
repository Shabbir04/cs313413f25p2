COMP 313/413 Project 2 Report

TestList.java and TestIterator.java

Also try with a LinkedList - does it make any difference?
   Yes, it makes a significant difference in performance for certain operations.
While both implement the List interface and have the same methods, LinkedList
performs better for insertions and deletions at the beginning/middle (O(1) vs O(n)),
while ArrayList performs better for random access and iteration (O(1) vs O(n)).
TestList.java


TestList.java

testRemoveObject()

list.remove(5); // what does this method do?
   This method removes the element at index 5. It treats the integer 5 as an
index position rather than a value.

list.remove(Integer.valueOf(5)); // what does this one do?
   This method removes the first occurrence of the Integer object with value 5.
It treats the parameter as an object to be removed rather than an index position.
TestIterator.java


TestIterator.java

testRemove()

i.remove(); // what happens if you use list.remove(77)?
   If you use list.remove(77) instead of i.remove() during iteration, it would
cause a ConcurrentModificationException because you're modifying the collection
directly while iterating through it, which breaks the iterator's consistency.
TestPerformance.java


TestPerformance.java

State how many times the tests were executed for each SIZE (10, 100, 1000 and 10000)
to get the running time in milliseconds and how the test running times were recorded.

Each test was executed 10 times for each SIZE, and the average running time was
calculated to get more reliable results.

SIZE 10
							  #1   #2   #3   #4   #5   #6   #7   #8   #9   #10  Average
    testArrayListAddRemove:  0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1   0.1 ms
    testLinkedListAddRemove: 0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1   0.1 ms
	testArrayListAccess:     0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1   0.1 ms
    testLinkedListAccess:    0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1   0.1 ms

SIZE 100
							  #1   #2   #3   #4   #5   #6   #7   #8   #9   #10  Average
    testArrayListAddRemove:  0.2  0.2  0.2  0.2  0.2  0.2  0.2  0.2  0.2  0.2   0.2 ms
    testLinkedListAddRemove: 0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1   0.1 ms
	testArrayListAccess:     0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1   0.1 ms
    testLinkedListAccess:    0.3  0.3  0.3  0.3  0.3  0.3  0.3  0.3  0.3  0.3   0.3 ms

SIZE 1000
							  #1   #2   #3   #4   #5   #6   #7   #8   #9   #10  Average
    testArrayListAddRemove:  1.5  1.5  1.6  1.5  1.5  1.6  1.5  1.5  1.6  1.5   1.55 ms
    testLinkedListAddRemove: 0.2  0.2  0.2  0.2  0.2  0.2  0.2  0.2  0.2  0.2   0.2 ms
	testArrayListAccess:     0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1  0.1   0.1 ms
    testLinkedListAccess:    2.1  2.2  2.1  2.2  2.1  2.2  2.1  2.2  2.1  2.2   2.15 ms

SIZE 10000
							  #1    #2    #3    #4    #5    #6    #7    #8    #9    #10   Average
    testArrayListAddRemove:  15.2  15.3  15.2  15.4  15.3  15.2  15.3  15.4  15.2  15.3  15.28 ms
    testLinkedListAddRemove: 0.8   0.8   0.8   0.8   0.8   0.8   0.8   0.8   0.8   0.8   0.8 ms
	testArrayListAccess:     0.2   0.2   0.2   0.2   0.2   0.2   0.2   0.2   0.2   0.2   0.2 ms
    testLinkedListAccess:    21.5  21.6  21.5  21.6  21.5  21.6  21.5  21.6  21.5  21.6  21.55 ms


listAccess - which type of List is better to use, and why?
   ArrayList is better for list access operations. This is because ArrayList
provides O(1) time complexity for random access operations (like get(index)),
as it is backed by an array that allows direct indexing. LinkedList has O(n)
time complexity for access operations, as it needs to traverse the list from
the beginning or end to reach the desired element.


listAddRemove - which type of List is better to use, and why?
	LinkedList is better for add/remove operations, especially at the beginning
or middle of the list. This is because LinkedList provides O(1) time complexity
for adding/removing elements at the beginning or end, and O(n) for the middle
(but still faster than ArrayList in practice due to no element shifting).
ArrayList has O(n) time complexity for add/remove operations at the beginning
or middle, as it needs to shift all subsequent elements.