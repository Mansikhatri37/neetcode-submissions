class Solution {
    private static boolean isValidSubstring(String s, int start, int end, int k) {
        int[] charCount = new int[26];
        int maxFreq = 0;

        // Count frequency of each character in the substring
        for (int i = start; i <= end; i++) {
            charCount[s.charAt(i) - 'A']++;
            maxFreq = Math.max(maxFreq, charCount[s.charAt(i) - 'A']);
        }

        // Calculate the number of replacements needed
        int totalLength = end - start + 1;
        int replacementsNeeded = totalLength - maxFreq;

        return replacementsNeeded <= k;
    }

    public int characterReplacement(String s, int k) {
                int n = s.length();
        int maxLength = 0;

        // Iterate through all substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isValidSubstring(s, i, j, k)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }
}
