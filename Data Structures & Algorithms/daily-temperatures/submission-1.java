class Solution {
    public int[] dailyTemperatures(int[] temperature) {
        int n = temperature.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Traverse the temperatures array
        for (int i = 0; i < n; i++) {
            // Check if current temperature is greater than the temperature of the index at the stack top
            while (!stack.isEmpty() && temperature[i] > temperature[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx; // Calculate the number of days
            }
            // Push current index onto the stack
            stack.push(i);
        }
        
        return result;
    }
}
