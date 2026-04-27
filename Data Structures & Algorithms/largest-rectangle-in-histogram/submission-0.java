class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        Stack<int[]> stack = new Stack<>(); 
        for (int i = 0; i <= heights.length; i++) {
            int start = i;
            while( !stack.isEmpty() && (i == heights.length || heights[i] <= stack.peek()[0]) ) {
                int[] pair = stack.pop(); 
                int height = pair[0]; 
                int idx = pair[1]; 
                int width = !stack.isEmpty() ? i - idx : i;
                maxArea = Math.max(maxArea, height * width);
                start = idx; 
            }
            if (i != heights.length)
                stack.push(new int[]{heights[i], start});
        }

        return maxArea;
    }
}
