package Leetcode;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode {

    //    1. Two Sum
//    https://leetcode.com/problems/two-sum/
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //    121. Best Time to Buy and Sell Stock
//    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public static int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int price : prices) {
            if (price < minprice)
                minprice = price;
            else if (price - minprice > maxprofit)
                maxprofit = price - minprice;
        }
        return maxprofit;
    }
//217. Contains Duplicate
//    https://leetcode.com/problems/contains-duplicate/

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> contain = new HashSet<>();
        for (int i : nums) {
            if (contain.contains(i)) return true;
            else contain.add(i);
        }
        return false;
    }

    //    238. Product of Array Except Self
//    https://leetcode.com/problems/product-of-array-except-self/
    public static int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;
        int[] lefta = new int[nums.length];
        int[] righta = new int[nums.length];
        int[] product = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            lefta[i] = left;
            left = left * nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            righta[i] = right;
            right = right * nums[i];
            product[i] = lefta[i] * righta[i];
        }
//        for(int i=0;i<nums.length;i++){
//            product[i] = lefta[i] * righta[i];
//        }
        return product;
    }

    //    53. Maximum Subarray
//    https://leetcode.com/problems/maximum-subarray/
    public static int maxSubArray(int[] nums) {
        int TempMax = nums[0];
        int FinalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            TempMax = Math.max((TempMax + nums[i]), nums[i]);
            FinalMax = Math.max(FinalMax, TempMax);
        }
        return FinalMax;
    }

    //    152. Maximum Product Subarray
//    https://leetcode.com/problems/maximum-product-subarray/
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int max = nums[0];
        int min = nums[0];
        int result = max;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tmax; // important bcs to avoid over writing original max value
            tmax = Math.max(curr, Math.max(max * curr, min * curr));
            min = Math.min(curr, Math.min(max * curr, min * curr));
            max = tmax;
            result = Math.max(max, result);
        }
        return result;
    }

    //    153. Find Minimum in Rotated Sorted Array
//    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    public static int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        } else {
            int i = nums.length - 1;
            while (i > 0 && nums[i - 1] < nums[i]) {
                i--;
            }
            return nums[i];
        }
    }

    //    33. Search in Rotated Sorted Array
//    https://leetcode.com/problems/search-in-rotated-sorted-array/
    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) return 0;
            else return -1;
        }
        if (nums[0] <= target) {
            int i = 0;
            while (i < nums.length && nums[i] <= target) {
                if (nums[i] == target) return i;
                i++;
            }
            return -1;
        } else {
            int i = nums.length - 1;
            while (i >= 0 && nums[i] >= target) {
                if (nums[i] == target) return i;
                i--;
            }
            return -1;

        }
    }

    //        15. 3Sum
//        https://leetcode.com/problems/3sum/
    //TODO
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums == null && nums.length < 3) {
            return results;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);

                    results.add(new ArrayList<>(list));

                    left++;
                    right--;


                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        results.forEach(System.out::println);
        return results;
    }

    //    11. Container With Most Water
//    https://leetcode.com/problems/container-with-most-water/
    public static int maxArea(int[] height) {
        int res = 0, i = 0, j = height.length - 1, temp = 0;
        while (i < j) {
            if (height[i] <= height[j]) {
                temp = height[i] * (j - i);
                i++;
            } else {
                temp = height[j] * (j - i);
                j--;
            }
            if (temp > res) res = temp;
        }
        return res;
    }

    //    371. Sum of Two Integers
//    https://leetcode.com/problems/sum-of-two-integers/
    public static int getSum(int a, int b) {
        var xor = a ^ b;
        var carry = a & b;
        if (carry == 0) return xor;
        else return getSum(xor, carry << 1);
    }

    //    191. Number of 1 Bits
//    https://leetcode.com/problems/number-of-1-bits/
    public static int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) res++;
            n = n >> 1;
        }
        return res;
    }

    //    338. Counting Bits
//    https://leetcode.com/problems/counting-bits/
//    public static int[] countBits(int n) {
//        int[] dp = new int[n + 1];
//
//        for (int i = 1; i < dp.length; i++) {
//            var temp = i & (i - 1);
//            dp[i] = dp[i & (i - 1)] + 1;
//        }
//
//        return dp;
//    }        int[] dp = new int[n + 1];
//
//        for (int i = 1; i < dp.length; i++) {
//            var temp = i & (i - 1);
//            dp[i] = dp[i & (i - 1)] + 1;
//        }
//
//        return dp;
    //TODO

    public static int[] countBits(int n) {
        if (n < 0) {
            return new int[0];
        }

        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0) {
                result[i] = result[i / 2];
            } else {
                result[i] = result[i - 1] + 1;
            }
        }

        return result;
    }

    //    268. Missing Number
//    https://leetcode.com/problems/missing-number/
    public static int missingNumber(int[] nums) {
        var expected = 0;
        var original = 0;
        var pointer = 1;
        for (int i : nums) {
            original = original + i;
            expected = expected + pointer;
            pointer++;
        }
        return expected - original;
    }

    //    190. Reverse Bits
//    https://leetcode.com/problems/reverse-bits/
    public static int reverseBits(int n) {

        int res = 0;
        for (int i = 0; i < 32; i++) {
            var temp = n & 1;
            res = res <<1;
            if(temp == 1) res = res + 1;
            n = n>>1;

        }
        return res;
    }
}

