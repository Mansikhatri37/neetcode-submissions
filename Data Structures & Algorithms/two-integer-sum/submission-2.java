class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];

            if (map.containsKey(remaining)) {
                int j = map.get(remaining);

                if (i != j) {
                    return new int[]{Math.min(i, j), Math.max(i, j)};
                }
            }
        }

        return new int[]{};
    }
}