package DP_동물원_1309;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n + 1][3]; // num[i][j] i는 우리의 줄 수 j는 마지막 줄의 사자의 위치
											// j가 0이면 존재하지 않고 1이면 왼쪽에 2면 오른쪽에 존재
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		
		for (int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901 ;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
		}
		
		System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % 9901);
	}
}
