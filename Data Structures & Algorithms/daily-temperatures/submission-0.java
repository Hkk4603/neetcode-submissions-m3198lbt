class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] res = new int[size];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < size; i++) {
            int t = temperatures[i]; 
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop(); 
                res[pair[1]] = i - pair[1]; 
            }
            stack.push(new int[]{t, i});
        }

        return res;
    }
}
