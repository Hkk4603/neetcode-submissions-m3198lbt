class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0; 
        if ( s.length() == 0 ) return 0; 

        int l = 0, r = 1; 
        Set<Character> sc = new HashSet<>(); 
        sc.add(s.charAt(0));
        maxLen = 1; 
        while (l < r && l < s.length() && r < s.length()) {
            if (sc.contains(s.charAt(r))) { 
                while ( l < r && sc.contains(s.charAt(r))) {
                    sc.remove(s.charAt(l));
                    l++;
                }
            }
            sc.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }


        return maxLen;
    }
}
