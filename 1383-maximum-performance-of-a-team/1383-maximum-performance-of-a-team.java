// class Solution {
//     public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
//         //2
//         //(s1+s2)*(min(e1,e2))
//         //s1=10
//         //e1=4
//         //s2=8
//         //e2=2
//         //15*(2)=30
//         //15*(4)=60
//         //max performance
//         //for i=0...n-1
//         //     eff=min
//         //     for j=0...n-1
//         //           engineers...e>=min
//         //              list.add(speed)
//         //TIME COMPLE:O(n.(n+n.log n))=>O(n^2.logn), O(n)
//          //list.sort
//          //k-1(speed)
//           //speed+
//           //max=max(max,speed*eff)
//           //return max
//         long max=0;
//         for(int i=0;i<n;i++){
//             int eff=efficiency[i];
//             List<Integer> list=new ArrayList<>();
//             for (int j=0;j<n;j++){
//                 if(efficiency[j]>=efficiency[i]&&j!=i){
//                     list.add(speed[j]);
//                 }
//             }
//             Collections.sort(list);
//             //3 7 8 9 12
//             //0 1 2 3 4 
//             //5
//             //k = 2

//             long speedSum=speed[i];
//             for(int j=0;j<Math.min(list.size(),k-1);j++){
//                 speedSum = speedSum + list.get(list.size() - j-1);
//             }
//             max=Math.max(max,speedSum*eff);

//         }
//         return (int)(max% 1000000007);

//         //time limit exceeded error
//     }
// }
class Solution {
   
     public int maxPerformance(int n, int[] speed, int[]
     efficiency, int k){
           long max=0;
          int[][] workerDetails=new int[n][2];
          for(int i=0;i<n;i++){
            workerDetails[i]=new int[]{
                speed[i],
                efficiency[i]
            };
        }
        Arrays.sort(workerDetails,(a,b)->{
            return b[1]-a[1];
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        long speedSum=0;
        for(int i=0;i<n;i++){
            int s = workerDetails[i][0],
                e=workerDetails[i][1];
            if(pq.isEmpty()||pq.size()<k){
               speedSum=speedSum+ s;
               max=Math.max(max,speedSum*e);
               pq.add(s);
               continue;
            }
            if(s>pq.peek()){
                speedSum=speedSum-pq.remove();
                speedSum = speedSum+s;
                max=Math.max(max,speedSum*e);
                pq.add(s);
            }
        }
        return (int)( max % 1000000007);

      }
     }

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna