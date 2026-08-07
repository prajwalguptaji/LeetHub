// class Solution {

//     public List<String> generateParenthesis(int n) {

//         List<String> ans = new ArrayList<>();

//         helper("", 0, 0, n, ans);

//         return ans;
//     }

//     void helper(String s, int open, int close, int n,
//                 List<String> ans) {

//         if (s.length() == 2 * n) {
//             ans.add(s);
//             return;
//         }

//         // Add '('
//         if (open < n) {
//             helper(s + "(", open + 1, close, n, ans);
//         }

//         // Add ')'
//         if (close < open) {
//             helper(s + ")", open, close + 1, n, ans);
//         }
//     }
// }
class Solution {
    public static void generator(int n,int l,int r,String s,List<String> ans){
        if(r==n){
            ans.add(s);
            return;
        }
        if(l<n) generator(n,l+1,r,s+"(",ans);
        if(r<l) generator(n,l,r+1,s+")",ans); 
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        generator(n,0,0,"",ans);
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna