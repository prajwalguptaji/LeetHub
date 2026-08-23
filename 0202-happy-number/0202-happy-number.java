// class Solution {
//     public int squareNum(int n){
//         int sum=0;
//         while(n>0){
//             int dig=n%10;
//             sum=sum+(dig*dig);
//             n=n/10;
//         }
//         return sum;
//     }
//     public boolean isHappy(int n) {
//         int slow=n;
//         int fast=n;
//         while(fast!=1){
//             slow=squareNum(slow);
//             fast=squareNum(squareNum(fast));
//             if(fast==1){
//                 return true;
//             }
//             else if(fast==slow){
//                 return false;
//             }
//         }
//         return true;
        
//     }
// }
class Solution {
    public int squareNum(int n){
      int sum=0;
      while(n>0){
        int dig=n%10;
        sum=sum+(dig*dig);
        n=n/10;
      } 
      return sum;
    }
     public boolean isHappy(int n) {
     int slow=n,fast=n;
     while(fast!=1){
        slow=squareNum(slow);
        fast=squareNum(squareNum(fast));
        if(fast==1){
            return true;
        }
        else if(fast==slow){
            return false;
        }
     }
     return true;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna