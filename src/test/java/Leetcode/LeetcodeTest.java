package Leetcode;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class LeetcodeTest {

    @Test
    void twoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ans;
        ans = Leetcode.twoSum(nums, target);
        Arrays.stream(ans).forEach(System.out::print);
    }

    @Test
    void maxProfit() {

        assertEquals(5, Leetcode.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    @Test
    void containsDuplicate() {
        assertEquals(true, Leetcode.containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    @Test
    void productExceptSelf() {
        int[] expected = {24, 12, 8, 6};
        int[] result = Leetcode.productExceptSelf(new int[]{1, 2, 3, 4});
        assertTrue(Arrays.equals(expected, result));

        int[] expected1 = {0, 0, 9, 0, 0};
        int[] result1 = Leetcode.productExceptSelf(new int[]{-1, 1, 0, -3, 3});
        assertTrue(Arrays.equals(expected1, result1));
    }

    @Test
    void maxSubArray() {
        assertEquals(6, Leetcode.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(1, Leetcode.maxSubArray(new int[]{1}));
    }

    @Test
    void maxProduct() {
        assertEquals(6, Leetcode.maxProduct(new int[]{2, 3, -2, 4}));
        assertEquals(0, Leetcode.maxProduct(new int[]{-2, 0, -1}));
    }

    @Test
    void findMin() {
        assertEquals(1, Leetcode.findMin(new int[]{3, 4, 5, 1, 2}));
        assertEquals(0, Leetcode.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        assertEquals(11, Leetcode.findMin(new int[]{11, 13, 15, 17}));
    }

    @Test
    void search() {

        assertEquals(4, Leetcode.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(-1, Leetcode.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        assertEquals(-1, Leetcode.search(new int[]{1}, 0));
        assertEquals(0, Leetcode.search(new int[]{3, 1}, 3));
    }

    @Test
    void threeSum() {
        var a = Leetcode.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    @Test
    void maxArea() {
        assertEquals(49, Leetcode.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        assertEquals(1, Leetcode.maxArea(new int[]{1, 1}));
    }

    @Test
    void getSum() {
        assertEquals(5,Leetcode.getSum(2,3));
        assertEquals(-1, Leetcode.getSum(-5, 4));
        assertEquals(-9,Leetcode.getSum(-5,-4));
    }

    @Test
    void hammingWeight() {
        assertEquals(3, Leetcode.hammingWeight(00000000000000000000000000001011));
        assertEquals(1, Leetcode.hammingWeight(00000000000000000000000010000000));
    }

    @Test
    void countBits() {

        int[] expected1 = {0, 1, 1};
        int[] result1 = Leetcode.countBits(2);
        assertTrue(Arrays.equals(expected1, result1));

        int[] expected2 = {0, 1, 1, 2, 1, 2};
        int[] result2 = Leetcode.countBits(5);
        assertTrue(Arrays.equals(expected2, result2));
    }

    @Test
    void missingNumber() {
        assertEquals(8,Leetcode.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        assertEquals(2,Leetcode.missingNumber(new int[]{3,0,1}));
        assertEquals(2,Leetcode.missingNumber(new int[]{0,1}));
    }

    @Test
    void reverseBits() {
            // assertEquals(964176192 ,Leetcode.reverseBits(00000010100101000001111010011100));
    }
}