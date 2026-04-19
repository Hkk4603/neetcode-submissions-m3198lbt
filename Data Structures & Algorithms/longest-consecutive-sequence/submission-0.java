class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0; 
        Set<Integer> hs = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
        }

        for (int num : nums) {
            if ( !hs.contains(num - 1) ) {
                int startEle = num; 
                int length = 0; 
                while ( hs.contains(startEle + length) )
                    length += 1; 
                maxLen = Math.max(maxLen, length); 
            }
        }

        return maxLen;
    }
}
