class Solution {
    public int kthSmallest(int[][] matrix, int k) {
       int N = matrix.length; 
       PriorityQueue<int[]>minHeap=new PriorityQueue<>((a,b)->a[0]-b[0]);
       for(int i=0;i<matrix.length;i++){
        minHeap.add(new int[]{
            matrix[i][0],
            i,
            0
        });
       } 
       int counter=1;
       while(!minHeap.isEmpty()){
           int[] ele=minHeap.poll();
           int val=ele[0],
               listId=ele[1],
               eleId= ele[2];
           if(counter==k){
              return val;
           }
           counter=counter+1;
           int nextEleId =eleId+1;
           if(nextEleId < N){
              minHeap.add(new int[]{
                 matrix[listId][nextEleId],
                 listId,
                 nextEleId
              });

           }
       }
       return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna