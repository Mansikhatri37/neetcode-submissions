class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int [] ans = new int[2];
        
        for(int i = 0 ; i < numbers.length - 1 ; i++){
            
            int first = numbers[i];

            for(int j = i+1; j < numbers.length ; j++){

                int second = numbers[j];

                if(first + second == target){
                    ans[0] = i+1;
                    ans[1] = j+1;
                }
            }
        }
        return ans;
    }
}
