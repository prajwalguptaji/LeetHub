// class Solution {
//     public int thirdMax(int[] nums) {
//         Arrays.sort(nums);
//         int count = 1;
//         int curr = nums[nums.length - 1];
//         for (int i = nums.length - 2; i >= 0; i--) {
//             if (curr == nums[i]) {
//                 continue;
//             }
//             curr = nums[i];
//             count++;
//             if (count == 3) {
//                 return curr;
//             }
//         }
//         return nums[nums.length - 1];
//     }
// }

//
class Solution {
    public int thirdMax(int[] nums) {
        Long first = null;
        Long second = null;
        Long third = null;
        for (int num : nums) {
            long n = num;
            // Skip duplicates
            if (first != null && n == first) continue;
            if (second != null && n == second) continue;
            if (third != null && n == third) continue;
            if (first == null || n > first) {
                third = second;
                second = first;
                first = n;
            } 
            else if (second == null || n > second) {
                third = second;
                second = n;
            } 
            else if (third == null || n > third) {
                third = n;
            }
        }
        // If 3 distinct numbers don't exist, return maximum
        return third == null ? first.intValue() : third.intValue();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna