// class Solution {
//     public int missingNumber(int[] nums) {
//         int n = nums.length;

//         long expectedSum = (long) n * (n + 1) / 2;
//         long actualSum = 0;

//         for (int num : nums) {
//             actualSum += num;
//         }

//         return (int) (expectedSum - actualSum);
//     }
// }

class Solution {
    public int missingNumber(int[] nums) {
        int i=0;
        //[3,0,1]
        while(i<nums.length){
            int correctIndex=nums[i];
            if(correctIndex>=nums.length){
                i++;
                continue;
            }
            if(nums[correctIndex]!=nums[i]){
                int temp=nums[i];
                nums[i]=nums[correctIndex];
                nums[correctIndex]= temp;
            }
            else{
                i++;
            }
           
        }
        //0 1 2 3 4 5 6
        //1,2,3,4,5,7,7
         for( i=0;i<nums.length;i++){
                if(nums[i]==i){
                    continue;
                }
                else{
                    return i;
                }
           }
           return nums.length;
    }
}   

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna