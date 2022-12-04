/*
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
Return the single element that appears only once.
Your solution must run in O(log n) time and O(1) space.
 */

class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        //Time Complexity: O(log n)
        //Space Complexity: O(1)
        
        int n = nums.length;
        
        int left = 0, right = n - 1;
        
        while (left < right) {
            int mid = (left + right)/2;
            int tempMid = mid;
            if (mid + 1 < n && nums[mid] == nums[mid + 1]) tempMid++;
            
            if ((tempMid - left + 1) % 2 == 1) {
                right = mid;
            } else {
                left = tempMid + 1;
            }    
        }
        
        return nums[left];
        
        
    }
}