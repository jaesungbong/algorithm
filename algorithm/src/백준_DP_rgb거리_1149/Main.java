package 백준_DP_rgb거리_1149;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //집의 수
		int[][] price = new int[3][n]; //마지막 집의 색에 따라 결정되는 최소비용
		
		price[0][0] = sc.nextInt(); //마지막 집이 빨간색일 때 첫번쨰 집을 칠하는 비용
		price[1][0] = sc.nextInt(); //마지막 집이 초록색일 때 첫번째 집을 칠하는 비용
		price[2][0] = sc.nextInt(); //마지막 집이 파랑색일 때 첫번재 집을 칠하는 비용
		
		for (int i = 1; i < n; i++) {
			price[0][i] += sc.nextInt() + Math.min(price[1][i - 1], price[2][i - 1]);
			price[1][i] += sc.nextInt() + Math.min(price[0][i - 1], price[2][i - 1]);
			price[2][i] += sc.nextInt() + Math.min(price[0][i - 1], price[1][i - 1]);
		}
		
		System.out.println(Math.min(Math.min(price[0][n - 1], price[1][n - 1]), price[2][n - 1]));
	}
}
