// class Solution {
//     public int[][] merge(int[][] intervals) {
//      Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
//      List<int[]> list =new ArrayList<>();
//      list.add(intervals[0]);
//      //[[1,4],[4,7]]
//      //list=[1,7]
//      //prev=[1,7]   
//      //curr=[4,7]
//      for(int i=1;i<intervals.length;i++){
//         int[] prev=list.get(list.size()-1);
//         int[] curr =intervals[i];
//         //merge
//         if(curr[0]<=prev[1]){
//            // prev[0]=Math.min(prev[0],curr[0]);
//             prev[1]=Math.max(prev[1],curr[1]);

//         }else{
//             list.add(curr);
//         }
//      }
//      int[][] res=new int[list.size()][2];
//      for(int i=0;i<list.size();i++){
//         res[i]=list.get(i);
//       } 
//      return res;
//     }
//   }
  class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list=new ArrayList<>();
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] last = list.get(list.size() - 1);
            int[] newInterval=intervals[i];
            if(newInterval[0]<=last[1]){
                last[0] = Math.min(newInterval[0], last[0]);
                last[1] = Math.max(newInterval[1], last[1]);
            } else {
                list.add(newInterval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna