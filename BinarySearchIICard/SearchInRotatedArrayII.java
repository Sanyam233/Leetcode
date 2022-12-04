/*
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
You must decrease the overall operation steps as much as possible.
 */

class Solution {
    public boolean search(int[] nums, int target) {
        
        //Time Complexity: O(n)
        //Space Complexity: O(1)

        return binarySearch(nums, 0, nums.length - 1, target);
        
    }
    
    private boolean binarySearch(int[] nums, int left, int right, int target) {
        
        while (left <= right) {
           
            //takes care of the duplicates
            while (left < right && nums[left] == nums[left + 1]) left++;
            while (left < right && nums[right] == nums[right - 1]) right--;
            
            int mid = (left + right)/2;
            
        
            if (nums[mid] == target) return true;
            
            if (nums[mid] < nums[right]) {
                
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                
            } else {
                
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                
            }
            
            
        }
        
        return false;   

    }
    
}