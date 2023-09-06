//LeetCode - 509

import java.util.Arrays;

public class FibonacciNumber {
    static int dp[];
    public static int fibNumber(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n);
    }

    public static int solve(int n) {
        if(n == 0) return 0;
        if(n ==1 ) return 1;

        if(dp[n] != -1) return dp[n];

        return dp[n] = solve(n-1) + solve(n-2);
    }
    public static void main(String[] args) {
        System.out.println(fibNumber(10));
    }
}
