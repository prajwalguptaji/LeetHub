class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       //1 2 3 4 5
       //k=4
       //x=3
       //3,2,4,1
       //1,2,3,4
       //custom sorting fuction on integers
       List<Integer> list=new ArrayList<>();
       for(int ele:arr){
           list.add(ele);
       }
       //sort absed on absolute diffrence from x
       Collections.sort(list,(a,b)->{
        int absAFromX=Math.abs(a-x);
        int absBFromX=Math.abs(b-x);
        if(absAFromX==absBFromX){
           return a-b;
        }
        return absAFromX-absBFromX;

       });
       List<Integer> res=new ArrayList<>();
       for(int i=0;i<k;i++){
        res.add(list.get(i));
       }
       Collections.sort(res);
       return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna