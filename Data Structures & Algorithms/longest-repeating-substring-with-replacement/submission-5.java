class Solution {
    public int characterReplacement(String s, int k) {

        HashSet<Character> charSet = new HashSet<>();

        for (char c : s.toCharArray()) {
            charSet.add(c);
        }

        //for each character, we try to find the maximum substring possible
        int left = 0 ; 
        int right = 0 ;

        int res = 0;

        for(char c : charSet){

            int count = 0;
            int l = 0;

            for(int r = 0 ; r < s.length(); r++){

                if(s.charAt(r) == c){
                    count++;
                }

                while((r-l+1) - count > k){
                    if(s.charAt(l) == c){
                        count--;
                    }
                    l++;
                }

                res = Math.max(res, r-l+1);
            }
        }

        return res;
    }
}
