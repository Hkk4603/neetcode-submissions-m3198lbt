class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>(); 
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1); 
        }

        // max heap declaration
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (n1, n2) -> count.get(n1) - count.get(n2)
        );

        for(int n: count.keySet()) {
            queue.add(n);
            if (queue.size() > k) {
                queue.poll(); // Remove the element with the smallest frequency
            }
        }
        System.out.println(" " + queue); 
        // 3. Build the output array: O(k log k) time
        int[] top = new int[k];
        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {
            System.out.println(" i: " + i + " > " + queue );
            top[i] = queue.poll();
        }
        return top;
    }
}
