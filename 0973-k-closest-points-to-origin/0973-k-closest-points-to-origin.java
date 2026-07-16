// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
//         // x1 = 1,y1=3
//         // x2 =0,x1=0
//         // P1 = x1,y1,P2=x2,y2
//         // dist = sqrt((x1-x2)^2(y1-y2)^2)
//         // dist = sqrt((1-0)^2+(3-0)^2)
//         // therfore sort by (x^2+y^2)

//         //points[i]
//         // x=points[i][0]
//         // y=points[i][1]
//         Arrays.sort(points,(p1,p2)->(p1[0]*p1[0]+p1[1]*p1[1])-(p2[0]*p2[0]+p2[1]*p2[1]));
//         //[[1,3],[-2,2]], k=1
//         //[[1,3],[-2,2]]  sorted
//         int [][] res=new int[k][2];
//         for(int i=0;i<k;i++){
//          res[i]=points[i];

//         }
//         return res;
        
//     }
// }

//Optimal Approach

class Solution{
    public int[][] kClosest(int[][] points,int k){
        // max heap based on distance
        // element : <distance, index of the point>
        // i=0...k-1
        //    heap.add(distance,i)
        //
        // i=k...len-1
        //   curr_d = points[i]
        //   if curr_d<heap_max[0] :
        //        heap.remove
        //       add(points[i])
        // contruct res from heap
        // res heap.pop
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<k;i++){
            int x=points[i][0],
                y=points[i][1];
            maxHeap.add(new int[]{
               x*x + y*y,
               i
            });
        }
        for(int i=k;i<points.length;i++){
           int x=points[i][0],
               y=points[i][1];

           int currD = x*x + y*y;
           if(currD < maxHeap.peek()[0]){
            maxHeap.remove();
            maxHeap.add( new int[] {
                currD,
                i 
            });
           }    
        }
        int[][] res = new int[k][2];
        int i=0;
        while(i<k){
            int idx = maxHeap.remove()[1];
            res[i] = points[idx];
            i++;  
        }
        return res;
    }

}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna