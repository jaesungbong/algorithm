package DP_사탕가게_4781;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt(); // 사탕의 종류 수
			int m = (int) (sc.nextDouble() * 100); // 가진 돈
			if (n == 0 && m == 0) {
				break;
			}
			int dp[] = new int[10001]; // dp[i]는 가격i에서 얻을 수 있는 최대 칼로리 
			for (int i = 1; i <= n; i++) {
				int cal = sc.nextInt(); //칼로리 입력
				int price = (int) (sc.nextDouble() * 100); //가격 입력
				for (int j = price; j <= m; j++) {
					dp[j] = Math.max(dp[j], dp[j] = dp[j - price] + cal);
				}
			}
			System.out.println(dp[m]);
		}
		sc.close();
	}
}
