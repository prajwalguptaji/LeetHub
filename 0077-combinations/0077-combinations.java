class Solution {
    public void backtrack(List<Integer> l, int f,int n,int k, List<List<Integer>> res){
        if(l.size()==k){
        res.add(new ArrayList<>(l));
        return;
      }
       
    for(int i=f;i<=n;i++){
            l.add(i);
            backtrack(l,i+1,n,k,res);
            l.remove(l.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> res=new ArrayList<>();
      List<Integer> l=new ArrayList<>();
      backtrack(l,1,n,k,res);
      return res;  
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna