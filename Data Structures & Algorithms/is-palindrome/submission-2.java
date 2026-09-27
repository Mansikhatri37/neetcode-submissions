class Solution {
    public boolean isPalindrome(String s) {

        int front = 0;
        int rear = s.length() - 1;

        while (front < rear) {

            // Skip non-alphanumeric characters from left
            while (front < rear && !Character.isLetterOrDigit(s.charAt(front))) {
                front++;
            }

            // Skip non-alphanumeric characters from right
            while (front < rear && !Character.isLetterOrDigit(s.charAt(rear))) {
                rear--;
            }

            // Compare characters ignoring case
            if (Character.toLowerCase(s.charAt(front)) !=
                Character.toLowerCase(s.charAt(rear))) {
                return false;
            }

            front++;
            rear--;
        }

        return true;
    }
}