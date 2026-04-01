class Solution {
public:
    bool isAnagram(string s, string t) {
        unordered_map<char, int> m; 
        for(char x: s){
            m[x]++; 
        }
        for(char y: t){
            m[y]--; 
        }
        for(auto it: m){
            if(it.second != 0)
                return false; 
        }
        return true;
    }
};
