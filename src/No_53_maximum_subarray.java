import static java.lang.Math.max;

/**
 * @author Steve
 * Created on 2020-04
 */
public class No_53_maximum_subarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[i-1] > 0) {
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            res = max(dp[i], res);
        }
        return res;
    }
}
