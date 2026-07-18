/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
    //  int low=1,high=n;
    //  int ans=0;
    
    //  while(low<=high){
    //     int mid=low + (high-low)/2;  //saves time
    //     if(isBadVersion(mid)){
    //         ans=mid;
    //         high=mid-1;
    //     }
    //     else {
    //         low=mid+1;
    //     }
    //  } 
    //  return  ans;  

    int low=1,high=n;
    while(low<high){
        int mid=low+(high-low)/2;
        if(isBadVersion(mid)){
            high=mid;
        }
        else{
            low=mid+1;
        }
    }
    return low;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna