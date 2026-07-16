class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int curr = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (curr == nums[i]) {
                continue;
            }
            curr = nums[i];
            count++;
            if (count == 3) {
                return curr;
            }
        }
        return nums[nums.length - 1];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna