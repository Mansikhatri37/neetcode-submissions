

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> uniqueTriplets = new HashSet<>();

        // Iterate through all possible triplets
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // Create a triplet and sort it to handle duplicates
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet); // Sorting ensures the triplet order is consistent
                        uniqueTriplets.add(triplet);
                    }
                }
            }
        }

        // Add all unique triplets to the answer list
        ans.addAll(uniqueTriplets);
        return ans;
    }
}
