class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> freq; 
        for(int n: nums){
            freq[n]++;
        }

        vector<pair<int, int>> vv;
        for(auto it: freq){
            vv.push_back({it.second, it.first});
        } 

        sort(vv.begin(), vv.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
            return a.first > b.first;
        });

        vector<int> res; 
        for(int i = 0; i < k; i++){
            res.push_back(vv[i].second);
        }
        return res;
    }
};
