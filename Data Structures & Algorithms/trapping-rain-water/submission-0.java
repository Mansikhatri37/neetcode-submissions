class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0; // No bars, no water
        
        int totalWater = 0;

        // Iterate through each bar
        for (int i = 0; i < n; i++) {
            // Find the maximum height to the left of the current bar
            int maxLeft = 0;
            for (int j = 0; j <= i; j++) {
                maxLeft = Math.max(maxLeft, height[j]);
            }

            // Find the maximum height to the right of the current bar
            int maxRight = 0;
            for (int j = i; j < n; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            // Water trapped above the current bar
            int waterAbove = Math.min(maxLeft, maxRight) - height[i];
            totalWater += Math.max(waterAbove, 0); // Only add if positive
        }

        return totalWater;
    }
}

