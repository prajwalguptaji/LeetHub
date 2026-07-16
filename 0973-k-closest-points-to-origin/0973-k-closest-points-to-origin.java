class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // x1 = 1,y1=3
        // x2 =0,x1=0
        // P1 = x1,y1,P2=x2,y2
        // dist = sqrt((x1-x2)^2(y1-y2)^2)
        // dist = sqrt((1-0)^2+(3-0)^2)
        // therfore sort by (x^2+y^2)

        //points[i]
        // x=points[i][0]
        // y=points[i][1]
        Arrays.sort(points,(p1,p2)->(p1[0]*p1[0]+p1[1]*p1[1])-(p2[0]*p2[0]+p2[1]*p2[1]));
        //[[1,3],[-2,2]], k=1
        //[[1,3],[-2,2]]  sorted
        int [][] res=new int[k][2];
        for(int i=0;i<k;i++){
         res[i]=points[i];

        }
        return res;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna