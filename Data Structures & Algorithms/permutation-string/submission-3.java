class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] countS1 = new int[26];
        int[] countS2 = new int[26]; 

        if ( s2.length() < s1.length()) return false;

        for ( int i = 0; i < s1.length(); i++ ) {
            countS1[s1.charAt(i) - 'a']++; 
            countS2[s2.charAt(i) - 'a']++; 
        }


        int match = 0; 
        for (int i = 0; i < 26; i++) {
            if (countS1[i] == countS2[i]) 
                match++;
        }

        int l = 0, r = s1.length(); 

        while ( l < r && r < s2.length()) {
            if ( match == 26 ) {
                return true; 
            }

            int idx = s2.charAt(r) - 'a';
            countS2[idx]++; 
            if (countS1[idx] == countS2[idx]) match++; 
            else if ( countS1[idx] + 1 == countS2[idx]) match--; 

            idx = s2.charAt(l) - 'a';
            countS2[idx]--; 
            if (countS1[idx] == countS2[idx]) match++; 
            else if ( countS1[idx] - 1 == countS2[idx]) match--; 
            l++; 
            r++;
        }


        return match == 26;
    }
}
