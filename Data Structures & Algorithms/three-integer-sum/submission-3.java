class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        HashMap<Integer, Integer> map = new HashMap<>();

        // Fill the frequency map
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int freq = map.get(nums[i]);
                map.put(nums[i], freq + 1);
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            // Remove nums[i] from available elements
            int frqi = map.get(nums[i]);
            map.put(nums[i], frqi - 1);

            // Skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {

                // Remove nums[j] from available elements
                map.put(nums[j], map.get(nums[j]) - 1);

                // Skip duplicate j
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int target = -(nums[i] + nums[j]);

                if (map.getOrDefault(target, 0) > 0) {
                    res.add(Arrays.asList(nums[i], nums[j], target));
                }
            }

            // Restore all j elements
            for (int j = i + 1; j < nums.length; j++) {
                map.put(nums[j], map.get(nums[j]) + 1);
            }
        }

        return res;
    }
}