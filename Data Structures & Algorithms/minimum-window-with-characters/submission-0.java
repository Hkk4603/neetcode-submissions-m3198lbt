class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> cntT = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for ( char c : t.toCharArray()) { 
            cntT.put(c, cntT.getOrDefault(c, 0) + 1); 
        }
        
        
        int l = 0;
        int have = 0, need = cntT.size();
        int resLeft = -1, resRight = -1, resLen = Integer.MAX_VALUE;

        for (int r = 0; r < s.length(); r++) { 
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0) + 1);

            if ( cntT.containsKey(s.charAt(r)) && cntT.getOrDefault(s.charAt(r) , 0) == window.get(s.charAt(r)))
                have += 1; 
            
            while (need == have) { 
                if ( r - l + 1 < resLen ) {
                    resLen = r - l + 1; 
                    resLeft = l;
                    resRight = r; 
                }

                window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
                if (cntT.containsKey(s.charAt(l)) && cntT.get(s.charAt(l)) > window.get(s.charAt(l))) 
                    have -= 1; 
                
                l++; 
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(resLeft, resRight + 1);


    }
}
