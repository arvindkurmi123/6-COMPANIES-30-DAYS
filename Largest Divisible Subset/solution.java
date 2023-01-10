class solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        if(nums.length == 0)    return res;
        Arrays.sort(nums);
        int[] Dp = new int[nums.length];    
        for(int i = 0; i < nums.length; i++)    Dp[i] = 1;
        
        // dp
        int maximum = 1;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    Dp[i] = Math.max(Dp[i], Dp[j] + 1);
                    maximum = Math.max(maximum, Dp[i]);
                }
            }
        }
        
        int i = nums.length - 1;
        int prev = -1;
        while(maximum >= 1) {
            if(prev == -1 && Dp[i] == maximum) {             
                res.add(nums[i]);
                prev = nums[i];
                maximum--;  
            }else if(Dp[i] == maximum && prev % nums[i] == 0) {
                res.add(nums[i]);
                prev = nums[i];
                maximum--;
            }
            i--;
        }
        return res;
        
        
    }
}