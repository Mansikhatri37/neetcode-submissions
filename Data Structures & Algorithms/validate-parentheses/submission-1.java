class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Push opening brackets onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                // For closing brackets, check if stack is empty or top does not match
                if (st.isEmpty() || 
                    (ch == ')' && st.peek() != '(') || 
                    (ch == '}' && st.peek() != '{') || 
                    (ch == ']' && st.peek() != '[')) {
                    return false;
                }
                // Pop the matching opening bracket
                st.pop();
            }
        }

        // If stack is empty, the string is valid
        return st.isEmpty();
    }
}
