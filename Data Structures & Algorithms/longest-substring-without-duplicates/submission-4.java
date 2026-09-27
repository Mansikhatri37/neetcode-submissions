class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxlen = 0;

        // Iterate over all possible substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (allUnique(s, i, j)) {
                    maxlen = Math.max(maxlen, j - i + 1);
                }
            }
        }

        return maxlen;
    }

    // Helper function to check if substring s[i:j] has all unique characters
    private boolean allUnique(String s, int start, int end) {
        HashSet<Character> set = new HashSet<>();
        for (int k = start; k <= end; k++) {
            if (set.contains(s.charAt(k))) {
                return false;
            }
            set.add(s.charAt(k));
        }
        return true;
    }
}
