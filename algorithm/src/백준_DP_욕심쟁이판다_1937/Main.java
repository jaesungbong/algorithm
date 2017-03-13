package DP_욕심쟁이판다_1937;

import java.util.Scanner;

public class Main {
	static int[][] forest = new int[501][501];
	static int[][] forestsMax = new int[501][501];
	static int n;
	static int[] xRange = { -1, 1, 0, 0 }; // 상하좌우
	static int[] yRange = { 0, 0, -1, 1 }; // 상하좌우

	static int search(int x, int y) {
		if (forestsMax[x][y] == 0) {
			forestsMax[x][y] = 1;
			for (int i = 0; i < 4; i++) {
				int moveX = x + xRange[i];
				int moveY = y + yRange[i];
				if ((1 <= moveX) && (moveX <= n) && (1 <= moveY) && (moveY <= n)
						&& (forest[x][y] < forest[moveX][moveY])) {
					forestsMax[x][y] = Math.max(forestsMax[x][y], search(moveX, moveY) + 1);
				}
			}
		}
		return forestsMax[x][y];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				forest[i][j] = sc.nextInt();
			}
		}

		int max = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				max = Math.max(max, search(i, j));
			}
		}
		System.out.println(max);
		sc.close();
	}
}
