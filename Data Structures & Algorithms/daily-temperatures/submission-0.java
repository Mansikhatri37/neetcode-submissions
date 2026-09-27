class Solution {
    public int[] dailyTemperatures(int[] temperature) {

        int[] max = new int[temperature.length];
        
        for(int i = 0 ; i < temperature.length - 1 ; i++){

            int current = temperature[i];

            for(int j = i+1; j < temperature.length ; j++){

                if(temperature[j] > temperature[i]){
                    max[i] = j - i;
                    break;
                }
            }
        }
        
        return max;
    }
}
