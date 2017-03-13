package 백준_DP_극장좌석_2302;

import java.util.Scanner;

public class Main {
	static int[] dp = new int[41]; //좌석의 수에 따라 앉을 수 있는 경우의 수
	static int[] vip = new int[41]; //vip 좌석 번호
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //좌석의 자리 수
		int m = sc.nextInt(); //VIP석의 자리 수
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		int num = 1; //앉을 수 있는 경우의 수
		
		for (int i = 1; i <= m; i++) {
			vip[i] = sc.nextInt();
			num *= dp[vip[i] - vip[i - 1] - 1];
		}
		num *= dp[n - vip[m]];
		
		System.out.println(num);
		sc.close();
	}
}
