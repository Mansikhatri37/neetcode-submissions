class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesesHelper(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    // Helper function to generate parentheses
    private void generateParenthesesHelper(List<String> result, StringBuilder current, int open, int close, int n) {
        // If the current string has 2*n characters, it's a valid combination
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Add an opening parenthesis if we haven't reached the max
        if (open < n) {
            current.append('(');
            generateParenthesesHelper(result, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }

        // Add a closing parenthesis only if the number of closing parentheses is less than opening
        if (close < open) {
            current.append(')');
            generateParenthesesHelper(result, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}
