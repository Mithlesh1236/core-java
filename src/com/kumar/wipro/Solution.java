package com.kumar.wipro;

/*
 It defines the Solution class with the solution method for solving the problem of finding the longest possible distance for
 two frogs starting at each block. The main method demonstrates how to use the solution method by providing a sample input and
 printing the result.

When you run this program with the sample input [2,6,8,5], it should correctly calculate and print the result as 3, which is
the longest possible distance for two frogs in this case.

Java 8 program: There are N blocks, numbered from 0 to N-1 , arranged an a row. A couple of frogs were sitting together on the block when they had a terrible quarrel.
        Now they want to jump away fron one another so that the distance between them will be large as possible . The distance between blocks numbered J and K, where J<K ,
        is computed as K-J+1. The frogs can only jump up, meaning that they can move from one block to another only if the two blocks are adjacent and the second block is of the same
        or greater height as the first. What is the longest distance that they can possibly create between each other, if they also chose to sit on the optimal starting block
        initially?
        Wrtite a function :
class Solution {
    public int solution (int [] blocks);
}
that , the given an array blocks consisting of N integers denoting the heights of the blocks, return the longest possible distance that two frogs can make between each other starting
        from one of the blocks
        example:
        1. Given blocks =[2,6,8,5]; the function should return 3. If starting from blocks [0],the first frog can stay where it is and the second frog can jump to blocks [2](but no blocks [3]).
        2. Given blocks =[1,5,5,2,6]; the function should return 4. If starting from blocks [0],the first frog can jump to blocks [1], but not blocks [0] and the second frog can jump to blocks [4].
        3. Given blocks =[1,1]; the function should return 2. If starting from blocks [0],the second can stay where it is. Starting from blocks [0] would be result in the same distance.


        Write a efficient algorithm for the following assumptions:
        N is the integer within the range [2, 200,000];
        each element of array blocks is an integer within the range [1..1,000,000,000].*/

public class Solution {



    public int solution(int[] blocks) {
        int N = blocks.length;
        int[] left = new int[N];
        int[] right = new int[N];

        // Initialize left and right arrays
        left[0] = 1;
        right[N - 1] = 1;

        // Calculate the maximum distance to the left
        for (int i = 1; i < N; i++) {
            if (blocks[i] >= blocks[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        // Calculate the maximum distance to the right
        for (int i = N - 2; i >= 0; i--) {
            if (blocks[i] >= blocks[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        int maxDistance = 0;

        // Calculate the maximum distance that can be covered for each block
        for (int i = 0; i < N; i++) {
            maxDistance = Math.max(maxDistance, Math.max(left[i], right[i]));
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] blocks = new int[] {2,6,8,5};
        int solution = sol.solution(blocks);
        System.out.println("Test Result : " + solution);
    }
}

