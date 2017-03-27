package 백준_DP_LCS_9251;

import java.util.Scanner;

public class Main {
	static char[] charA = new char[1000];
	static char[] charB = new char[1000];
	static int[][] dp = new int[1000][1000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		charA = sc.nextLine().toCharArray();
		charB = sc.nextLine().toCharArray();
		for (int i = 1; i <= charA.length; i++) {
			for (int j = 1; j <= charB.length; j++) {
				if (charA[i - 1] == charB[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		System.out.println(dp[charA.length][charB.length]);
		sc.close();
	}
}