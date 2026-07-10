class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list=new ArrayList<>();
        for(int k:stones){
            list.add(k);
        }
        while(list.size()>1){
            Collections.sort(list);
            int last=list.remove(list.size()-1);
            int sec_last=list.remove(list.size()-1);
            if(last>sec_last){
                list.add(last-sec_last);
            }

        }
        if(list.size()==1){
            return list.get(0);
        }
        return 0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna