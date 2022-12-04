/*
Given an integer array arr and a target value target, return the integer value such that when we change all the integers larger than value in the given array to be equal to value, the sum of the array gets as close as possible (in absolute difference) to target.
In case of a tie, return the minimum such integer.
Notice that the answer is not neccesarilly a number from arr.
*/

//Discuss Solution
class Solution {
    
    public int findBestValue(int[] arr, int target) {
        
        Arrays.sort(arr);
        
        int n = arr.length, i = 0;
        
        while (i < n && (arr[i] * (n - i)) < target) {
            target -= arr[i++];
        }
        
        if (i == n) return arr[n - 1];
        
        int len = n - i;
        int res = target/len;
        
        if (Math.abs(target - (res * len)) > Math.abs(target - (res + 1) * len)) {
            res++;
        }
        
        return res;
        

        
    }
}

//My Solution
class Solution {
    
    public int findBestValue(int[] arr, int target) {
        
        Arrays.sort(arr);
        
        int n = arr.length;
        int res = 0, diff = Integer.MAX_VALUE;
        
        int i = 0, prefixSum = 0;
        for (int num = 0; num <= arr[n - 1]; num++) {
            while (arr[i] < num) {
                prefixSum += arr[i++];
            }
            int sum = prefixSum + ((n - i)*num);
            int currDiff = Math.abs(target - sum);
            if (currDiff < diff) {
                res = num;
                diff = currDiff;
            }
        }
        
        return res;
        
    }
}