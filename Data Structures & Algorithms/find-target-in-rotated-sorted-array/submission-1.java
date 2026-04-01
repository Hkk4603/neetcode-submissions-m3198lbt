class Solution {
    public int search(int[] nums, int target) {
        int pivot = pivot (nums); 
        // System.out.println("Pivot: " + pivot);
        int idx = -1; 
        if ( target >= nums[0] && target <= nums[pivot])
            idx = binarySearch(nums, 0, pivot, target); 
        else 
            idx = binarySearch(nums, pivot + 1, nums.length - 1, target); 
        
        return idx; 
    }

    public int binarySearch(int[] nums, int l, int h, int target) {
        while ( l <= h ) {
            int m = l + (h - l) / 2; 
            if ( nums[m] == target ) 
                return m; 
            
            if ( nums[m] > target ) { 
                h = m - 1; 
            } else 
                l = m + 1;
        }

        return -1; 
    }

    public int pivot(int[] nums) {
        int l = 0, h = nums.length - 1;
        int idx = 0, pivot = nums[l];
        while (l <= h) {
            if(nums[l] < nums[h]) {
                pivot = Math.max(pivot, nums[h]);
                idx = pivot == nums[h] ? h : idx;
                break;
            }
            
            int m = l + (h - l) / 2; 
            pivot = Math.max(pivot, nums[m]);
            idx = pivot == nums[m] ? m : idx; 
            if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return idx;
    }
}
