class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }
            else{
                int freq = map.get(nums[i]);
                map.put(nums[i], freq+1);
            }
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        for(var entry : map.entrySet()){
            pq.add(entry);
            if(pq.size() > k){
                pq.remove();
            }
        }

        //extract the elements from the heap
        int[] result = new int[k];

        for(int i = k-1; i >=0 ; i--){
            result[i] = pq.poll().getKey();
        }

        return result;
    }
}
