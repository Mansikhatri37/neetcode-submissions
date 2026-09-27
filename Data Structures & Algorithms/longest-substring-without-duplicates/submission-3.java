class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxlen = 0;
        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            char currentChar = s.charAt(j);

            // Remove characters from the set until the duplicate is removed
            while (set.contains(currentChar)) {
                set.remove(s.charAt(i));
                i++;
            }

            // Add the current character to the set
            set.add(currentChar);

            // Update the maximum length
            maxlen = Math.max(maxlen, j - i + 1);
        }

        return maxlen;
    }
}
