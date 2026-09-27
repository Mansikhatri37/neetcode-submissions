class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public void solve(int idx, int[]nums, List<Integer> curr){

        if(idx == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        // include nums[idx]
        curr.add(nums[idx]);
        solve(idx + 1, nums, curr);

        // backtrack
        curr.remove(curr.size() - 1);

        // exclude nums[idx]
        solve(idx + 1, nums, curr);
    }
    public List<List<Integer>> subsets(int[] nums) {

        solve(0, nums, new ArrayList<>());

        return result;
    }
}
