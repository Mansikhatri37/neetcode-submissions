class Solution {
    public boolean canEatAll(int [] piles, int h , int mid){
        
        int hours = 0;

        for(int pile : piles){
            hours += Math.ceil((double) pile / mid);

            if(hours > h) return false;
        }

        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {

        int st = 1;
        int end = 0;

        //the max value of h can be max(piles)
        for(int pile : piles){
            end = Math.max(end, pile);
        }

        int ans = end;

        while(st <= end){

            int mid = st + (end - st)/2;

            if(canEatAll(piles, h, mid)){
                ans = mid;
                //try to look for smaller ans
                end = mid - 1;
            }
            else{
                st = mid + 1;
            }
        }
        return ans;
    }
}
