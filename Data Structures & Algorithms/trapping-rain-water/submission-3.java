class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1; 
        while ( l < r && height[l + 1] > height[l]) l++;
        while ( r > l && height[r - 1] > height[r]) r--;

        System.out.println("l: " + l + " r: " + r);

        int lmax = height[l], rmax = height[r]; 

        int maxArea = 0;

        while ( l <= r ) {
            if ( lmax <= rmax ) {
                if ( height[l] < lmax ) {
                    maxArea += ( lmax - height[l] );
                } else {
                    lmax = height[l]; 
                }
                l++;
            } else {
                if ( height[r] < rmax ) {
                    maxArea += ( rmax - height[r]);
                } else {
                    rmax = height[r];
                }
                r--;
            }
        }
        return maxArea;
    }
}
