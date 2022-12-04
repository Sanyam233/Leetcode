/*
 * You are given three positive integers: n, index, and maxSum. You want to construct an array nums (0-indexed) that satisfies the following conditions:
nums.length == n
nums[i] is a positive integer where 0 <= i < n.
abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
The sum of all the elements of nums does not exceed maxSum.
nums[index] is maximized.
Return nums[index] of the constructed array.
Note that abs(x) equals x if x >= 0, and -x otherwise.
 */

class Solution {

    //Time Complexity: O(log MaxSum)
    //Space Complexity: O(1)

    public int maxValue(int n, int index, int maxSum) {
        maxSum -= n;
        int left = 0, right = maxSum;
        
        while (left < right) {
            int mid = (left + right + 1)/2;
            
            if (getSum(n, index, mid) <= maxSum) {
                left = mid;
            } else {
                right = mid - 1;
            }
            
        }
        
        return left + 1;
    }
    
    private long getSum(int n, int index, int mid) {
        
        long leftBound = Math.max(mid - index, 0);
        long rightBound = Math.max(mid - ((n - 1) - index), 0);
        
        long leftSum = Math.max((leftBound + mid) * (mid - leftBound + 1)/2, 0);
        long rightSum = Math.max((rightBound + mid) * (mid - rightBound + 1)/2, 0);
        
        //cz we are double counting mid
        return leftSum + rightSum - mid;
        
    }
}