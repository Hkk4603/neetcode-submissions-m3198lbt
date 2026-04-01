class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            while ( i > 0 && i < nums.length && nums[i] == nums[i-1]) i++; 

            int l = i + 1, r = nums.length - 1; 
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r]; 

                if ( sum == 0 ) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r])); 
                    l++; r--; 

                    while (l < r && nums[l] == nums[l-1]) l++;

                    while (l < r && nums[r] == nums[r+1]) r--; 
                } else if ( sum > 0 ) {
                    r--; 
                } else {
                    l++; 
                }
            }
        }
        return ans; 
    }
}
