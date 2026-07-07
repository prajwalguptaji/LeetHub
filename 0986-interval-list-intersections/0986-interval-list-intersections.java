class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
       List<int[]>res= new ArrayList<>();
       int i=0,j=0;
       while(i<firstList.length&&j<secondList.length){
          // Intersection -- e1>=s2&&e2>=s1
          //firstList[i]={0,2},  firstList[i][0]=s1=0
          //secondList[j]={1,5},  secondList[j][1]=e2=5

             int e1=firstList[i][1],e2=secondList[j][1],s1=firstList[i][0],s2=secondList[j][0];
             int start=Math.max(s1,s2);
             int end = Math.min(e1,e2);
             if(start<=end){
                res.add(new int[]{start,end});
             }
             if(e1<e2)
                i++;
             else
                j++;   
                  
       } 
       return res.toArray(new int[res.size()][]);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna