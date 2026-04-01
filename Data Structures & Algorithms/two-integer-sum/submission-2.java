class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>(); 
        int[] l = new int[2]; 
        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(target - nums[i])){
                l[0] = mp.get(target-nums[i]);
                l[1] = i;
                return l;
            }
            mp.put(nums[i], i);
        }
        return l;
    }
}
