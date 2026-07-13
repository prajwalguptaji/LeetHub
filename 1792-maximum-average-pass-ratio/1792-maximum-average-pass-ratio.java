// class Solution {
//     public double maxAverageRatio(int[][] classes, int extraStudents) {
//        for(int i=0;i<extraStudents;i++){
//            int maxGainClassIdx=-1;
//            double maxGain = 0;
//            for(int j=0;j< classes.length;j++){
//                 int passes = classes[j][0],
//                 total= classes[j][1];
//                 double gain = ((double)(passes+1)/(total+1))-((double) (passes)/(total));
//                 if(maxGainClassIdx==-1){
//                     maxGainClassIdx=j;
//                     maxGain=gain;
//                     continue;
//                 }  
//                 if(gain>maxGain){
//                       maxGain = gain;
//                       maxGainClassIdx = j;

//                 }
//             }
//             classes[maxGainClassIdx][0]=classes[maxGainClassIdx][0]+1;
//             classes[maxGainClassIdx][1]=classes[maxGainClassIdx][1]+1;
//         }
//             double res = 0;
//             for(int[] c:classes){
//              res=res+((double) c[0]/c[1]);
//            }
//         return res/ classes.length;
    

//     }
       
// }


class ClassDetails{
    double gain;
    int passes;
    int total;
    public ClassDetails(double g , int p,int t){
        this.gain =g;
        this.passes=p;
        this.total=t;

    }
}
class Solution {
  public double maxAverageRatio(int[][] classes, int extraStudents) {
    PriorityQueue<ClassDetails> maxHeap=new PriorityQueue<ClassDetails>((a,b)-> Double.compare(b.gain,a.gain));
    for(int i=0;i<classes.length;i++){
        int passes = classes[i][0],
            total=classes[i][1];
        double gain = ((double)(passes+1)/(total+1))-((double)(passes)/(total));
        maxHeap.add(new ClassDetails(gain,passes+1,total+1));    
    }
    double totalGain=0;
    for(int i=0;i<extraStudents;i++){
        ClassDetails classInfo = maxHeap.poll();
        totalGain = totalGain + classInfo.gain;
        int passes= classInfo.passes,
            total = classInfo.total;
        double gain =((double) (passes+1)/(total+1))-((double) (passes)/(total));  
         maxHeap.add(new ClassDetails(gain,passes+1,total+1));

     
    }
    double res =0;
    for(int[] c: classes){
        res = res +((double) c[0]/c[1]);
    }
    res=res+totalGain;
    return res/classes.length;
  }
}  

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna