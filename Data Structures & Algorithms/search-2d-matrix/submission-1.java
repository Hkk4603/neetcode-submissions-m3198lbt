class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // identify row
        int l = 0, h = matrix.length - 1; 
        int searchRow = -1; 
        while ( l <= h ) {
            int mid = l + ( h - l ) / 2;
            
            if ( matrix[mid][0] == target )
                return true;
            else if( matrix[mid][0] < target ) {
                searchRow = mid;
                l = mid + 1; 
            } else { 
                h = mid - 1; 
            }
        }

        if ( searchRow == - 1) 
            return false; 

        // binary search
        return search(matrix[searchRow], target); 
    }

    public boolean search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;

        while ( l <= h ) { 
            int mid = l + ( h - l ) / 2; 
            if ( nums[mid] == target ) { 
                return true; 
            }

            if ( nums[mid] > target ) 
                h = mid - 1; 
            else 
                l = mid + 1; 
        } 
        
        return false; 
    }
}
