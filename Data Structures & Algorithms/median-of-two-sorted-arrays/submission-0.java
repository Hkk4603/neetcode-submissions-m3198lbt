class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int size1 = nums1.length, size2 = nums2.length;
        int totalSize = size1 + size2; 
        int target1, target2;
        if (totalSize % 2 == 0) {
            target1 = totalSize / 2 - 1;
            target2 = target1 + 1;
        } else {
            target1 = totalSize / 2;
            target2 = -1; 
        }
        System.out.println("t1: " + target1 + " t2: " + target2);

        int[] ans = new int[2];
        int k = 0;
        int count = 0; 
        while ( i < size1 && j < size2 ) {
            if (count == target1 || count == target2) {
                if ( k >= 2 ) 
                    break;
                ans[k++] = Math.min(nums1[i] , nums2[j]);
            }
            if (nums1[i] <= nums2[j]) {
                i++; 
            } else { 
                j++;
            }
            count++;
        }

        while ( i < size1 ) {
            if (count == target1 || count == target2) {
                if ( k >= 2 ) 
                    break;
                ans[k++] = nums1[i];
            }
            i++;
            count++;
        }

        while ( j < size2 ) {
            if (count == target1 || count == target2) {
                if ( k >= 2 ) 
                    break;
                ans[k++] = nums2[j];
            }
            j++;
            count++;
        }

        System.out.println(Arrays.toString(ans));

        if (target2 == -1)
            return (double)ans[0];
        
        return ( (double)ans[0] + (double)ans[1] ) / (double)2;
    }
}
