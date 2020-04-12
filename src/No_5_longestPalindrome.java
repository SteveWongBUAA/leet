/**
 * @author Steve
 * Created on 2020-04
 * <p>
 * 需要用动态规划吧。
 * 动态规划思路
 * 可以先从回溯法开始，有感觉的话也可以先从造状态方程开始
 * 假设dp[i][j] 的意思是 从i-j的最长回文子串
 * <p>
 * 初始化：
 * d[i][i] = true, 一元组
 * d[i][i+1] = true, if s[i]==s[i+1] （检查二元组并初始化）
 * d[i][j] = true, if d[i+1][j-1] == true and if s[i] == s[j]
 * 从状态转移方程可以看出，i,j的状态受i+i,j-1影响，所以遍历的时候应该i从大到小，j从小到大
 * <p>
 * 用变量保存当前的最长的回文串，每次遇到更长的回文串都更新
 */
public class No_5_longestPalindrome {
    public static String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        // 填表
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j
                        || (j == i + 1 && s.charAt(i) == s.charAt(j))
                        || (j - i >= 2 && dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j))) {
                    dp[i][j] = true;
                    if (res.length() < j - i + 1) {
                        res = s.substring(i, j + 1);
                    }

                }

            }
        }

        return res;
    }

    public static void main(String[] args) {
        longestPalindrome("aaaa");

    }
}
