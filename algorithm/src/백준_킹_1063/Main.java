package 백준_킹_1063;

import java.util.Scanner;

public class Main {
	// 우, 좌, 하, 상
	static int[] dx = { 1, -1, 0, 0 };
	// 우, 좌, 하, 상
	static int[] dy = { 0, 0, -1, 1 };

	public static int setDirection(char x) {
		if (x == 'R') { // 한칸 오른쪽
			return 0;
		} else if (x == 'L') { // 한칸 왼쪽으로
			return 1;
		} else if (x == 'B') { // 한칸 아래로
			return 2;
		} else { // 한칸 위로
			return 3;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] lok = sc.next().toCharArray();
		char[] los = sc.next().toCharArray();
		int kingX = (int) (lok[0] - 64); // king의 X위치
		int kingY = (int) (lok[1] - 48); // king의 Y위치
//		System.out.println(kingX + ", " + kingY);
		int stoneX = (int) (los[0] - 64); // stone의 X위치
		int stoneY = (int) (los[1] - 48); // stone의 X위치
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			char[] direction = sc.next().toCharArray();
			int moveX = dx[setDirection(direction[0])];
			int moveY = dy[setDirection(direction[0])];
			if (direction.length == 2) {
				moveX += dx[setDirection(direction[1])];
				moveY += dy[setDirection(direction[1])];
			}
			// 킹을 움직였을 때 돌의 위치랑 같게 될 경우
			int tempKingX = kingX + moveX;
			int tempKingY = kingY + moveY;
			if ((tempKingX == stoneX) && (tempKingY == stoneY)) {
				// 돌을 움직였을 때 돌의 위치가 범위를 벗어나지 않는 경우
				if (1 <= (stoneX + moveX) && (stoneX + moveX) <= 8 && 1 <= (stoneY + moveY) && (stoneY + moveY) <= 8) {
					kingX = tempKingX;
					kingY = tempKingY;
					stoneX += moveX;
					stoneY += moveY;
				}
			} else { // 킹을 움직였을 때 돌의 위치랑 다른 경우
				// 킹을 움직였을 때 킹의 위치가 범위를 벗어나지 않는 경우
				if (1 <= (kingX + moveX) && (kingX + moveX) <= 8 && 1 <= (kingY + moveY) && (kingY + moveY) <= 8) {
					kingX = tempKingX;
					kingY = tempKingY;
				}
			}
		}
		sc.close();
		System.out.println(((char) (kingX + 64)) + "" + kingY);
		System.out.println(((char) (stoneX + 64)) + "" + stoneY);
	}
}
