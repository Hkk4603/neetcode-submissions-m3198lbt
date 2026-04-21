class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1cnt = new int[26];
        int[] s2cnt = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1cnt[s1.charAt(i) - 'a']++;
            s2cnt[s2.charAt(i) - 'a']++;
        }

        int matches = 0; 
        for (int i = 0; i < 26; i++) { 
            if ( s1cnt[i] == s2cnt[i] )
                matches++; 
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if ( matches == 26 ) 
                return true;


            int idx = s2.charAt(r) - 'a';
            s2cnt[idx] += 1; 
            if ( s2cnt[idx] == s1cnt[idx] ) 
                matches++;
            else if ( s1cnt[idx] == s2cnt[idx] - 1 )
                matches--;

            idx = s2.charAt(l) - 'a';
            s2cnt[idx] -= 1; 
            if ( s2cnt[idx] == s1cnt[idx] )
                matches++; 
            else if ( s2cnt[idx] + 1 == s1cnt[idx] )
                matches--; 

            l++;
        }

        return matches == 26;
    }
}
