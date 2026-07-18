// class Solution {
//     public int findPeakElement(int[] nums) {
//        int low=0,high=nums.length-1;
//        int ans=0;
//        while(low<=high){
//          int mid=low+(high-low)/2;
//          if(nums.length<3){
//             if(nums[low]>nums[high])
//             return low;
//             else return high;
//          }
//          if( nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]){
//             ans=mid;
//             break;
//           }
//             else if(nums[mid]>nums[mid-1]&&nums[mid]<nums[mid+1]){
//                 low=mid+1;
                
//             }
//             else{
//                 high=mid-1;
//             }
        
//         } 
//         return ans;
//     }
// }
class Solution {
     public int findPeakElement(int[] nums) {
     int low=0,
         high=nums.length-1;
     while(low<high){
        int mid=low+(high-low)/2;

        if(nums[mid]>nums[mid+1]){
            high=mid;
        }
        else{
            low=mid+1;
        }
     }
     return high;    
     }
}        

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna