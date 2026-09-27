class Solution {
    public boolean isPalindrome(String s) {

        if(s.length() == 0 || s.length() == 1) return true;
        
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");

        int front = 0 ;
        int rear = s.length() - 1;

        while(front < rear){

            if(s.charAt(front) == s.charAt(rear)){
                front++;
                rear--;
            }
            else{
                return false;
            }
        }

        return true;
    }
}
