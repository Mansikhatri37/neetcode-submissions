class Solution {
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0 ; i < s.length(); i++){

            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }
            else{
                int freq = map.get(s.charAt(i));
                map.put(s.charAt(i), freq + 1);
            }
        }

        for(int i = 0 ; i < t.length(); i++){
            
            if(map.containsKey(t.charAt(i))){
                int freq = map.get(t.charAt(i));
                map.put(t.charAt(i), freq-1);
            }
            else{
                return false;
            }
        }

        for(int values : map.values()){
            if(values != 0) return false;
        }

        return true;
    }
}
