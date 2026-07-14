// class Solution {
//     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    
//     List<List<Integer>> res =new ArrayList<>();
//     for(int i =0;i<nums1.length;i++){
//         for(int j=0;j< nums2.length;j++){
//             List<Integer> temp = new ArrayList<>();
//             temp.add(nums1[i]);
//             temp.add(nums2[j]);
//             res.add(temp);
//         }
//     }
//     Collections.sort(res,(a,b)-> (a.get(0)+a.get(1))-(b.get(0)+b.get(1)));
//     List<List<Integer>> out = new ArrayList<>();
//     for(int i=0;i<k;i++){
//         out.add(res.get(i));
//     }
//     return out;
//     }
// }
 class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> res = new ArrayList<>();

        if(nums1.length == 0 || nums2.length == 0 || k == 0)
            return res;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);

        Set<Pair<Integer,Integer>> visited = new HashSet<>();

        minHeap.add(new int[]{
            nums1[0]+nums2[0],
            0,
            0
        });

        visited.add(new Pair<>(0,0));

        int counter = 0;

        while(counter < k && !minHeap.isEmpty()) {

            int[] ele = minHeap.remove();

            int i = ele[1];
            int j = ele[2];

            res.add(Arrays.asList(nums1[i], nums2[j]));

            if(i+1 < nums1.length){
                Pair<Integer,Integer> pair = new Pair<>(i+1,j);

                if(!visited.contains(pair)){
                    minHeap.add(new int[]{
                        nums1[i+1] + nums2[j],
                        i+1,
                        j
                    });
                    visited.add(pair);
                }
            }

            if(j+1 < nums2.length){
                Pair<Integer,Integer> pair = new Pair<>(i,j+1);

                if(!visited.contains(pair)){
                    minHeap.add(new int[]{
                        nums1[i] + nums2[j+1],
                        i,
                        j+1
                    });
                    visited.add(pair);
                }
            }

            counter++;
        }

        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna