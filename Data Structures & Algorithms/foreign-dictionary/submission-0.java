

class Solution {
    public String foreignDictionary(String[] words) {
        // Step 1: Build the graph
        int[] indegree = new int[26]; // To track in-degrees of all nodes
        Arrays.fill(indegree, -1); // Mark characters as unused initially
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        // Identify all characters and build adjacency list
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree[c - 'a'] = 0; // Mark character as used
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String one = words[i];
            String two = words[i + 1];

            int length = Math.min(one.length(), two.length());
            boolean found = false;

            for (int j = 0; j < length; j++) {
                if (one.charAt(j) != two.charAt(j)) {
                    int from = one.charAt(j) - 'a';
                    int to = two.charAt(j) - 'a';
                    adj.get(from).add(to);
                    indegree[to]++;
                    found = true;
                    break;
                }
            }

            // Handle invalid order case: e.g., "abc", "ab"
            if (!found && one.length() > two.length()) {
                return "";
            }
        }

        // Step 2: Topological Sort using Kahn's Algorithm
        Queue<Integer> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            result.append((char) (curr + 'a'));

            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Step 3: Check for cycles
        for (int i = 0; i < 26; i++) {
            if (indegree[i] > 0) {
                return ""; // Cycle detected
            }
        }

        return result.toString();
    }
}
