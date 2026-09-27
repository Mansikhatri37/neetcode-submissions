

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>(); // Stack to store the operands
        
        for (String token : tokens) {
            if (isDigit(token)) {
                // Push the number (converted to integer) into the stack
                st.push(Integer.parseInt(token));
            } else {
                // Pop the top two elements from the stack
                int two = st.pop();
                int one = st.pop();
                
                // Perform the operation based on the current token
                int ans = 0;
                switch (token) {
                    case "+":
                        ans = one + two;
                        break;
                    case "-":
                        ans = one - two;
                        break;
                    case "*":
                        ans = one * two;
                        break;
                    case "/":
                        ans = one / two;
                        break;
                }
                
                // Push the result back into the stack
                st.push(ans);
            }
        }
        
        // The final result will be the only element left in the stack
        return st.pop();
    }

    // Helper function to check if a string is a valid integer
    private boolean isDigit(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
