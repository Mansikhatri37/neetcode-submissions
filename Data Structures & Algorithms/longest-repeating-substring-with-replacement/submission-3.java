class Solution {
    private static int characterReplacement(String s, int k) {
        int n = s.length();
        int[] charCount = new int[26];
        int maxFreq = 0, maxLength = 0;

        int left = 0;
        for (int right = 0; right < n; right++) {
            // Increment the count of the current character
            charCount[s.charAt(right) - 'A']++;

            // Update the maximum frequency of any character in the current window
            maxFreq = Math.max(maxFreq, charCount[s.charAt(right) - 'A']);

            // Calculate the size of the window and check if it's valid
            int windowSize = right - left + 1;
            if (windowSize - maxFreq > k) {
                // Shrink the window from the left
                charCount[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the maximum length of the valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
