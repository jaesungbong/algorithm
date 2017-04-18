package 백준_DP_내리막길_1520;

import java.util.Scanner;

public class Main {
	static int[][] stair = new int[501][501];
	static int m, n;
	static int[] moveX = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] moveY = { 0, 0, -1, 1 }; // 상, 하, 좌, 우

	static int search(int x, int y) {
		if (x == m && y == n)
			return 1;
		int visit = 0;
		for (int i = 0; i < 4; i++) {
			int movedX = x + moveX[i];
			int movedY = y + moveY[i];
			if ((1 <= movedX) && (movedX <= m) && (1 <= movedY) && (movedY <= n)
					&& (stair[x][y] > stair[movedX][movedY])) {
				visit += search(movedX, movedY);
			}
		}
		return visit;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				stair[i][j] = sc.nextInt();
			}
		}
		System.out.println(search(1, 1));
		sc.close();
	}
}
