package 백준_DP_연속합_1912;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n + 1];
		int[] log = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			num[i] = sc.nextInt();
		}
		
		log[1] = num[1];
		int result = log[1];
		
		for (int i = 2; i <= n; i++) {
			log[i] = Math.max(num[i] + log[i - 1], num[i]);
			result = Math.max(result, log[i]);
		}

		System.out.println(result);
		sc.close();
	}
}
