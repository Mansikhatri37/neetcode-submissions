class Solution {
    public int search(int[] nums, int target) {
        int st = 0;
        int end = nums.length - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            // Check if the target is at the mid position
            if (nums[mid] == target) {
                return mid;
            }

            // If the left part is sorted
            if (nums[st] <= nums[mid]) {
                // Check if the target lies in the left sorted part
                if (nums[st] <= target && target < nums[mid]) {
                    end = mid - 1; // Search in the left part
                } else {
                    st = mid + 1; // Search in the right part
                }
            } else { // If the right part is sorted
                // Check if the target lies in the right sorted part
                if (nums[mid] < target && target <= nums[end]) {
                    st = mid + 1; // Search in the right part
                } else {
                    end = mid - 1; // Search in the left part
                }
            }
        }

        return -1; // Target not found
    }
}
