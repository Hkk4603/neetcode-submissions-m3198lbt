class Solution {
    public int maxSubArray(int[] nums) {
        int maxi = nums[0];
        int sum = 0; 

        for (int n: nums) {
            sum += n; 
            maxi = Math.max(maxi, sum); 
            if ( sum < 0 ) {
                sum = 0; 
            }
        }

        return maxi;
    }
}
