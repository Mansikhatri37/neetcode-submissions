class Solution {
    public int maxArea(int[] heights) {
        
        int left = 0 ; 
        int right = heights.length - 1 ;

        int max = Integer.MIN_VALUE;

        while(left < right){

            int h = Math.min(heights[left], heights[right]);
            int breadth = right - left;

            int area = h * breadth;

            max = Math.max(max, area);

            if(heights[left] > heights[right]){
                right--;
            } 
            else if(heights[left] < heights[right]){
                left++;
            }
            else{
                right--;
                left++;
            }
        }

        return max;
    }
}
