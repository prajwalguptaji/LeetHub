class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        //2 1 3 3 ,,k=2
        //1 3 5
        //nums-> numsDetails(val,index)
        //sort numsDetails (val) on  descending order
        //first k slots mai we have k largest elements
        // unn k slots ko index ke basis pe sort kar do
        // unn k slots ko index ke basis pe sort kar do

        // first k slots of numsDetails -> contains the subsequence of the answer
        
        int[][] numsDetails = new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            numsDetails[i][0]=nums[i];  
            // <2 1 3 3>
           // <2: 0 , 1: 1 ,3: 2,3: 3>
            numsDetails[i][1]=i;
        }
        Arrays.sort(numsDetails,(a,b)->b[0]-a[0]);
        Arrays.sort(numsDetails,0,k,(a,b)-> a[1]-b[1]);  //index ascen
        // <3:2, 3:3, 2:0, 1:1>
        //<3:2, 3:3>
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i]= numsDetails[i][0];
        }
        return res;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna