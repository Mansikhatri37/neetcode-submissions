class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int maxlen = 1;
        int len = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1] + 1) {
                len++;
            }
            else if (nums[i] == nums[i - 1]) {
                continue;
            }
            else {
                maxlen = Math.max(maxlen, len);
                len = 1;
            }
        }

        return Math.max(maxlen, len);
    }
}