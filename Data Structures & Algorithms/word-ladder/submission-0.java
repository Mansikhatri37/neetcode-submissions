class Solution {
    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Create a HashSet for the word list to allow O(1) lookups
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0; // If endWord is not in the wordList, return 0
        }

        // Initialize a queue for BFS
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(beginWord, 1)); // Add the beginWord with a step count of 1

        while (!q.isEmpty()) {
            Pair<String, Integer> current = q.poll();
            String currentWord = current.getKey();
            int steps = current.getValue();

            // If we reach the endWord, return the steps
            if (currentWord.equals(endWord)) {
                return steps;
            }

            // Try changing each character of the current word
            char[] currentChars = currentWord.toCharArray();
            for (int i = 0; i < currentChars.length; i++) {
                char originalChar = currentChars[i];

                // Replace with every letter from 'a' to 'z'
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == originalChar) {
                        continue; // Skip if it's the same character
                    }
                    currentChars[i] = ch;
                    String transformedWord = new String(currentChars);

                    // If the transformed word exists in the set, process it
                    if (wordSet.contains(transformedWord)) {
                        wordSet.remove(transformedWord); // Mark it as visited
                        q.offer(new Pair<>(transformedWord, steps + 1)); // Add to the queue
                    }
                }

                // Restore the original character
                currentChars[i] = originalChar;
            }
        }

        return 0; // If no transformation sequence exists
    }
}
