
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {
            char curr = s2.charAt(right);

            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) - 1);
            }

            // Keep the window size equal to s1.length()
            if (right - left + 1 > s1.length()) {
                char removed = s2.charAt(left);

                if (map.containsKey(removed)) {
                    map.put(removed, map.get(removed) + 1);
                }

                left++;
            }

            // Check if this window is a permutation
            if (right - left + 1 == s1.length()) {
                boolean valid = true;

                for (int count : map.values()) {
                    if (count != 0) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    return true;
                }
            }
        }

        return false;
    }
}
