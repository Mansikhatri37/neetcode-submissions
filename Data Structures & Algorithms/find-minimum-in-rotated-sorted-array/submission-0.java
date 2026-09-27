class Solution {
    public int findMin(int[] nums) {
        int st = 0 ;
        int end = nums.length-1;
        while(st<end){
            int mid =st+(end-st)/2;
            //if entire array is sorted
            if(nums[st]<nums[end]){
                return nums[st];
            }
            //check for the sorted part
            if(nums[mid]>nums[end]){
             //left part is bigger than right part
             //go right
             st = mid+1;
            }
            else{
                end = mid;
            }
        }
        return nums[st];
    }
}
