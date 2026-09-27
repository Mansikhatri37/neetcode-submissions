class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        // Iterate through all pairs of indices
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE; // Track the minimum height in the range
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, heights[j]); // Update minimum height
                int width = j - i + 1; // Width of the rectangle
                int area = minHeight * width; // Calculate area
                maxArea = Math.max(maxArea, area); // Update max area
            }
        }

        return maxArea;
    }
}
