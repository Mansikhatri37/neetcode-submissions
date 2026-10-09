

class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int maxSubs = 0;

        while (right < s.length()) {

            int curr = s.charAt(right);

            if (map.containsKey(curr)) {
                left = Math.max(left, map.get(curr) + 1);
            }

            map.put(curr, right);

            maxSubs = Math.max(maxSubs, right - left + 1);

            right++;
        }

        return maxSubs;
    }
}
