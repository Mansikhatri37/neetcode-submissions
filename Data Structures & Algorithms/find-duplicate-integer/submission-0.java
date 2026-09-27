class Solution {
    public int findDuplicate(int[] nums) {
        
        HashSet<Integer> st = new HashSet<>();

        for(int i = 0 ; i < nums.length ; i++){
            if(!st.contains(nums[i])) st.add(nums[i]);
            else return nums[i];
        }

        return -1;
    }
}
