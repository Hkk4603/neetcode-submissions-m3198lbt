class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int globalMax = nums[0], globalMin = nums[0], total = 0; 
        int currMax = 0, currMin = 0; 
        for ( int i = 0; i < nums.length; i++) { 
            total += nums[i]; 
            currMax = Math.max(currMax + nums[i], nums[i]);
            currMin = Math.min(currMin + nums[i], nums[i]);
            globalMax = Math.max(currMax, globalMax);  
            globalMin = Math.min(currMin, globalMin);
        }

        return globalMax > 0 ? Math.max(globalMax, total - globalMin) : globalMax;
    }
}