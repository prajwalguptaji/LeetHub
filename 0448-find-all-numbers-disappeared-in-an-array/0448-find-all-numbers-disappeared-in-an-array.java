class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //[4,3,2,7,8,2,3,1]
        //1.....8
       // [5,6]
        List<Integer> res=new ArrayList<>();
        int i=0,correctIndex=0;
        while(i<nums.length){
            correctIndex=nums[i]-1;
            if(correctIndex>=0&&correctIndex<=nums.length&&nums[i]!=nums[correctIndex]){
                int temp=nums[i];
                nums[i]=nums[correctIndex];
                nums[correctIndex]=temp;
            }else{
                i++;
            }
            
        }
        //[1,2,2,3,3,4,7,8]
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                res.add(i+1);

            }
            
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna