# coding-practise
Few coding questions, I solved for an class where I prioritize the space and time complexity 

For each problem below, provide writeups of the solutions. Provide a naive solution and then any more efficient solutions you can find. Then, implement the most efficient solution you were able to find. Comment your code well.

## Testing
Enable testing the same way you enabled testing for the Design Problem assignment EXCEPT make sure to choose `JUnit Jupiter` as your testing environment.

Total points: 75

Each question is worth 5 points for code and 5 points for the writeup. An additional 5 points is available for finding the extra credit solution (question 3).

List names of anyone you discuss problems with. You may not google any portion of the question. You may google the running time of explicit operations on data structures (eg `what is the time complexity of insert(x) in a priority queue`). You may search for how to use java APIs. Leave links to any resources you as comments in your code.

Do all of your work in the codespace. I provide no warranty for the testing framework outside the codespaces environment.

## Questions

1. Given a string `a` and a string `b`, return `true` if `a` is an anagram of `b`. That is, can you reorder the characters of `a` to get `b` or vice-versa?
	* Solve the problem in O(n^2) time.
	* Solve the problem in O(nlogn) time.
	* Solve the problem in O(n) time.
	* Examples:
		* `fried` and `fired` returns `true`.
		* `cheese` and `cheers` returns `false`.
		* `dormitory` and `dirty room` returns `true`.
2. Given an integer, x, and an array of integers, find two indices of the array which correspond to elements that add up to x. You are guaranteed that there will be an answer. 
	* Solve the problem in O(n^2) time.
	* Solve the problem in O(n) time.
	* Examples:
		* `[3, 5, 4, 16, 6]` and `10` returns `[2,4]`.
		* `[5, 10, 15, 20, 25, 30, 35]` and `55` returns `[4,5]`.
3. Given an integer array, duplicates are present in it in a way that all duplicates appear an even number of times except one which appears an odd number of times. Find that odd appearing element. [Extra Credit] Find a solution using linear time and without using any extra memory.
	* Examples:
		* `[1, 2, 3, 4, 5, 4, 3, 2, 1]` returns `5`.
		* `[60,5,60,4,5,60,4]` returns `60`. 
4. Parts of each array may or may not have a section that when added together has a sum of 0. Return true if it does have a section that adds to 0 and false if not.
 	* Examples:
 		* `[3, 7, 8, -4, 5, -3, -5, -2, 2, 2, 5, -6]` returns `true`.
 		* `[-2, 5, 6, 1, -3, 4, -1, 8, -7, -4]` returns `false`.
5. Return all pairs of integers that are reverses of each other from an array. Reverse pairs are defined as containing the same values at opposite indices, for example (3,9) and (9,3)
	* Examples:
		* `[[1,3],[8,3],[3,2],[2,3],[5,6],[3,1]]` returns `[[1,3],[3,1],[3,2],[2,3]]`
		* `[[1,3],[2,4],[3,5],[5,2],[2,4],[2,3],[3,1]]` returns `[[1,3],[3,1]]`
6. Given an unsorted array, reorder the array so that all occurrences of the same value are together. Clusters of elements should appear in the order that they are first seen in the array.
	* Examples:
		* `[2,5,1,2,3,3,1,5]` returns `[2,2,5,5,1,1,3,3]`.
		* `[5,4,5,5,3,4,8]` returns `[5,5,5,4,4,3,8]`.
7. Given a string `a` and a string `b`, return `true` if you can replace all occurrences of each character in `a` with another character to get `b`. Return `false` otherwise.
	* Examples: 
		* `WCGW` and `ABCA` returns `true`.
		* `WCGW` and `AABC` returns `false`.
