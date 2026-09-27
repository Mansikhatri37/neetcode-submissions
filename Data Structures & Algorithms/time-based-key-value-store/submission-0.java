class TimeMap {
    // HashMap to store key-value pairs with timestamp as a list of pairs (value, timestamp)
    private Map<String, List<Pair>> map;

    // Constructor to initialize the map
    public TimeMap() {
        map = new HashMap<>();
    }
    
    // Method to store the key-value pair at a specific timestamp
    public void set(String key, String value, int timestamp) {
        // If the key doesn't exist, initialize its list
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        // Add the value and timestamp as a pair to the list
        map.get(key).add(new Pair(value, timestamp));
    }
    
    // Method to get the most recent value at or before the timestamp
    public String get(String key, int timestamp) {
        // Check if the key exists in the map
        if (!map.containsKey(key)) {
            return ""; // If key doesn't exist, return empty string
        }

        List<Pair> list = map.get(key);
        // Binary search for the largest timestamp <= the given timestamp
        int left = 0, right = list.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Pair pair = list.get(mid);
            
            // If the timestamp matches exactly, return the corresponding value
            if (pair.timestamp == timestamp) {
                return pair.value;
            } 
            // If the timestamp is smaller than the current mid timestamp, move to the left half
            else if (pair.timestamp < timestamp) {
                result = pair.value; // Store the value to return later
                left = mid + 1; // Search in the right half for larger or equal timestamps
            } 
            // If the timestamp is larger than the current mid timestamp, move to the right half
            else {
                right = mid - 1; // Search in the left half for smaller timestamps
            }
        }
        
        return result;
    }

    // Helper class to store value and timestamp as a pair
    private static class Pair {
        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
