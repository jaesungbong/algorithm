package 동물원_1309_notSolved;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] num = new int[n + 1][3]; // num[i][j] i는 우리의 줄 수, j는 마지막 줄의 사자의 위치
											// j가 0이면 존재하지 않고 1이면 왼쪽에 2면 오른쪽에 존재
		num[1][0] = 1;
		num[1][1] = 1;
		num[1][2] = 1;
		
		for (int i = 2; i <= n; i++) {
			num[i][0] = (num[i - 1][0] + num[i - 1][1] + num[i - 1][2]) % 9901;
			num[i][1] = (num[i - 1][0] + num[i - 1][2]) % 9901 ;
			num[i][2] = (num[i - 1][0] + num[i - 1][1]) % 9901;
		}
		
		System.out.println((num[n][0] + num[n][1] + num[n][2]) % 9901);
	}
}
