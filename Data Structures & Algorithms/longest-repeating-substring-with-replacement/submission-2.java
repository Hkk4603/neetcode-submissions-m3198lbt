class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();

        int l = 0, r = 1; 
        int maxLen = 1; 
        int maxFreq = 1;
        hm.put(s.charAt(l), 1);

        while ( l < r && r < s.length()) {
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, hm.get(s.charAt(r)));

            if ( (r - l + 1) - maxFreq <= k ) {
                maxLen = Math.max(maxLen, r - l + 1);
            }

            while ( l < r && (r - l + 1) - maxFreq > k ) {
                hm.put(s.charAt(l), hm.get(s.charAt(l)) - 1);
                maxFreq = Math.max(maxFreq, hm.getOrDefault(s.charAt(l), 0));
                l++; 
            }


            r++;
        }

        return maxLen;
    }
}
