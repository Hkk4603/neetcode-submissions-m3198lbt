class TimeMap {

    Map<String, Map<Integer, List<String>>> keyval;

    public TimeMap() {
        keyval = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!keyval.containsKey(key)) {
            keyval.put(key, new HashMap<>()); 
        }
        if(!keyval.get(key).containsKey(timestamp)){
            keyval.get(key).put(timestamp, new ArrayList<>());
        }
        keyval.get(key).get(timestamp).add(value);
    }
    
    public String get(String key, int timestamp) {
        if (!keyval.containsKey(key))
            return "";

        int seen = 0;

        for(int time : keyval.get(key).keySet()) {
            if (time <= timestamp) {
                seen = Math.max(seen, time); 
            }
        }

        if (seen == 0) return ""; 
        int last = keyval.get(key).get(seen).size() - 1; 
        return keyval.get(key).get(seen).get(last);
    }
}
