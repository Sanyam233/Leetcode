package dailychallenges;
/**
* Question: You are given a 0-indexed integer array nums of length n.
  The average difference of the index i is the absolute difference between the average of the first i + 1 elements of nums and the average of the last n - i - 1 elements. 
  Both averages should be rounded down to the nearest integer.
  Return the index with the minimum average difference. If there are multiple such indices, return the smallest one.
*
* Difficult: Medium 
*
* Basic Idea: Store the cummulative sum for n indexes. This will help avoid recomputation of sum at every idx. 
  prefix[n - 1] - prefix[i] will give the sum between i (exclusive) and n - 1 (inclusive) indexes 
  Compute the averages for i + 1 indexes and n - i - 1 indexes. 
  Check the difference and update the res if new difference is smaller than the previous.
*
**/


class MinimumAverageDifference1 {
    public int minimumAverageDifference(int[] nums) {
        
        //Time Complexity: O(n)
        //Space Complexity: O(n)
        //Where n is the length of the nums array
        
        int n = nums.length;
        
        //to avoid sum recomputation
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    
        int res = 0;
        long minDiff = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            long frontAvg = prefixSum[i]/(i + 1);

            // when i becomes n - 1 then n - i - 1 equates to 0. This check is to avoid division by 0
            long backAvg = (n - i - 1 == 0) ? 0 : (prefixSum[n - 1] - prefixSum[i])/(n - i - 1);
            long absDiff = Math.abs(backAvg - frontAvg);
            if (absDiff < minDiff) {
                res = i;
                minDiff = absDiff;
            }
        }
        
        return res;
        
        
    }
}

//Space Optimization
class MinimumAverageDifference2 {
    public int minimumAverageDifference(int[] nums) {
        
        //Time Complexity: O(n)
        //Space Complexity: O(1)
        //Where n is the length of the nums array
        
        int n = nums.length;
        long totalSum = 0;
        
        //to avoid sum recomputation
        for (int num : nums) {
            totalSum += num;
        }
    
        int res = 0;
        long minDiff = Integer.MAX_VALUE, currSum = 0;
        
        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            long frontAvg = currSum/(i + 1);

            // when i becomes n - 1 then n - i - 1 equates to 0. This check is to avoid division by 0
            long backAvg = (n - i - 1 == 0) ? 0 : (totalSum - currSum)/(n - i - 1);

            long absDiff = Math.abs(backAvg - frontAvg);
            if (absDiff < minDiff) {
                res = i;
                minDiff = absDiff;
            }
        }
        
        return res;
        
        
    }
}