class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans[] = new int[nums.length]; 

        int prefix_product = 1; 
        for (int i = 0; i < nums.length; i++) {
            ans[i] = prefix_product; 
            prefix_product *= nums[i];
        }

        int postfix_product = 1; 
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= postfix_product; 
            postfix_product *= nums[i];
        }

        return ans;
    }
}  
