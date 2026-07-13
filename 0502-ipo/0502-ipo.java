// class Solution {
//     public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
//        int cc=w;
//        List<Integer> profitsList=new ArrayList<>();
//        List<Integer> capitalsList=new ArrayList<>();
//        for(int p:profits){
//           profitsList.add(p);
//        }
//        for(int c: capital){
//         capitalsList.add(c);
//        }
//        //choose k projects
//        for(int proj=0;proj<k;proj++){
//         int maxProfitIndex=-1;

//           for(int c=0;c< capitalsList.size();c++){
//              if(capitalsList.get(c)<=cc){
//                 if(maxProfitIndex==-1){
//                     maxProfitIndex=c;
//                     continue;
//                 }
//                if(profitsList.get(c)>profitsList.get( maxProfitIndex)){
//                 maxProfitIndex=c;
//                }
//               }
//            }
//         if(maxProfitIndex==-1){
//             return cc;
//         }
//         cc=cc+profitsList.get(maxProfitIndex);
//         profitsList.remove(maxProfitIndex);
//         capitalsList.remove(maxProfitIndex);

        
//        }

//        return cc; 
//     }
// }

class ProjectDetails {
    int profit;
    int capital;

    public ProjectDetails(int p, int c) {
        this.profit = p;
        this.capital = c;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        ProjectDetails[] pJs = new ProjectDetails[profits.length];

        for (int i = 0; i < profits.length; i++) {
            pJs[i] = new ProjectDetails(profits[i], capital[i]);
        }

        Arrays.sort(pJs, (a, b) -> a.capital - b.capital);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int p = 0;
        int cc = w;

        for (int proj = 0; proj < k; proj++) {

            while (p < pJs.length && cc >= pJs[p].capital) {
                maxHeap.add(pJs[p].profit);
                p++;
            }

            if (maxHeap.size() == 0) {
                return cc;
            }

            cc = cc + maxHeap.poll();
        }

        return cc;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna