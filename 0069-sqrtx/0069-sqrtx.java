// class Solution {
//     public int mySqrt(int n) {
//         if (n==0) return 0;
//         int lo=1,hi=n;
//         while(lo<=hi){
//                 int mid=lo+(hi-lo)/2;
//                 if(mid==n/mid) return mid;
//                 else if (mid>n/mid) hi=mid-1;
//                 else lo=mid+1;
//             }
//             return hi;
//         }
//     }
    //1,2,3,4,5,6,7,8
    // mid=4 
    //8/4=2
    // as mid>n/mid return hi=mid-1;
    //1,2,3
    //mid=2 and 8/2=4 return lo=mid+1=3
    //aslow=hi=mid return hi

class Solution {
     public int mySqrt(int n) {
        int low=1,high=n,
            res=0;
        if (n < 2) return n;

        // int low = 1, high = n, res = 0;
        while(low<high){
            int mid=low+(high-low)/2;
           if(mid==n/mid){
              return mid;
           }
           else if(mid>n/mid){
                  high=mid;
            }
            else{
                low=mid+1;
                res=mid;
            }  
        }
        return res;    

    }
}     

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna