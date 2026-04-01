class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>(); 
        List<List<Integer>> freq = new ArrayList<>(nums.length + 1); // this line just sets the capcity but doesn't actually allocate the desired capacity to the array list
        // there fore if we do freq.size() immediately after this it will be "0"
        for (int i = 0; i < nums.length + 1; i++) {
            freq.add(i, new ArrayList<>());
        }

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1); 
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq.get(entry.getValue()).add(entry.getKey());
        }

        int[] res = new int[k]; 
        int index = 0; 
        for (int i = freq.size() - 1; i > 0 && index < k; i--) {
            for (int n: freq.get(i)) {
                res[index++] = n; 
                if (index == k) {
                    return res; 
                }
            }
        }
        return res;
    }
}
