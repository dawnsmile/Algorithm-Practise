class LCS {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] inc = nums;
        Arrays.sort(inc); 
        int[][] dp = new int[nums.length+1][nums.length+1];
        for (int i=0;i<=nums.length;i++){
            dp[0][i] = 0;
            dp[i][0] = 0;
        }
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length;j++){
                if (nums[i] == inc[j]){
                    dp[i+1][j+1] = dp[i][j]+1;
                }
                else
                    dp[i+1][j+1]=Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
        res = dp[nums.length][nums.length];
        return res;
    }
}