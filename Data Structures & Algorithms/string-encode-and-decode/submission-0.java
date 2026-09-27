

class Solution {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String str : strs) {
            // Append the string length and a delimiter `:` before each string
            encoded.append(str.length()).append(":").append(str);
        }

        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            // Read the length of the next string (up to the colon `:`)
            int colonIndex = str.indexOf(":", i);
            int length = Integer.parseInt(str.substring(i, colonIndex));

            // Extract the string of the specified length
            i = colonIndex + 1; // Move past the colon
            String extracted = str.substring(i, i + length);
            decoded.add(extracted);

            // Move to the next segment
            i += length;
        }

        return decoded;
    }
}
