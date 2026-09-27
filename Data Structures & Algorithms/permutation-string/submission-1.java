class Solution {
    public boolean checkInclusion(String s1, String s2) {
      int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) return false;

        // Count frequency of characters in s1 using a HashMap
        HashMap<Character, Integer> s1Map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        // Iterate through all substrings of s2 with the same length as s1
        for (int i = 0; i <= n2 - n1; i++) {
            HashMap<Character, Integer> s2Map = new HashMap<>();

            for (int j = 0; j < n1; j++) {
                char c = s2.charAt(i + j);
                s2Map.put(c, s2Map.getOrDefault(c, 0) + 1);
            }

            // Check if the frequency matches
            if (s1Map.equals(s2Map)) {
                return true;
            }
        }

        return false;
    }
}
