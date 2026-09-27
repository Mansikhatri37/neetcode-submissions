class Solution {

    public String encode(List<String> strs) {

        StringBuilder encodedStr = new StringBuilder();

        for (String str : strs) {
            encodedStr.append(str.length());
            encodedStr.append("#");
            encodedStr.append(str);
        }

        return encodedStr.toString();
    }

    public List<String> decode(String str) {

        int i = 0;

        List<String> result = new ArrayList<>();

        while (i < str.length()) {

            int j = i;

            // Find the first #
            while (str.charAt(j) != '#') {
                j++;
            }

            // Get the length of the string
            int length = Integer.parseInt(str.substring(i, j));

            // Move past '#'
            i = j + 1;

            // Read exactly 'length' characters
            String word = str.substring(i, i + length);

            result.add(word);

            // Move to the next encoded string
            i = i + length;
        }

        return result;
    }
}