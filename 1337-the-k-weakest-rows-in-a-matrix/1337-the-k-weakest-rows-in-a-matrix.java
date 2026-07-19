class Solution {
    public int binarySearch(int[] arr){
        int low=0,high=arr.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(arr[mid]==1){
               low=mid+1; 
            }
            else{
                high=mid;
            }
        }
        return arr[low]==1?arr.length : low;
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int [][] rowDetails= new int[mat.length][2];

        for(int i=0;i<mat.length;i++){
            rowDetails[i][0]=binarySearch(mat[i]);
            rowDetails[i][1]=i;
        }
        Arrays.sort(rowDetails,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=rowDetails[i][1];
        }
        return res;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna