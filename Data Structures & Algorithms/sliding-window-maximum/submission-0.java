class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0, r = k; 

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]); 
        }

        int maxi = maxHeap.peek();

        List<Integer> res = new ArrayList<>(); 
        res.add(maxi); 

        while ( r < nums.length) {
            maxHeap.remove(nums[l++]); 
            maxHeap.add(nums[r++]); 
            maxi = maxHeap.peek(); 
            res.add(maxi); 
        }

        return  res.stream().mapToInt(i -> i).toArray();

    }
}
