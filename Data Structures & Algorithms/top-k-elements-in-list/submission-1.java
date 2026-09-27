class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> freqMap = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++){

            if(!freqMap.containsKey(nums[i])){
                freqMap.put(nums[i], 1);
            }
            else{
                int freq = freqMap.get(nums[i]);
                freqMap.put(nums[i], freq+1);
            }
        }

        List<Map.Entry<Integer,Integer>> entries = new ArrayList<>(freqMap.entrySet());

        //sort
        entries.sort((a,b) -> Integer.compare(b.getValue(), a.getValue()));

        int[] result = new int[k];

        for(int i = 0 ; i < k ; i++){
            result[i] = entries.get(i).getKey();
        }

        return result;
    }
}
