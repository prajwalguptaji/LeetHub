class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0,i=0,j=0;
        for(i=0;i<s.length();i++){
            Set<Character> set=new HashSet<>();
            for(j=i;j<s.length();j++){

               if(set.contains(s.charAt(j))) {
                break;
               }
               set.add(s.charAt(j));
               max=Math.max(max,j-i+1);
            }
        }
        return max;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna