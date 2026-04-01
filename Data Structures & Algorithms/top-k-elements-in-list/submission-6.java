class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>(); // count frequency of each ele
        
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }


        List<List<Integer>> group = new ArrayList<>(nums.length); // group elements with same freq

        for (int i = 0; i < nums.length + 1; i++) {
            group.add(i, new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            group.get(entry.getValue()).add(entry.getKey());
        }

        int[] ans = new int[k]; 
        int j = 0;
        for (int i = group.size() - 1; i > 0 && j < k; i--) {
            for (int val: group.get(i)) {
                if (j < k) 
                    ans[j++] = val; 
                else 
                    return ans; 
            }
        }
        return ans; 

    }
}
