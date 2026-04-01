class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length]; 

        // prefix comptation
        int prefix_product = 1; 
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix_product *= nums[i-1];
            ans[i] = prefix_product;  
        }


        int postfix_product = 1; 
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= postfix_product; 
            postfix_product *= nums[i]; 
        }

        // System.out.println(Arrays.toString(ans) + ' ');
        return ans; 
    }
}  
