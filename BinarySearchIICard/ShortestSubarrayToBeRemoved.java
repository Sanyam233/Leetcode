/*
    Given an integer array arr, remove a subarray (can be empty) from arr such that the remaining elements in arr are non-decreasing.
    Return the length of the shortest subarray to remove.
    A subarray is a contiguous subsequence of the array.
 */
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        
        //Time Complexity: O(n)
        //Space Complexity: O(1)

        int n = arr.length;
        int start = 0, end = n - 1;
        
        while (start + 1 < n && arr[start] <= arr[start + 1]) start++;
        
        if (start == n - 1) return 0;
    
        
        while (start < end && arr[end] >= arr[end - 1]) end--;
        
        //either you remove everything from the left (end) or remove everything from the right (n - 1 - start)
        //cz up until end i.e right side is sorted and same goes for left up until start
        int res = Math.min(end, n - 1 - start);
        
        int i = 0, j = end;
        
        //last value of prefix needs to be smaller than first value of suffix
        //so we keep on increasing i (considering it the last value) until arr[i] <= arr[j]
        //i.e we take value up until i from prefix and all the value from j and onwards from suffix delete everything else in between. 
        // if arr[i] > arr[j] then increase j to check if we remove jth element can we increase i further to decrease the number of elements that gets deleted
        while (i <= start && j < n) {
            if (arr[i] <= arr[j]) {
                res = Math.min(res, j - i - 1);
                i++;
            } else {
                j++;
            }

        }
        
        
        return res;
        
        
        
        
    }
}