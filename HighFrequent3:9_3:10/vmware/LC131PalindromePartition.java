import java.util.ArrayList;

class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for (int j=i;j<n;j++){
                if (i+1>=n || j-1<0)
                    continue;
                if(j == i){
                    dp[i][j] = true;
                    continue;
                }
                if (j == i+1 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                }
                if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j))
                    dp[i][j] = true;
            }
        }
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();


        dfs(0,n,s,res,new ArrayList<String>());
        return res;



    }
    public void dfs(int start,int n,String s,ArrayList<ArrayList<String>> res,ArrayList<String> tmp){
        if (start == n){
            res.add(tmp);
            return;
        }
        for (int i = start;i<n;i++){
            if (dp[start][i]){
                ArrayList<String> a = new ArrayList<String>(tmp);
                tmp.add(s.substring(start, i+1));
                dfs(i+1,n,s,res,tmp);
            }
        }
    }
}