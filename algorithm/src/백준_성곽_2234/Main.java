package 백준_성곽_2234;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int m; // 열
	static int n; // 행
	static String room[][];
	static int visit[][];
	static int roomsNum = 1;
	static int[] xRange = { 1, 0, -1, 0 }; // 남동북서
	static int[] yRange = { 0, 1, 0, -1 }; // 남동북서

	static int search(int i, int j) {
		int roomSize = 1; // 현재 방의 사이즈
		visit[i][j] = roomsNum; // 방문 true
		char[] roomInfo = room[i][j].toCharArray();

		for (int d = 0; d < 4; d++) {
			int moveX = xRange[d] + i;
			int moveY = yRange[d] + j;
			// 각 방향의 벽이 뚫려있고 범위내에 있으며 방문하지 않았을 경우
			if (roomInfo[d] == '0' && 1 <= moveX && moveX <= n && 1 <= moveY && moveY <= m
					&& visit[moveX][moveY] == 0) {
				roomSize += search(moveX, moveY);
			}
		}
		return roomSize;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt(); // 열 입력
		n = sc.nextInt(); // 행 입력
		room = new String[n + 1][m + 1];
		visit = new int[n + 1][m + 1];

		ArrayList<Integer> roomsSizes = new ArrayList<Integer>(); // 방의 크기

		for (int i = 1; i <= n; i++) { // 각 방의 정보 입력
			for (int j = 1; j <= m; j++) {
				String roomInfo = Integer.toBinaryString(sc.nextInt());
				while (roomInfo.length() != 4) {
					roomInfo = "0" + roomInfo;
				}
				room[i][j] = roomInfo;
			}
		}

		for (int i = 1; i <= n; i++) { // 탐색 시작
			for (int j = 1; j <= m; j++) {
				if (visit[i][j] == 0) { // 방문하지 않은 방이라면
					roomsSizes.add(search(i, j)); // 탐색
					roomsNum++;
				}
			}
		}

		ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[roomsNum];
		for (int i = 1; i < roomsNum; i++) {
			a[i] = new ArrayList<>();
		}

		// 연결된 방들의 연결 정보
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				for (int d = 0; d < 4; d++) {
					int moveX = xRange[d] + i;
					int moveY = yRange[d] + j;
					if (1 <= moveX && moveX <= n && 1 <= moveY && moveY <= m && visit[moveX][moveY] != visit[i][j]) {
						if (!a[visit[i][j]].contains(visit[moveX][moveY])) {
							a[visit[i][j]].add(visit[moveX][moveY]);
						}
					}
				}
			}
		}

		int maxSizeOfremoveWall = 0;

		// 벽을 제거했을 때 가장 큰 방 구하기
		for (int i = 1; i < roomsNum; i++) {
			for (int j = 0; j < a[i].size(); j++) {
				maxSizeOfremoveWall = Math.max(maxSizeOfremoveWall,
						roomsSizes.get(i - 1) + roomsSizes.get(a[i].get(j) - 1));
			}
		}

		Collections.sort(roomsSizes); // 오름차순으로 정렬 후
		Collections.reverse(roomsSizes); // 순서를 거꾸로하기

		System.out.println(roomsNum - 1); // 방의 개수
		System.out.println(roomsSizes.get(0)); // 가장 넓은 방의 넓이
		System.out.println(maxSizeOfremoveWall); // 벽을 제거했을 때 가장 큰 방

		sc.close();
	}
}
