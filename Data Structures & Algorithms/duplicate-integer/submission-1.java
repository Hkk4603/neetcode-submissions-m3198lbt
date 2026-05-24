class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int size = nums.length; 
        for (int i = 0; i < size; i++) {
            if (!hs.contains(nums[i])) {
                hs.add(nums[i]); 
            } else {
                return true; 
            }
        }

        return false;
    }
}