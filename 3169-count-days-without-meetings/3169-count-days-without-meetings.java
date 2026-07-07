class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> res=new ArrayList<>();
        res.add(meetings[0]);
        int gap=0;
        for(int i=1;i<meetings.length;i++){
            int[] prev =res.get(res.size()-1);
            int[] curr = meetings[i];
            int e1=prev[1], s1=prev[0],e2=curr[1],s2=curr[0];
            //merge OVERLAPPING
            if(e2>=s1&&e1>=s2){
                prev[1]=Math.max(e1,e2);
            }
            // gap NOT OVERLAPPING
            else{
                gap=gap+(s2-e1-1);
                res.add(curr);
                
            }

        }
        gap=gap+(res.get(0)[0]-1);
        gap+=days-res.get(res.size()-1)[1];
        return gap;

        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna