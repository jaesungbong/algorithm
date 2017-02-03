package rgbStreet_1149_notSolved;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 집의 수
		int price[][] = new int[n][3]; // price[n][m] n번째 집의 m번째(0:red, 1:green,
										// 2:blue) 색을 칠하는데 드는 비용
		int sum[] = new int[3]; // 첫번재집을 빨강으로 칠할경우 sum[0], 초록일 경우 sum[1], 파랑일 경우
								// sum[2]에 모든집을 칠하는데 드는 비용을 저장.

		for (int i = 0; i < n; i++) { // 각 비용을 입력받음
			for (int j = 0; j < 3; j++) {
				price[i][j] = sc.nextInt();
			}
		}
	}
}
