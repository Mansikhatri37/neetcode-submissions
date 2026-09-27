
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesesHelper(result, "", 0, 0, n);
        return result;
    }

    // Helper function to generate parentheses
    private void generateParenthesesHelper(List<String> result, String current, int open, int close, int n) {
        // Base case: if the current string has 2*n characters, it's a valid combination
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add an opening parenthesis if we haven't reached the max
        if (open < n) {
            generateParenthesesHelper(result, current + '(', open + 1, close, n);
        }

        // Add a closing parenthesis only if the number of closing parentheses is less than opening
        if (close < open) {
            generateParenthesesHelper(result, current + ')', open, close + 1, n);
        }
    }
}
