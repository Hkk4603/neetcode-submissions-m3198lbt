class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedStr = new StringBuilder(); 
        for (String s : strs) {
            encodedStr.append(s.length()).append('#').append(s); 
        }
        return encodedStr.toString(); 
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>(); 
        int i = 0; 
        while ( i < str.length() ) {
            int j = i; 
            while (str.charAt(j) != '#') {
                j++; 
            }
        int len = Integer.parseInt(str.substring(i,j)); 
        i = j + 1; 
        j = i + len; 
        decoded.add(str.substring(i, j)); 
        i = j; 
        }
        return decoded;
    }

}
