class Solution {

    public int binarySearch(int[] numbers, int target, int start, int end) {

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (numbers[mid] == target) {
                return mid;
            }
            else if (target > numbers[mid]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {

            int remaining = target - numbers[i];

            int index = binarySearch(
                numbers,
                remaining,
                i + 1,
                numbers.length - 1
            );

            if (index != -1) {
                return new int[] {i + 1, index + 1};
            }
        }

        return new int[] {};
    }
}