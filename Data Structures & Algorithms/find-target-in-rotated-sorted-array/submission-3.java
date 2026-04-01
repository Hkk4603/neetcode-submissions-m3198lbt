class Solution {
    public int search(int[] nums, int target) {
        int pivot = pivot(nums); 
        System.out.println(pivot); 
        int ans = 0; 
        if ( target >= nums[0] && target <= nums[pivot] ) 
            ans = bs(nums, 0, pivot, target); 
        else 
            ans = bs(nums, pivot + 1, nums.length - 1, target); 

        return ans; 
    }

    int pivot(int[] nums) { 
        int l = 0, h = nums.length - 1, pivot = l; 
        while ( l <= h ) { 
            int m = l + (h - l) / 2; 
            if ( nums[l] < nums[h] ) {
                pivot = nums[pivot] < nums[h] ? h : pivot; 
                return pivot; 
            }
            
            pivot = nums[pivot] < nums[m] ? m : pivot; 
            if ( nums[l] < nums[m] ) { 
                l = m + 1; 
            } else { 
                h = m - 1; 
            }
        }

        return pivot; 
    }

    int bs(int[] nums, int l, int h, int target) { 
        System.out.println(" l: " + l + " h: " + h); 
        while ( l <= h ) { 
            int m = l + ( h - l ) / 2; 
            if ( nums[m] == target )
                return m; 
            
            if ( nums[m] > target ) 
                h = m - 1; 
            else 
                l = m + 1; 
        }
        return -1; 
    }
}
