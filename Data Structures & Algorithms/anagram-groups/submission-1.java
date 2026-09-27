

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to store sorted string as key and list of anagrams as value
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Sort the string to get the key
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);

            // Add the string to the corresponding group in the map
            map.putIfAbsent(sortedKey, new ArrayList<>());
            map.get(sortedKey).add(str);
        }

        // Collect all anagram groups
        return new ArrayList<>(map.values());
    }
}


