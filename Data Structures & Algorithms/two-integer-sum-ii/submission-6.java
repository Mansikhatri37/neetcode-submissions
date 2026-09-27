class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int [] res = new int[2];
        
        int st = 0;
        int end = numbers.length - 1;

        while(st < end){

            if(numbers[st] + numbers[end] == target){

                res[0] = st+1;
                res[1] = end+1;

                return res;
            }
            else if (numbers[st] + numbers[end] < target){

                st++;
            }
            else{
                end--;
            }
        }

        return res;
    }
}
