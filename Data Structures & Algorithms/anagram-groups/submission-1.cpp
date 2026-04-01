class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> res;

        for(auto str: strs){
            vector<int> v(26, 0); 
            for(char c: str){
                v[c-'a']++;
            }
            string uniquekey = ""; 
            for(auto i: v){
                uniquekey += i;
            }
            res[uniquekey].push_back(str); 
        }

        vector<vector<string>> result;
        for(auto it: res){
            result.push_back(it.second); 
        }
        return result;
    }
};
