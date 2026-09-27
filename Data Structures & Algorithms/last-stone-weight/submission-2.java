class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0 ; i < stones.length ; i++){
            
            pq.add(stones[i]);
        }

        while(pq.size() > 1){

            int largest = pq.remove();
            int secondLargest = pq.remove();

            if(largest != secondLargest){
                pq.add(largest - secondLargest); 
            }
        }

        return pq.isEmpty() ? 0 : pq.remove();
    }
}
