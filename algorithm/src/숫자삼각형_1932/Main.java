package 숫자삼각형_1932;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //n은 삼각형의 크기
		int[][] triangle = new int[n + 1][n + 1];
		
		triangle[1][1] = sc.nextInt(); // 삼각형의 꼭대기 수를 입력 받음
		
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j ++) {
				if (j == 1) { //삼각형의 왼쪽 꼭지점에 위치
					triangle[i][j] += sc.nextInt() + triangle[i - 1][1];
				} else if (i == j) { //삼각형의 오른쪽 꼭지점에 위치
					triangle[i][j] += sc.nextInt() + triangle[i - 1][j - 1];
				} else { //중간에 위치
					triangle[i][j] += sc.nextInt() + Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
				}
			}
		}
		
		int max = triangle[n][1];
		
		for (int i = 1; i <= n; i++) {
			if (triangle[n][i] > max) {
				max = triangle[n][i];
			}
		}
		System.out.println(max);
		sc.close();
	}
}
