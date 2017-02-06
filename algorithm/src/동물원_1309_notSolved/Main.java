package 동물원_1309_notSolved;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] num = new int[n + 1][n + 1]; // num[i][j]는 i줄의 우리에 j마리의 사자를 배치 할때의 경우의 수
		num[1][0] = 1;
		num[1][1] = 2;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					num[i][j] = 1; //i줄의 우리에 0마리를 배치하는 경우 1가지
				} else if (j == 1) {
					num[i][j] = i * 2; //i줄의 우리에 1마리를 배치하는 경우는 i * 2가지
				} else if (j == i) {
					num[i][j] = 2; //i줄의 우리에 i마리를 배치하는 경우 2가지
				} else {
					num[i][j] = num[i - 1][j] * 2 + i + 1;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			sum += num[n][i];
		}
		System.out.println(sum % 9901);
	}
}
