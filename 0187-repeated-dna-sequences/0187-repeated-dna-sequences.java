class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen=new HashSet<>();
        Set<String> result=new HashSet<>();
        for(int i=0;i<=s.length()-10;i++){
            String dna=s.substring(i,i+10);
            if(seen.contains(dna)){
                result.add(dna);
            }
            seen.add(dna);
        }
        return new ArrayList<String>(result);
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna