class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>(); 

        for (int i = 0; i < nums.length - 1; i++) {
            Set<Integer> uniqueEle = new HashSet<>(); 

            for (int j = i + 1; j < nums.length; j++) {
                int third = -1 * (nums[i] + nums[j]);
                if ( uniqueEle.contains(third)) {
                    List<Integer> temp = new ArrayList<>(); 
                    temp = Arrays.asList(nums[i], nums[j], third); 
                    Collections.sort(temp); 
                    ans.add(temp);
                }

                uniqueEle.add(nums[j]);
            }
        }

        return new ArrayList<>(ans);
    }
}
