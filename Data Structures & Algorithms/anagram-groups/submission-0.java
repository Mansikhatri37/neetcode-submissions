public class Solution {

    // Method to check if two strings are anagrams
    public boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        // Populate the map with character frequencies from string `a`
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Reduce frequencies based on characters in string `b`
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            } else {
                return false;
            }
        }

        // If the map is empty, the strings are anagrams
        return map.isEmpty();
    }

    // Method to group anagrams
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] grouped = new boolean[strs.length]; // To track which strings are already grouped

        for (int i = 0; i < strs.length; i++) {
            if (grouped[i]) continue; // Skip if already grouped

            List<String> arr = new ArrayList<>();
            String str1 = strs[i];
            arr.add(str1);
            grouped[i] = true;

            for (int j = i + 1; j < strs.length; j++) {
                String str2 = strs[j];

                if (isAnagram(str1, str2)) {
                    arr.add(str2);
                    grouped[j] = true; // Mark as grouped
                }
            }

            ans.add(arr);
        }

        return ans;
    }
}

