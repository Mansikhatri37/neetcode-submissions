

class Solution {
    public boolean isValidSubstring(int start, int end, String s, String t) {
        // Extract the substring from s
        String sub = s.substring(start, end + 1);

        // Check if the substring contains all characters of t (by frequency)
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < sub.length(); i++) {
            char c = sub.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }

        // If map is empty, it means all characters of t are found in sub
        return map.isEmpty();
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        String result = "";
        
        // Take each substring of s
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                // Check if the substring contains all characters of t
                if (isValidSubstring(i, j, s, t)) {
                    String sub = s.substring(i, j + 1);
                    if (result.isEmpty() || sub.length() < result.length()) {
                        result = sub;
                    }
                }
            }
        }

        return result;
    }

}
